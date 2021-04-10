package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the S3Object type in your schema. */
public final class S3Object {
  private final String bucket;
  private final String key;
  private final String region;
  private final String localUri;
  private final String mimeType;
  public String getBucket() {
      return bucket;
  }
  
  public String getKey() {
      return key;
  }
  
  public String getRegion() {
      return region;
  }
  
  public String getLocalUri() {
      return localUri;
  }
  
  public String getMimeType() {
      return mimeType;
  }
  
  private S3Object(String bucket, String key, String region, String localUri, String mimeType) {
    this.bucket = bucket;
    this.key = key;
    this.region = region;
    this.localUri = localUri;
    this.mimeType = mimeType;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      S3Object s3Object = (S3Object) obj;
      return ObjectsCompat.equals(getBucket(), s3Object.getBucket()) &&
              ObjectsCompat.equals(getKey(), s3Object.getKey()) &&
              ObjectsCompat.equals(getRegion(), s3Object.getRegion()) &&
              ObjectsCompat.equals(getLocalUri(), s3Object.getLocalUri()) &&
              ObjectsCompat.equals(getMimeType(), s3Object.getMimeType());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getBucket())
      .append(getKey())
      .append(getRegion())
      .append(getLocalUri())
      .append(getMimeType())
      .toString()
      .hashCode();
  }
  
  public static BucketStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(bucket,
      key,
      region,
      localUri,
      mimeType);
  }
  public interface BucketStep {
    KeyStep bucket(String bucket);
  }
  

  public interface KeyStep {
    RegionStep key(String key);
  }
  

  public interface RegionStep {
    BuildStep region(String region);
  }
  

  public interface BuildStep {
    S3Object build();
    BuildStep localUri(String localUri);
    BuildStep mimeType(String mimeType);
  }
  

  public static class Builder implements BucketStep, KeyStep, RegionStep, BuildStep {
    private String bucket;
    private String key;
    private String region;
    private String localUri;
    private String mimeType;
    @Override
     public S3Object build() {
        
        return new S3Object(
          bucket,
          key,
          region,
          localUri,
          mimeType);
    }
    
    @Override
     public KeyStep bucket(String bucket) {
        Objects.requireNonNull(bucket);
        this.bucket = bucket;
        return this;
    }
    
    @Override
     public RegionStep key(String key) {
        Objects.requireNonNull(key);
        this.key = key;
        return this;
    }
    
    @Override
     public BuildStep region(String region) {
        Objects.requireNonNull(region);
        this.region = region;
        return this;
    }
    
    @Override
     public BuildStep localUri(String localUri) {
        this.localUri = localUri;
        return this;
    }
    
    @Override
     public BuildStep mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String bucket, String key, String region, String localUri, String mimeType) {
      super.bucket(bucket)
        .key(key)
        .region(region)
        .localUri(localUri)
        .mimeType(mimeType);
    }
    
    @Override
     public CopyOfBuilder bucket(String bucket) {
      return (CopyOfBuilder) super.bucket(bucket);
    }
    
    @Override
     public CopyOfBuilder key(String key) {
      return (CopyOfBuilder) super.key(key);
    }
    
    @Override
     public CopyOfBuilder region(String region) {
      return (CopyOfBuilder) super.region(region);
    }
    
    @Override
     public CopyOfBuilder localUri(String localUri) {
      return (CopyOfBuilder) super.localUri(localUri);
    }
    
    @Override
     public CopyOfBuilder mimeType(String mimeType) {
      return (CopyOfBuilder) super.mimeType(mimeType);
    }
  }
  
}
