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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: object_detection/protos/keypoint_box_coder.proto

package object_detection.protos;

public final class KeypointBoxCoderOuterClass {
  private KeypointBoxCoderOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KeypointBoxCoderOrBuilder extends
      // @@protoc_insertion_point(interface_extends:object_detection.protos.KeypointBoxCoder)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 num_keypoints = 1;</code>
     * @return Whether the numKeypoints field is set.
     */
    boolean hasNumKeypoints();
    /**
     * <code>optional int32 num_keypoints = 1;</code>
     * @return The numKeypoints.
     */
    int getNumKeypoints();

    /**
     * <pre>
     * Scale factor for anchor encoded box center and keypoints.
     * </pre>
     *
     * <code>optional float y_scale = 2 [default = 10];</code>
     * @return Whether the yScale field is set.
     */
    boolean hasYScale();
    /**
     * <pre>
     * Scale factor for anchor encoded box center and keypoints.
     * </pre>
     *
     * <code>optional float y_scale = 2 [default = 10];</code>
     * @return The yScale.
     */
    float getYScale();

    /**
     * <code>optional float x_scale = 3 [default = 10];</code>
     * @return Whether the xScale field is set.
     */
    boolean hasXScale();
    /**
     * <code>optional float x_scale = 3 [default = 10];</code>
     * @return The xScale.
     */
    float getXScale();

    /**
     * <pre>
     * Scale factor for anchor encoded box height.
     * </pre>
     *
     * <code>optional float height_scale = 4 [default = 5];</code>
     * @return Whether the heightScale field is set.
     */
    boolean hasHeightScale();
    /**
     * <pre>
     * Scale factor for anchor encoded box height.
     * </pre>
     *
     * <code>optional float height_scale = 4 [default = 5];</code>
     * @return The heightScale.
     */
    float getHeightScale();

    /**
     * <pre>
     * Scale factor for anchor encoded box width.
     * </pre>
     *
     * <code>optional float width_scale = 5 [default = 5];</code>
     * @return Whether the widthScale field is set.
     */
    boolean hasWidthScale();
    /**
     * <pre>
     * Scale factor for anchor encoded box width.
     * </pre>
     *
     * <code>optional float width_scale = 5 [default = 5];</code>
     * @return The widthScale.
     */
    float getWidthScale();
  }
  /**
   * <pre>
   * Configuration proto for KeypointBoxCoder. See
   * box_coders/keypoint_box_coder.py for details.
   * </pre>
   *
   * Protobuf type {@code object_detection.protos.KeypointBoxCoder}
   */
  public static final class KeypointBoxCoder extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:object_detection.protos.KeypointBoxCoder)
      KeypointBoxCoderOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use KeypointBoxCoder.newBuilder() to construct.
    private KeypointBoxCoder(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KeypointBoxCoder() {
      yScale_ = 10F;
      xScale_ = 10F;
      heightScale_ = 5F;
      widthScale_ = 5F;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new KeypointBoxCoder();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private KeypointBoxCoder(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              bitField0_ |= 0x00000001;
              numKeypoints_ = input.readInt32();
              break;
            }
            case 21: {
              bitField0_ |= 0x00000002;
              yScale_ = input.readFloat();
              break;
            }
            case 29: {
              bitField0_ |= 0x00000004;
              xScale_ = input.readFloat();
              break;
            }
            case 37: {
              bitField0_ |= 0x00000008;
              heightScale_ = input.readFloat();
              break;
            }
            case 45: {
              bitField0_ |= 0x00000010;
              widthScale_ = input.readFloat();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return object_detection.protos.KeypointBoxCoderOuterClass.internal_static_object_detection_protos_KeypointBoxCoder_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return object_detection.protos.KeypointBoxCoderOuterClass.internal_static_object_detection_protos_KeypointBoxCoder_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.class, object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.Builder.class);
    }

    private int bitField0_;
    public static final int NUM_KEYPOINTS_FIELD_NUMBER = 1;
    private int numKeypoints_;
    /**
     * <code>optional int32 num_keypoints = 1;</code>
     * @return Whether the numKeypoints field is set.
     */
    @java.lang.Override
    public boolean hasNumKeypoints() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional int32 num_keypoints = 1;</code>
     * @return The numKeypoints.
     */
    @java.lang.Override
    public int getNumKeypoints() {
      return numKeypoints_;
    }

    public static final int Y_SCALE_FIELD_NUMBER = 2;
    private float yScale_;
    /**
     * <pre>
     * Scale factor for anchor encoded box center and keypoints.
     * </pre>
     *
     * <code>optional float y_scale = 2 [default = 10];</code>
     * @return Whether the yScale field is set.
     */
    @java.lang.Override
    public boolean hasYScale() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * Scale factor for anchor encoded box center and keypoints.
     * </pre>
     *
     * <code>optional float y_scale = 2 [default = 10];</code>
     * @return The yScale.
     */
    @java.lang.Override
    public float getYScale() {
      return yScale_;
    }

    public static final int X_SCALE_FIELD_NUMBER = 3;
    private float xScale_;
    /**
     * <code>optional float x_scale = 3 [default = 10];</code>
     * @return Whether the xScale field is set.
     */
    @java.lang.Override
    public boolean hasXScale() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional float x_scale = 3 [default = 10];</code>
     * @return The xScale.
     */
    @java.lang.Override
    public float getXScale() {
      return xScale_;
    }

    public static final int HEIGHT_SCALE_FIELD_NUMBER = 4;
    private float heightScale_;
    /**
     * <pre>
     * Scale factor for anchor encoded box height.
     * </pre>
     *
     * <code>optional float height_scale = 4 [default = 5];</code>
     * @return Whether the heightScale field is set.
     */
    @java.lang.Override
    public boolean hasHeightScale() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <pre>
     * Scale factor for anchor encoded box height.
     * </pre>
     *
     * <code>optional float height_scale = 4 [default = 5];</code>
     * @return The heightScale.
     */
    @java.lang.Override
    public float getHeightScale() {
      return heightScale_;
    }

    public static final int WIDTH_SCALE_FIELD_NUMBER = 5;
    private float widthScale_;
    /**
     * <pre>
     * Scale factor for anchor encoded box width.
     * </pre>
     *
     * <code>optional float width_scale = 5 [default = 5];</code>
     * @return Whether the widthScale field is set.
     */
    @java.lang.Override
    public boolean hasWidthScale() {
      return ((bitField0_ & 0x00000010) != 0);
    }
    /**
     * <pre>
     * Scale factor for anchor encoded box width.
     * </pre>
     *
     * <code>optional float width_scale = 5 [default = 5];</code>
     * @return The widthScale.
     */
    @java.lang.Override
    public float getWidthScale() {
      return widthScale_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeInt32(1, numKeypoints_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeFloat(2, yScale_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeFloat(3, xScale_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        output.writeFloat(4, heightScale_);
      }
      if (((bitField0_ & 0x00000010) != 0)) {
        output.writeFloat(5, widthScale_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, numKeypoints_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, yScale_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, xScale_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, heightScale_);
      }
      if (((bitField0_ & 0x00000010) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(5, widthScale_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder)) {
        return super.equals(obj);
      }
      object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder other = (object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder) obj;

      if (hasNumKeypoints() != other.hasNumKeypoints()) return false;
      if (hasNumKeypoints()) {
        if (getNumKeypoints()
            != other.getNumKeypoints()) return false;
      }
      if (hasYScale() != other.hasYScale()) return false;
      if (hasYScale()) {
        if (java.lang.Float.floatToIntBits(getYScale())
            != java.lang.Float.floatToIntBits(
                other.getYScale())) return false;
      }
      if (hasXScale() != other.hasXScale()) return false;
      if (hasXScale()) {
        if (java.lang.Float.floatToIntBits(getXScale())
            != java.lang.Float.floatToIntBits(
                other.getXScale())) return false;
      }
      if (hasHeightScale() != other.hasHeightScale()) return false;
      if (hasHeightScale()) {
        if (java.lang.Float.floatToIntBits(getHeightScale())
            != java.lang.Float.floatToIntBits(
                other.getHeightScale())) return false;
      }
      if (hasWidthScale() != other.hasWidthScale()) return false;
      if (hasWidthScale()) {
        if (java.lang.Float.floatToIntBits(getWidthScale())
            != java.lang.Float.floatToIntBits(
                other.getWidthScale())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasNumKeypoints()) {
        hash = (37 * hash) + NUM_KEYPOINTS_FIELD_NUMBER;
        hash = (53 * hash) + getNumKeypoints();
      }
      if (hasYScale()) {
        hash = (37 * hash) + Y_SCALE_FIELD_NUMBER;
        hash = (53 * hash) + java.lang.Float.floatToIntBits(
            getYScale());
      }
      if (hasXScale()) {
        hash = (37 * hash) + X_SCALE_FIELD_NUMBER;
        hash = (53 * hash) + java.lang.Float.floatToIntBits(
            getXScale());
      }
      if (hasHeightScale()) {
        hash = (37 * hash) + HEIGHT_SCALE_FIELD_NUMBER;
        hash = (53 * hash) + java.lang.Float.floatToIntBits(
            getHeightScale());
      }
      if (hasWidthScale()) {
        hash = (37 * hash) + WIDTH_SCALE_FIELD_NUMBER;
        hash = (53 * hash) + java.lang.Float.floatToIntBits(
            getWidthScale());
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * Configuration proto for KeypointBoxCoder. See
     * box_coders/keypoint_box_coder.py for details.
     * </pre>
     *
     * Protobuf type {@code object_detection.protos.KeypointBoxCoder}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:object_detection.protos.KeypointBoxCoder)
        object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoderOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return object_detection.protos.KeypointBoxCoderOuterClass.internal_static_object_detection_protos_KeypointBoxCoder_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return object_detection.protos.KeypointBoxCoderOuterClass.internal_static_object_detection_protos_KeypointBoxCoder_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.class, object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.Builder.class);
      }

      // Construct using object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        numKeypoints_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        yScale_ = 10F;
        bitField0_ = (bitField0_ & ~0x00000002);
        xScale_ = 10F;
        bitField0_ = (bitField0_ & ~0x00000004);
        heightScale_ = 5F;
        bitField0_ = (bitField0_ & ~0x00000008);
        widthScale_ = 5F;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return object_detection.protos.KeypointBoxCoderOuterClass.internal_static_object_detection_protos_KeypointBoxCoder_descriptor;
      }

      @java.lang.Override
      public object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder getDefaultInstanceForType() {
        return object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.getDefaultInstance();
      }

      @java.lang.Override
      public object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder build() {
        object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder buildPartial() {
        object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder result = new object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.numKeypoints_ = numKeypoints_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.yScale_ = yScale_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          to_bitField0_ |= 0x00000004;
        }
        result.xScale_ = xScale_;
        if (((from_bitField0_ & 0x00000008) != 0)) {
          to_bitField0_ |= 0x00000008;
        }
        result.heightScale_ = heightScale_;
        if (((from_bitField0_ & 0x00000010) != 0)) {
          to_bitField0_ |= 0x00000010;
        }
        result.widthScale_ = widthScale_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder) {
          return mergeFrom((object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder other) {
        if (other == object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder.getDefaultInstance()) return this;
        if (other.hasNumKeypoints()) {
          setNumKeypoints(other.getNumKeypoints());
        }
        if (other.hasYScale()) {
          setYScale(other.getYScale());
        }
        if (other.hasXScale()) {
          setXScale(other.getXScale());
        }
        if (other.hasHeightScale()) {
          setHeightScale(other.getHeightScale());
        }
        if (other.hasWidthScale()) {
          setWidthScale(other.getWidthScale());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int numKeypoints_ ;
      /**
       * <code>optional int32 num_keypoints = 1;</code>
       * @return Whether the numKeypoints field is set.
       */
      @java.lang.Override
      public boolean hasNumKeypoints() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>optional int32 num_keypoints = 1;</code>
       * @return The numKeypoints.
       */
      @java.lang.Override
      public int getNumKeypoints() {
        return numKeypoints_;
      }
      /**
       * <code>optional int32 num_keypoints = 1;</code>
       * @param value The numKeypoints to set.
       * @return This builder for chaining.
       */
      public Builder setNumKeypoints(int value) {
        bitField0_ |= 0x00000001;
        numKeypoints_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 num_keypoints = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearNumKeypoints() {
        bitField0_ = (bitField0_ & ~0x00000001);
        numKeypoints_ = 0;
        onChanged();
        return this;
      }

      private float yScale_ = 10F;
      /**
       * <pre>
       * Scale factor for anchor encoded box center and keypoints.
       * </pre>
       *
       * <code>optional float y_scale = 2 [default = 10];</code>
       * @return Whether the yScale field is set.
       */
      @java.lang.Override
      public boolean hasYScale() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box center and keypoints.
       * </pre>
       *
       * <code>optional float y_scale = 2 [default = 10];</code>
       * @return The yScale.
       */
      @java.lang.Override
      public float getYScale() {
        return yScale_;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box center and keypoints.
       * </pre>
       *
       * <code>optional float y_scale = 2 [default = 10];</code>
       * @param value The yScale to set.
       * @return This builder for chaining.
       */
      public Builder setYScale(float value) {
        bitField0_ |= 0x00000002;
        yScale_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box center and keypoints.
       * </pre>
       *
       * <code>optional float y_scale = 2 [default = 10];</code>
       * @return This builder for chaining.
       */
      public Builder clearYScale() {
        bitField0_ = (bitField0_ & ~0x00000002);
        yScale_ = 10F;
        onChanged();
        return this;
      }

      private float xScale_ = 10F;
      /**
       * <code>optional float x_scale = 3 [default = 10];</code>
       * @return Whether the xScale field is set.
       */
      @java.lang.Override
      public boolean hasXScale() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>optional float x_scale = 3 [default = 10];</code>
       * @return The xScale.
       */
      @java.lang.Override
      public float getXScale() {
        return xScale_;
      }
      /**
       * <code>optional float x_scale = 3 [default = 10];</code>
       * @param value The xScale to set.
       * @return This builder for chaining.
       */
      public Builder setXScale(float value) {
        bitField0_ |= 0x00000004;
        xScale_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float x_scale = 3 [default = 10];</code>
       * @return This builder for chaining.
       */
      public Builder clearXScale() {
        bitField0_ = (bitField0_ & ~0x00000004);
        xScale_ = 10F;
        onChanged();
        return this;
      }

      private float heightScale_ = 5F;
      /**
       * <pre>
       * Scale factor for anchor encoded box height.
       * </pre>
       *
       * <code>optional float height_scale = 4 [default = 5];</code>
       * @return Whether the heightScale field is set.
       */
      @java.lang.Override
      public boolean hasHeightScale() {
        return ((bitField0_ & 0x00000008) != 0);
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box height.
       * </pre>
       *
       * <code>optional float height_scale = 4 [default = 5];</code>
       * @return The heightScale.
       */
      @java.lang.Override
      public float getHeightScale() {
        return heightScale_;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box height.
       * </pre>
       *
       * <code>optional float height_scale = 4 [default = 5];</code>
       * @param value The heightScale to set.
       * @return This builder for chaining.
       */
      public Builder setHeightScale(float value) {
        bitField0_ |= 0x00000008;
        heightScale_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box height.
       * </pre>
       *
       * <code>optional float height_scale = 4 [default = 5];</code>
       * @return This builder for chaining.
       */
      public Builder clearHeightScale() {
        bitField0_ = (bitField0_ & ~0x00000008);
        heightScale_ = 5F;
        onChanged();
        return this;
      }

      private float widthScale_ = 5F;
      /**
       * <pre>
       * Scale factor for anchor encoded box width.
       * </pre>
       *
       * <code>optional float width_scale = 5 [default = 5];</code>
       * @return Whether the widthScale field is set.
       */
      @java.lang.Override
      public boolean hasWidthScale() {
        return ((bitField0_ & 0x00000010) != 0);
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box width.
       * </pre>
       *
       * <code>optional float width_scale = 5 [default = 5];</code>
       * @return The widthScale.
       */
      @java.lang.Override
      public float getWidthScale() {
        return widthScale_;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box width.
       * </pre>
       *
       * <code>optional float width_scale = 5 [default = 5];</code>
       * @param value The widthScale to set.
       * @return This builder for chaining.
       */
      public Builder setWidthScale(float value) {
        bitField0_ |= 0x00000010;
        widthScale_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Scale factor for anchor encoded box width.
       * </pre>
       *
       * <code>optional float width_scale = 5 [default = 5];</code>
       * @return This builder for chaining.
       */
      public Builder clearWidthScale() {
        bitField0_ = (bitField0_ & ~0x00000010);
        widthScale_ = 5F;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:object_detection.protos.KeypointBoxCoder)
    }

    // @@protoc_insertion_point(class_scope:object_detection.protos.KeypointBoxCoder)
    private static final object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder();
    }

    public static object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<KeypointBoxCoder>
        PARSER = new com.google.protobuf.AbstractParser<KeypointBoxCoder>() {
      @java.lang.Override
      public KeypointBoxCoder parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KeypointBoxCoder(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KeypointBoxCoder> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<KeypointBoxCoder> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public object_detection.protos.KeypointBoxCoderOuterClass.KeypointBoxCoder getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_object_detection_protos_KeypointBoxCoder_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_object_detection_protos_KeypointBoxCoder_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n0object_detection/protos/keypoint_box_c" +
      "oder.proto\022\027object_detection.protos\"\204\001\n\020" +
      "KeypointBoxCoder\022\025\n\rnum_keypoints\030\001 \001(\005\022" +
      "\023\n\007y_scale\030\002 \001(\002:\00210\022\023\n\007x_scale\030\003 \001(\002:\0021" +
      "0\022\027\n\014height_scale\030\004 \001(\002:\0015\022\026\n\013width_scal" +
      "e\030\005 \001(\002:\0015"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_object_detection_protos_KeypointBoxCoder_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_object_detection_protos_KeypointBoxCoder_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_object_detection_protos_KeypointBoxCoder_descriptor,
        new java.lang.String[] { "NumKeypoints", "YScale", "XScale", "HeightScale", "WidthScale", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
