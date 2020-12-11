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

import com.easymobo.openlabeler.preference.PreferenceUtil.BooleanPrefProperty;
import com.easymobo.openlabeler.preference.PreferenceUtil.ColorPrefProperty;
import com.easymobo.openlabeler.preference.PreferenceUtil.IntegerPrefProperty;
import com.easymobo.openlabeler.preference.PreferenceUtil.StringPrefProperty;
import com.easymobo.openlabeler.tag.ShapeItem.Type;
import com.easymobo.openlabeler.util.Colors;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;

import java.util.Collection;
import java.util.prefs.Preferences;

import static com.easymobo.openlabeler.tag.ShapeItem.Type.RECTANGLE;

public class Settings
{
    private static Preferences pref = Preferences.userNodeForPackage(Settings.class);
    // General
    private static final String OPEN_LAST_MEDIA = "openLastMedia";
    private static final String SAVE_EVERY_CHANGE = "saveEveryChange";
    private static final String ANNOTATION_DIR = "annotationDir";
    private static final String AUTO_SET_NAME = "autoSetName";
    private static final String OBJ_STROKE_COLOR = "objectStrokeColor";
    private static final String ANIMATE_OUTLINE = "animateOutline";
    // Training
    private static final String TF_IMAGE_DIR = "tfImageDir";
    private static final String TF_ANNOTATION_DIR = "tfAnnotationDir";
    private static final String TF_DATA_DIR = "tfDataDir";
    private static final String TF_BASE_MODEL_DIR = "tfBaseModelDir";
    private static final String TF_TRAIN_BATCH_SIZE = "tfTrainBatchSize";
    private static final String DOCKER_IMAGE = "dockerImage";
    private static final String CONTAINER_HOST_NAME = "containerHostName";
    private static final String CONTAINER_NAME = "containerName";
    // Inference
    private static final String USE_INFERENCE = "useInference";
    private static final String TF_LABEL_MAP_FILE = "tfLabelMapFile";
    private static final String TF_SAVED_MODEL_DIR = "tfSavedModelDir";
    private static final String HINT_STROKE_COLOR = "hintBoxColor";
    // Tools
    private static final String TOOL_COCO_JSON = "toolCOCOJson";
    // Others
    private static final String PREF_TAB_INDEX = "prefTabIndex";
    private static final String EDIT_SHAPE = "editShape";
    private static final String RECENT_FILES = "recentFiles";
    private static final String RECENT_NAMES = "recentNames";

    // Open last media file/folder
    public static final BooleanProperty openLastMediaProperty = new BooleanPrefProperty(pref, OPEN_LAST_MEDIA, true);
    public static boolean isOpenLastMedia() {
        return openLastMediaProperty.get();
    }
    public static void setOpenLastMedia(boolean save) {
        openLastMediaProperty.set(save);
    }

    // Save every change
    public static final BooleanProperty saveEveryChangeProperty = new BooleanPrefProperty(pref, SAVE_EVERY_CHANGE, false);
    public static boolean isSaveEveryChange() {
        return saveEveryChangeProperty.get();
    }
    public static void setSaveEveryChange(boolean save) {
        saveEveryChangeProperty.set(save);
    }

    // Annotation directory name
    public static final StringProperty annotationDirProperty = new StringPrefProperty(pref, ANNOTATION_DIR, "../annotations");
    public static String getAnnotationDir() {
        return annotationDirProperty.get();
    }
    public static void setAnnotationDir(String dir) {
        annotationDirProperty.set(dir);
    }

    // Auto fill name
    public static final BooleanProperty autoSetNameProperty = new BooleanPrefProperty(pref, AUTO_SET_NAME, true);
    public static boolean isAutoSetName() {
        return autoSetNameProperty.get();
    }
    public static void setAutoSetName(boolean use) {
        autoSetNameProperty.set(use);
    }

    public static final ObjectProperty<Color> objectStrokeColorProperty = new ColorPrefProperty(pref, OBJ_STROKE_COLOR, Color.LIMEGREEN);
    public static Color getObjectStrokeColor() {
        return objectStrokeColorProperty.get();
    }

    // Object bounding box color
    public static void setObjectStrokeColor(Color color) {
        objectStrokeColorProperty.set(color);
    }
    public static ReadOnlyObjectProperty<Color> objectFillColorProperty = new SimpleObjectProperty() {
        @Override
        public Color get() {
            return Colors.applyAlpha(getObjectStrokeColor(), 0.3);
        }
    };
    public static Color getObjectFillColor() {
        return objectFillColorProperty.get();
    }

    // Animate Shape Outline
    public static final BooleanProperty animateOutlineProperty = new BooleanPrefProperty(pref, ANIMATE_OUTLINE, true);
    public static boolean isAnimateOutline() {
        return animateOutlineProperty.get();
    }
    public static void setAnimateOutline(boolean animate) {
        animateOutlineProperty.set(animate);
    }

    // TensorFlow Image directory
    public static final StringProperty tfImageDirProperty = new StringPrefProperty(pref, TF_IMAGE_DIR, "");
    public static String getTFImageDir() {
        return tfImageDirProperty.get();
    }
    public static void setTFImageDir(String dir) {
        tfImageDirProperty.set(dir);
    }

    // TensorFlow Annotation directory
    public static final StringProperty tfAnnotationDirProperty = new StringPrefProperty(pref, TF_ANNOTATION_DIR, "");
    public static String getTFAnnotationDir() {
        return tfAnnotationDirProperty.get();
    }
    public static void setTFAnnotationDir(String dir) {
        tfAnnotationDirProperty.set(dir);
    }

    // TensorFlow data directory
    public static final StringProperty tfDataDirProperty = new StringPrefProperty(pref, TF_DATA_DIR, "");
    public static String getTFDataDir() {
        return tfDataDirProperty.get();
    }
    public static void setTFDataDir(String dir) {
        tfDataDirProperty.set(dir);
    }

    // TensorFlow base model directory
    public static final StringProperty tfBaseModelDirProperty = new StringPrefProperty(pref, TF_BASE_MODEL_DIR, "");
    public static String getTFBaseModelDir() {
        return tfBaseModelDirProperty.get();
    }
    public static void setTFBaseModelDir(String dir) {
        tfBaseModelDirProperty.set(dir);
    }

    // TensorFlow train batch size
    public static final IntegerProperty tfTrainBatchSizeProperty = new IntegerPrefProperty(pref, TF_TRAIN_BATCH_SIZE, 24);
    public static int getTFTrainBatchSize() {
        return tfTrainBatchSizeProperty.get();
    }
    public static void setTFTrainBatchSize(int size) {
        tfTrainBatchSizeProperty.set(size);
    }

    // Docker Image
    public static final StringProperty dockerImageProperty = new StringPrefProperty(pref, DOCKER_IMAGE, "kinhong/openlabeler:tf-2.3.1");
    public static String getDockerImage() {
        return dockerImageProperty.get();
    }
    public static void setDockerImage(String dir) {
        dockerImageProperty.set(dir);
    }

    // Docker Container Host Name
    public static final StringProperty containerHostNameProperty = new StringPrefProperty(pref, CONTAINER_HOST_NAME, "localhost");
    public static String getContainerHostName() {
        return containerHostNameProperty.get();
    }
    public static void setContainerHostName(String dir) {
        containerHostNameProperty.set(dir);
    }

    // Docker Container Name
    public static final StringProperty containerNameProperty = new StringPrefProperty(pref, CONTAINER_NAME, "OpenLabeler-Trainer");
    public static String getContainerName() {
        return containerNameProperty.get();
    }
    public static void setContainerName(String dir) {
        containerNameProperty.set(dir);
    }

    // Use inference
    public static final BooleanProperty useInferenceProperty = new BooleanPrefProperty(pref, USE_INFERENCE, false);
    public static boolean isUseInference() {
        return useInferenceProperty.get();
    }
    public static void setUseInference(boolean save) {
        useInferenceProperty.set(save);
    }

    // Object bounding box color
    public static final ObjectProperty<Color> hintStrokeColorProperty = new ColorPrefProperty(pref, HINT_STROKE_COLOR, Color.LIGHTSALMON);
    public static Color getHintStrokeColor() {
        return hintStrokeColorProperty.get();
    }
    public static void setHintStrokeColor(Color color) {
        hintStrokeColorProperty.set(color);
    }
    public static ReadOnlyObjectProperty<Color> hintFillColorProperty = new SimpleObjectProperty() {
        @Override
        public Color get() {
            return Colors.applyAlpha(getHintStrokeColor(), 0.3);
        }
    };
    public static Color getHintFillColor() {
        return hintFillColorProperty.get();
    }

    // TensorFlow label map file
    public static final StringProperty tfLabelMapFileProperty = new StringPrefProperty(pref, TF_LABEL_MAP_FILE, "");
    public static String getTFLabelMapFile() {
        return tfLabelMapFileProperty.get();
    }
    public static void setTFLabelMapFile(String file) {
        tfLabelMapFileProperty.set(file);
    }

    // TensorFlow saved model directory
    public static final StringProperty tfSavedModelDirProperty = new StringPrefProperty(pref, TF_SAVED_MODEL_DIR, "");
    public static String getTFSavedModelDir() {
        return tfSavedModelDirProperty.get();
    }
    public static void setTFSavedModelDir(String dir) {
        tfSavedModelDirProperty.set(dir);
    }

    // Tools
    public static final StringProperty toolCOCOJson = new StringPrefProperty(pref, TOOL_COCO_JSON, "");
    public static String getToolCOCOJson() {
        return toolCOCOJson.get();
    }
    public static void setToolCOCOJson(String json) {
        toolCOCOJson.set(json);
    }

    // Others
    public static final StringProperty editShapeProperty = new StringPrefProperty(pref, EDIT_SHAPE, RECTANGLE.name());
    public static Type getEditShape() {
        return Type.valueOf(editShapeProperty.get());
    }
    public static void setEditShape(Type shape) {
        editShapeProperty.set(shape.name());
    }

    public static final IntegerProperty prefTabIndexProperty = new IntegerPrefProperty(pref, PREF_TAB_INDEX, 0);
    public static int getPrefTabIndex() {
        return prefTabIndexProperty.get();
    }
    public static void setPrefTabIndex(int index) {
        prefTabIndexProperty.set(index);
    }

    // Recent files
    public static final RecentList<String> recentFilesProperty = new RecentList(4, RECENT_FILES, String.class);

    // Recent labels
    public static final RecentList<NameColor> recentNamesProperty = new RecentList(50, RECENT_NAMES, NameColor.class);

    public static class RecentList<T> extends SimpleListProperty<T>
    {
        private Class<T> type;
        private final int maxLength;
        private final String baseKey;

        public RecentList(int maxLength, String baseKey, Class<T> type) {
            super(FXCollections.observableArrayList());
            this.maxLength = maxLength;
            this.baseKey = baseKey;
            this.type = type;
            load();
        }

        private T newInstance(String s) {
            try {
                return type.getDeclaredConstructor(String.class).newInstance(s);
            }
            catch (Exception ex) {}
            return null;
        }

        public boolean addName(String name) {
            T element = getByPrefix(name);
            if (element == null) {
                element = newInstance(name);
            }
           return add(element);
        }

        @Override
        public boolean add(T element) {
            remove(element);
            add(0, element);
            reduce();
            save();
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> elements) {
            elements.forEach(e -> {
                remove(e);
                add(0, e);
            });
            reduce();
            save();
            return true;
        }

        @Override
        public void clear() {
            super.clear();
            save();
        }

        public T getByPrefix(String prefix) {
            String pre = prefix.toLowerCase();
            for (T item : get()) {
                String s = item.toString().toLowerCase();
                if (s.startsWith(pre)) {
                    return item;
                }
            }
            return null;
        }

        private void reduce() {
            while (size() > maxLength) {
                remove(size() - 1);
            }
        }

        private void load() {
            for (int i = 0; i < maxLength; i++) {
                String val = pref.get(baseKey + i, ""); //$NON-NLS-1$
                if (val.equals("")) { /*$NON-NLS-1$*/
                    break;
                }
                super.add(newInstance(val));
            }
        }

        private void save () {
            for (int i = 0; i < maxLength; i++) {
                if (i < size()) {
                    pref.put(baseKey + i, get(i).toString());
                }
                else {
                    pref.remove(baseKey + i);
                }
            }
        }

        @Override
        public RecentList<T> clone() {
            return new RecentList(maxLength, baseKey, type);
        }
    }
}
