/*
 * Copyright (c) 2020. Kin-Hong Wong. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.easymobo.openlabeler.preference;

import com.easymobo.openlabeler.tensorflow.TFTrainer;
import com.easymobo.openlabeler.ui.InputFileChooser;
import com.easymobo.openlabeler.util.AppUtils;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.fxmisc.easybind.EasyBind;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainingPane extends VBox implements Category
{
    @FXML
    private InputFileChooser dirTFImage, dirTFAnnotation, dirTFData, dirTFBaseModel;
    @FXML
    private TextField txtTrainBatchSize, txtDockerImage, txtContainerHostName, txtContainerName;
    @FXML
    private LabelMapPane labelMapPane;
    @FXML
    private Label labelNumSamples, labelModelType, labelTrainCkpt, labelDockerProcess;
    @FXML
    private FontIcon iconWarn;
    @FXML
    private Button btnCreateTrainData;
    @FXML
    private HBox boxTrain;

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());

    private final BooleanProperty dirtyProperty =  new SimpleBooleanProperty(false);
    private ResourceBundle bundle = ResourceBundle.getBundle("bundle");

    private TFTrainer.PipelineConfig config;

    public TrainingPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/preference/TrainingPane.fxml"), bundle);
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (Exception ex) {
            LOG.log(Level.SEVERE, "Unable to load FXML", ex);
        }

        bindProperties();
        load();
    }

    @Override
    public BooleanProperty dirtyProperty() {
        return dirtyProperty;
    }
    public boolean isDirty() {
        if (!TFTrainer.getLabelMapPath(dirTFData.getText()).toFile().exists()) {
            return true;
        }
        if (!TFTrainer.getModelConfigPath(dirTFBaseModel.getText()).toFile().exists()) {
            return true;
        }
        return dirtyProperty.get();
    }

    @Override
    public String getName() {
        return bundle.getString("label.train");
    }

    @Override
    public void load() {
        dirTFImage.setText(Settings.getTFImageDir());
        dirTFAnnotation.setText(Settings.getTFAnnotationDir());
        dirTFData.setText(Settings.getTFDataDir());
        dirTFBaseModel.setText(Settings.getTFBaseModelDir());
        txtTrainBatchSize.setText(String.valueOf(Settings.getTFTrainBatchSize()));
        txtDockerImage.setText(Settings.getDockerImage());
        txtContainerHostName.setText(Settings.getContainerHostName());
        txtContainerName.setText(Settings.getContainerName());
    }

    @Override
    public void save() {
        if (!isDirty()) {
            return;
        }
        Settings.setTFImageDir(dirTFImage.getText());
        Settings.setTFAnnotationDir(dirTFAnnotation.getText());
        Settings.setTFDataDir(dirTFData.getText());
        Settings.setTFBaseModelDir(dirTFBaseModel.getText());
        Settings.setTFTrainBatchSize(Integer.valueOf(txtTrainBatchSize.getText()));
        Settings.setDockerImage(txtDockerImage.getText());
        Settings.setContainerHostName(txtContainerHostName.getText());
        Settings.setContainerName(txtContainerName.getText());
        try {
            TFTrainer.saveLabelMap(labelMapPane.getItems(), dirTFData.getText());
            config.save();
        }
        catch (IOException ex) {
            LOG.log(Level.SEVERE, "Unable to save changes", ex);
        }
    }

    public void onCreateTrainData(ActionEvent actionEvent) {
        Settings.setTFImageDir(dirTFImage.getText());
        Settings.setTFAnnotationDir(dirTFAnnotation.getText());
        Settings.setTFDataDir(dirTFData.getText());
        File dataDir = new File(Settings.getTFDataDir());
        if (dataDir.isDirectory() && dataDir.exists()) {
            var res = AppUtils.showConfirmation(bundle.getString("label.alert"), bundle.getString("msg.confirmCreateTrainData"));
            if (res.get() != ButtonType.OK) {
                return;
            }
        }
        btnCreateTrainData.setDisable(true);
        TFTrainer.createTrainData(labelMapPane.getItems());
        AppUtils.showInformation(bundle.getString("label.alert"), bundle.getString("msg.trainDataCreated"));
        btnCreateTrainData.setDisable(false);
    }

    private void bindProperties() {
        // Update on any directory changes
        dirTFImage.textProperty().addListener((observable, oldValue, newValue) -> updateNumSamples());
        dirTFAnnotation.textProperty().addListener((observable, oldValue, newValue) -> updateNumSamples());
        dirTFData.textProperty().addListener((observable, oldValue, newValue) -> updateLabelMap());
        dirTFBaseModel.textProperty().addListener((observable, oldValue, newValue) -> updateTraining());

        txtTrainBatchSize.setTextFormatter(AppUtils.createNumberTextFormatter());

        BooleanBinding changes[] = {
                dirTFImage.textProperty().isNotEqualTo(Settings.tfImageDirProperty),
                dirTFAnnotation.textProperty().isNotEqualTo(Settings.tfAnnotationDirProperty),
                dirTFData.textProperty().isNotEqualTo(Settings.tfDataDirProperty),
                new SimpleListProperty(labelMapPane.getItems()).isNotEqualTo(
                        FXCollections.observableList(TFTrainer.getLabelMapItems(dirTFData.getText()))),
                dirTFBaseModel.textProperty().isNotEqualTo(Settings.tfBaseModelDirProperty),
              txtTrainBatchSize.textProperty().isNotEqualTo(Settings.tfTrainBatchSizeProperty.asString()),
                txtDockerImage.textProperty().isNotEqualTo(Settings.dockerImageProperty),
                txtContainerHostName.textProperty().isNotEqualTo(Settings.containerHostNameProperty),
                txtContainerName.textProperty().isNotEqualTo(Settings.containerNameProperty),
        };
        dirtyProperty.unbind();
        dirtyProperty.bind(EasyBind.combine(
                FXCollections.observableArrayList(changes), stream -> stream.reduce((a, b) -> a | b).orElse(false)));
    }

    private void updateNumSamples() {
        int num = 0;
        if (dirTFImage.toFile().exists() && dirTFAnnotation.toFile().exists()) {
            num = dirTFAnnotation.toFile().listFiles((dir, name) -> {
                name = name.toLowerCase();
                return name.endsWith(".xml");
            }).length;
        }
        labelNumSamples.setText(String.valueOf(num));
    }

    private void updateLabelMap() {
        labelMapPane.getItems().clear();
        labelMapPane.getItems().addAll(TFTrainer.getLabelMapItems(dirTFData.getText()));
        bindProperties();
    }

    private void updateTraining() {
    new Thread(() -> {
            // Training controls
            String baseModelDir = dirTFBaseModel.getText();

            var info = TFTrainer.getInfo();

            config = new TFTrainer.PipelineConfig(baseModelDir);
            var modelType = config.getType() == null ? bundle.getString("msg.notFound") : config.getType();

            List<Button> buttons = new ArrayList();

            int checkpoint = TFTrainer.getTrainCkpt(baseModelDir);
            var trainCkpt = checkpoint < 0 ? bundle.getString("msg.notFound") : String.valueOf(checkpoint);
            if (checkpoint > 0) {
                Button btn = new Button(bundle.getString("label.exportGraph"));
                btn.setOnAction(event -> exportGraph(btn, checkpoint));
                buttons.add(btn);
            }

            boolean canTrain = TFTrainer.canTrain(dirTFData.getText(), dirTFBaseModel.getText());
            if (canTrain) {
                if (TFTrainer.isTraining()) {
                    Button btn = new Button(bundle.getString("label.stopTrain"));
                    btn.setOnAction(event -> train(false, false));
                    buttons.add(btn);
                }
                else {
                    Button btn1 = new Button(bundle.getString("label.continueTrain"));
                    btn1.setOnAction(event -> train(true, false));
                    Button btn2 = new Button(bundle.getString("label.restartTrain"));
                    btn2.setOnAction(event -> train(true, true));
                    buttons.addAll(Arrays.asList(btn1, btn2));
                }
            }
            else {
                Button btn = new Button(bundle.getString("label.startTrain"));
                btn.setOnAction(event -> train(true, true));
                btn.disableProperty().bind(Bindings.or(dirTFData.textProperty().isEmpty(), Bindings.or(dirTFImage.textProperty().isEmpty(), dirTFAnnotation.textProperty().isEmpty())));
                buttons.add(btn);
            }

            Platform.runLater(() -> {
                iconWarn.setVisible(info == null);
                labelDockerProcess.setText(info == null ? bundle.getString("msg.dockerProcessError") : String.format("%s, %s", info.getName(), info.getServerVersion()));
                labelModelType.setText(modelType);
                labelTrainCkpt.setText(trainCkpt);
                boxTrain.getChildren().clear();
                boxTrain.getChildren().addAll(buttons);
            });
        }, "Training Updater").start();
    }

    private void exportGraph(Button source, int checkpoint) {
        save();
        TFTrainer.exportGraph(checkpoint);
        AppUtils.showInformation(bundle.getString("label.alert"), MessageFormat.format(bundle.getString("msg.exportGraph"), checkpoint));
        source.setDisable(true);
    }

    private void train(boolean start, boolean restart) {
        save();
        TFTrainer.train(start, restart);
        AppUtils.showInformation(bundle.getString("label.alert"),
                bundle.getString(start ? (restart ? "msg.startTrain" : "msg.continueTrain") : "msg.stopTrain"));
        updateTraining();
    }
}
