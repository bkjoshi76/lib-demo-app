package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Product type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Products")
public final class Product implements Model {
  public static final QueryField ID = field("Product", "id");
  public static final QueryField NAME = field("Product", "name");
  public static final QueryField DESCRIPTION = field("Product", "description");
  public static final QueryField SERVING_SIZE = field("Product", "servingSize");
  public static final QueryField SERVING_PER_PACKET = field("Product", "servingPerPacket");
  public static final QueryField NUTRITION_INFO = field("Product", "nutritionInfo");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="Int") Integer servingSize;
  private final @ModelField(targetType="Int") Integer servingPerPacket;
  private final @ModelField(targetType="Nutrition") Nutrition nutritionInfo;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getDescription() {
      return description;
  }
  
  public Integer getServingSize() {
      return servingSize;
  }
  
  public Integer getServingPerPacket() {
      return servingPerPacket;
  }
  
  public Nutrition getNutritionInfo() {
      return nutritionInfo;
  }
  
  private Product(String id, String name, String description, Integer servingSize, Integer servingPerPacket, Nutrition nutritionInfo) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.servingSize = servingSize;
    this.servingPerPacket = servingPerPacket;
    this.nutritionInfo = nutritionInfo;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Product product = (Product) obj;
      return ObjectsCompat.equals(getId(), product.getId()) &&
              ObjectsCompat.equals(getName(), product.getName()) &&
              ObjectsCompat.equals(getDescription(), product.getDescription()) &&
              ObjectsCompat.equals(getServingSize(), product.getServingSize()) &&
              ObjectsCompat.equals(getServingPerPacket(), product.getServingPerPacket()) &&
              ObjectsCompat.equals(getNutritionInfo(), product.getNutritionInfo());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getDescription())
      .append(getServingSize())
      .append(getServingPerPacket())
      .append(getNutritionInfo())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Product {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("servingSize=" + String.valueOf(getServingSize()) + ", ")
      .append("servingPerPacket=" + String.valueOf(getServingPerPacket()) + ", ")
      .append("nutritionInfo=" + String.valueOf(getNutritionInfo()))
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
  public static Product justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Product(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      description,
      servingSize,
      servingPerPacket,
      nutritionInfo);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    Product build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep description(String description);
    BuildStep servingSize(Integer servingSize);
    BuildStep servingPerPacket(Integer servingPerPacket);
    BuildStep nutritionInfo(Nutrition nutritionInfo);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private String description;
    private Integer servingSize;
    private Integer servingPerPacket;
    private Nutrition nutritionInfo;
    @Override
     public Product build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Product(
          id,
          name,
          description,
          servingSize,
          servingPerPacket,
          nutritionInfo);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep servingSize(Integer servingSize) {
        this.servingSize = servingSize;
        return this;
    }
    
    @Override
     public BuildStep servingPerPacket(Integer servingPerPacket) {
        this.servingPerPacket = servingPerPacket;
        return this;
    }
    
    @Override
     public BuildStep nutritionInfo(Nutrition nutritionInfo) {
        this.nutritionInfo = nutritionInfo;
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
    private CopyOfBuilder(String id, String name, String description, Integer servingSize, Integer servingPerPacket, Nutrition nutritionInfo) {
      super.id(id);
      super.name(name)
        .description(description)
        .servingSize(servingSize)
        .servingPerPacket(servingPerPacket)
        .nutritionInfo(nutritionInfo);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder servingSize(Integer servingSize) {
      return (CopyOfBuilder) super.servingSize(servingSize);
    }
    
    @Override
     public CopyOfBuilder servingPerPacket(Integer servingPerPacket) {
      return (CopyOfBuilder) super.servingPerPacket(servingPerPacket);
    }
    
    @Override
     public CopyOfBuilder nutritionInfo(Nutrition nutritionInfo) {
      return (CopyOfBuilder) super.nutritionInfo(nutritionInfo);
    }
  }
  
}
