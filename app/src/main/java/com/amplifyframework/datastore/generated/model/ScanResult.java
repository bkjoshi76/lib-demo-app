package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ScanResult type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ScanResults")
public final class ScanResult implements Model {
  public static final QueryField ID = field("ScanResult", "id");
  public static final QueryField NAME = field("ScanResult", "name");
  public static final QueryField FORMAT = field("ScanResult", "format");
  public static final QueryField DESCRIPTION = field("ScanResult", "description");
  public static final QueryField PHOTO = field("ScanResult", "photo");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String") String format;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="S3Object") S3Object photo;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getFormat() {
      return format;
  }
  
  public String getDescription() {
      return description;
  }
  
  public S3Object getPhoto() {
      return photo;
  }
  
  private ScanResult(String id, String name, String format, String description, S3Object photo) {
    this.id = id;
    this.name = name;
    this.format = format;
    this.description = description;
    this.photo = photo;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ScanResult scanResult = (ScanResult) obj;
      return ObjectsCompat.equals(getId(), scanResult.getId()) &&
              ObjectsCompat.equals(getName(), scanResult.getName()) &&
              ObjectsCompat.equals(getFormat(), scanResult.getFormat()) &&
              ObjectsCompat.equals(getDescription(), scanResult.getDescription()) &&
              ObjectsCompat.equals(getPhoto(), scanResult.getPhoto());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getFormat())
      .append(getDescription())
      .append(getPhoto())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ScanResult {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("format=" + String.valueOf(getFormat()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("photo=" + String.valueOf(getPhoto()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static ScanResult justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new ScanResult(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      format,
      description,
      photo);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    ScanResult build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep format(String format);
    BuildStep description(String description);
    BuildStep photo(S3Object photo);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private String format;
    private String description;
    private S3Object photo;
    @Override
     public ScanResult build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ScanResult(
          id,
          name,
          format,
          description,
          photo);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep format(String format) {
        this.format = format;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep photo(S3Object photo) {
        this.photo = photo;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String format, String description, S3Object photo) {
      super.id(id);
      super.name(name)
        .format(format)
        .description(description)
        .photo(photo);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder format(String format) {
      return (CopyOfBuilder) super.format(format);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder photo(S3Object photo) {
      return (CopyOfBuilder) super.photo(photo);
    }
  }
  
}