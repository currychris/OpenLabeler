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

package com.easymobo.openlabeler.util;

import com.easymobo.openlabeler.preference.Settings;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.IntStream;

import static com.easymobo.openlabeler.OpenLabeler.APP_CSS;
import static com.easymobo.openlabeler.OpenLabeler.APP_ICON;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class AppUtils
{
   public static void fireKeyPressedEvent(Node target, KeyCode code) {
      KeyEvent event = new KeyEvent(KeyEvent.KEY_PRESSED, KeyEvent.CHAR_UNDEFINED, "", code, false, false, false, false);
      target.fireEvent(event);
      event.consume();
   }

   public static File getAnnotationFile(File media) {
      Path parent = Paths.get(media.getParent());
      if (StringUtils.isNotEmpty(Settings.getAnnotationDir())) {
         parent = Paths.get(parent.toString(), Settings.getAnnotationDir());
         parent = parent.normalize();
      }
      String path = parent + File.separator + FilenameUtils.getBaseName(media.getName()) + ".xml";
      return new File(path);
   }

   public static void watchAndUpdate(WatchService watcher, String name, Function<Path, Void> update) {
      new Thread(() -> {
         try {
            WatchKey key;
            while ((key = watcher.take()) != null) {
               for (WatchEvent<?> event : key.pollEvents()) {
                  if (event.kind() == OVERFLOW) {
                     continue;
                  }
                  update.apply((Path) event.context());
               }
               // reset the key
               boolean valid = key.reset();
               if (!valid) {
                  break;
               }
            }
         }
         catch (Exception ex) {
            return;
         }
      }, name).start();
   }

   public static class EditableTableCell<S, T> extends TableCell<S, T>
   {
      protected TextField textField;
      protected ChangeListener<? super Boolean> changeListener;
      protected final StringConverter<T> converter;

      public EditableTableCell(StringConverter<T> converter) {
         this.converter = converter;
         changeListener = (observable, oldValue, newValue) -> {
            if (!newValue) {
               commitEdit(converter.fromString(textField.getText()));
            }
         };
      }

      @Override
      public void startEdit() {
         if (!editableProperty().get()) {
            return;
         }
         if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            Platform.runLater(() -> {
               textField.requestFocus();
               textField.selectAll();
            });
         }
      }

      @Override
      public void cancelEdit() {
         super.cancelEdit();
         setText(converter.toString(getItem()));
         setGraphic(null);
      }

      @Override
      public void updateItem(T item, boolean empty) {
         super.updateItem(item, empty);

         if (empty) {
            setText(null);
            setGraphic(null);
         }
         else {
            if (isEditing()) {
               if (textField != null) {
                  textField.setText(getString());
                  textField.selectAll();
               }
               setText(null);
               setGraphic(textField);
            }
            else {
               setText(getString());
               setGraphic(null);
            }
         }
      }

      protected void createTextField() {
         textField = new TextField(getString());
         textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
         textField.focusedProperty().addListener(changeListener);
         textField.setOnAction(evt -> commitEdit(converter.fromString(textField.getText())));

         textField.setOnKeyPressed(ke -> {
            switch (ke.getCode()) {
               case ESCAPE:
                  textField.focusedProperty().removeListener(changeListener);
                  cancelEdit();
                  break;
               case TAB:
                  commitEdit(converter.fromString(textField.getText()));
                  editNextCell(!ke.isShiftDown());
                  break;
            }
         });
      }

      protected String getString() {
         return getItem() == null ? "" : getItem().toString();
      }

      private void editNextCell(boolean forward) {
         List<TableColumn<S, ?>> columns = new ArrayList<>();
         for (TableColumn<S, ?> column : getTableView().getColumns()) {
            columns.addAll(getLeaves(column));
         }
         // There is no other column that supports editing.
         if (columns.size() < 2) {
            return;
         }
         int rowIndex = getTableRow().getIndex();
         int colIndex = columns.indexOf(getTableColumn());
         if (forward) {
            colIndex++;
            if (colIndex > columns.size() - 1) {
               colIndex = 0;
               rowIndex++;
               if (rowIndex > getTableView().getItems().size() - 1) {
                  rowIndex = 0;
               }
            }
         }
         else {
            colIndex--;
            if (colIndex < 0) {
               colIndex = columns.size() - 1;
               rowIndex--;
               if (rowIndex < 0) {
                  rowIndex = getTableView().getItems().size() - 1;
               }
            }
         }
         getTableView().getSelectionModel().clearSelection(rowIndex, columns.get(colIndex));
         getTableView().edit(rowIndex, columns.get(colIndex));
      }

      private List<TableColumn<S, ?>> getLeaves(TableColumn<S, ?> root) {
         List<TableColumn<S, ?>> columns = new ArrayList<>();
         if (root.getColumns().isEmpty()) {
            // We only want the leaves that are editable.
            if (root.isEditable()) {
               columns.add(root);
            }
            return columns;
         }
         else {
            for (TableColumn<S, ?> column : root.getColumns()) {
               columns.addAll(getLeaves(column));
            }
            return columns;
         }
      }
   }

   public static class ColorTableCell<T> extends TableCell<T, Color>
   {
      private final ColorPicker colorPicker;

      public ColorTableCell(TableColumn<T, Color> column) {
         colorPicker = new ColorPicker();
         colorPicker.editableProperty().bind(column.editableProperty());
         colorPicker.disableProperty().bind(column.editableProperty().not());
         colorPicker.setOnShowing(event -> {
            final TableView<T> tableView = getTableView();
            tableView.getSelectionModel().select(getTableRow().getIndex());
            tableView.edit(tableView.getSelectionModel().getSelectedIndex(), column);
         });
         colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (isEditing()) {
               commitEdit(newValue);
            }
         });
         setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      }

      @Override
      protected void updateItem(Color item, boolean empty) {
         super.updateItem(item, empty);

         setText(null);
         if (empty) {
            setGraphic(null);
         }
         else {
            colorPicker.setValue(item);
            setGraphic(this.colorPicker);
         }
      }
   }

   public static Alert createAlert(AlertType type, String title, String message) {
      Alert alert = new Alert(type);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);

      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(AppUtils.class.getResource(APP_CSS).toExternalForm());
      Stage stage = (Stage)dialogPane.getScene().getWindow();
      stage.getIcons().add(new Image(AppUtils.class.getClassLoader().getResourceAsStream(APP_ICON)));

      return alert;
   }

   public static void showInformation(String title, String message) {
      createAlert(AlertType.INFORMATION, title, message).showAndWait();
   }

   public static void showWarning(String title, String message) {
      createAlert(AlertType.WARNING, title, message);
   }

   public static Optional<ButtonType> showConfirmation(String title, String message) {
      return createAlert(AlertType.CONFIRMATION, title, message).showAndWait();
   }

   public static void showError(String title, String message) {
      createAlert(AlertType.ERROR, title, message);
   }

   public static <T> T getTransform(Node node, Class<T> clz) {
      return node.getTransforms().stream()
            .filter(transform -> transform.getClass().equals(clz)).map(clz::cast).findFirst().get();
   }

   public static void addOutlineAnimation(Shape shape) {
      var timeline = (Timeline) shape.getProperties().get("TIMELINE");
      if (timeline != null) {
         return;
      }
      var dash = 10 * shape.getStrokeWidth();
      shape.getStrokeDashArray().addAll(dash, dash);
      final double maxOffset = shape.getStrokeDashArray().stream().reduce(0d, (a, b) -> a + b);

      timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(shape.strokeDashOffsetProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(1), new KeyValue(shape.strokeDashOffsetProperty(), maxOffset, Interpolator.LINEAR))
      );
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();
      shape.getProperties().put("TIMELINE", timeline);
   }

   public static void removeOutlineAnimation(Shape shape) {
      shape.getProperties().remove("TIMELINE");
      shape.getStrokeDashArray().clear();
   }

   public static List<Double> getPolygonPoints(javafx.scene.shape.Path path) {
      List<Double> points = new ArrayList(path.getElements().size());
      IntStream.range(0, path.getElements().size()).forEach(idx -> {
         var el = path.getElements().get(idx);
         if (el instanceof MoveTo) {
            points.add(((MoveTo) el).getX());
            points.add(((MoveTo) el).getY());
         }
         else if (el instanceof LineTo) {
            points.add(((LineTo) el).getX());
            points.add(((LineTo) el).getY());
         }
      });
      return points;
   }

   public static double[] getXPoints(List<Point2D> points) {
      double[] pts = new double[points.size()];
      IntStream.range(0, pts.length).forEach( i -> {
         pts[i] = points.get(i).getX();
      });
      return pts;
   }

   public static double[] getYPoints(List<Point2D> points) {
      double[] pts = new double[points.size()];
      IntStream.range(0, pts.length).forEach( i -> {
         pts[i] = points.get(i).getY();
      });
      return pts;
   }

   public static Bounds getBounds(Point2D... points) {
      double minX = Double.MAX_VALUE;
      double maxX = -Double.MAX_VALUE;
      double minY = Double.MAX_VALUE;
      double maxY = -Double.MAX_VALUE;
      for (Point2D pt : points) {
         minX = Math.min(minX, pt.getX());
         maxX = Math.max(maxX, pt.getX());
         minY = Math.min(minY, pt.getY());
         maxY = Math.max(maxY, pt.getY());
      };
      return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
   }

   public static Bounds insetBounds(Bounds bounds, double amount) {
      return new BoundingBox(
            bounds.getMinX() + amount,
            bounds.getMinY() + amount,
            bounds.getMaxX() - amount,
            bounds.getMaxY() - amount);
   }

   public static TextFormatter createNumberTextFormatter() {
      DecimalFormat format = new DecimalFormat("#");
      return new TextFormatter<>(c -> {
         if (c.getControlNewText().isEmpty()) {
            return c;
         }
         ParsePosition parsePosition = new ParsePosition(0);
         Object object = format.parse(c.getControlNewText(), parsePosition);
         return (object == null || parsePosition.getIndex() < c.getControlNewText().length()) ? null : c;
      });
   };

   public static ObjectMapper createJSONMapper() {
      ObjectMapper mapper = new ObjectMapper();

      // SerializationFeature for changing how JSON is written
      mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
      mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

      // DeserializationFeature for changing how JSON is read as POJOs:
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
      return mapper;
   }

   public static String format(ResourceBundle bundle, String key, Object... args) {
      MessageFormat format = new MessageFormat(bundle.getString(key));
      return format.format(args);
   }
}
