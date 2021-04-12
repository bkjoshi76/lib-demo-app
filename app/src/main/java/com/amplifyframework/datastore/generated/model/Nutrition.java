package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Nutrition type in your schema. */
public final class Nutrition {
  private final Integer energy;
  private final Integer protein;
  private final Integer fatTotal;
  private final Integer saturated;
  private final Integer carbohydrate;
  private final Integer sugar;
  private final Integer sodium;
  public Integer getEnergy() {
      return energy;
  }
  
  public Integer getProtein() {
      return protein;
  }
  
  public Integer getFatTotal() {
      return fatTotal;
  }
  
  public Integer getSaturated() {
      return saturated;
  }
  
  public Integer getCarbohydrate() {
      return carbohydrate;
  }
  
  public Integer getSugar() {
      return sugar;
  }
  
  public Integer getSodium() {
      return sodium;
  }
  
  private Nutrition(Integer energy, Integer protein, Integer fatTotal, Integer saturated, Integer carbohydrate, Integer sugar, Integer sodium) {
    this.energy = energy;
    this.protein = protein;
    this.fatTotal = fatTotal;
    this.saturated = saturated;
    this.carbohydrate = carbohydrate;
    this.sugar = sugar;
    this.sodium = sodium;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Nutrition nutrition = (Nutrition) obj;
      return ObjectsCompat.equals(getEnergy(), nutrition.getEnergy()) &&
              ObjectsCompat.equals(getProtein(), nutrition.getProtein()) &&
              ObjectsCompat.equals(getFatTotal(), nutrition.getFatTotal()) &&
              ObjectsCompat.equals(getSaturated(), nutrition.getSaturated()) &&
              ObjectsCompat.equals(getCarbohydrate(), nutrition.getCarbohydrate()) &&
              ObjectsCompat.equals(getSugar(), nutrition.getSugar()) &&
              ObjectsCompat.equals(getSodium(), nutrition.getSodium());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getEnergy())
      .append(getProtein())
      .append(getFatTotal())
      .append(getSaturated())
      .append(getCarbohydrate())
      .append(getSugar())
      .append(getSodium())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(energy,
      protein,
      fatTotal,
      saturated,
      carbohydrate,
      sugar,
      sodium);
  }
  public interface BuildStep {
    Nutrition build();
    BuildStep energy(Integer energy);
    BuildStep protein(Integer protein);
    BuildStep fatTotal(Integer fatTotal);
    BuildStep saturated(Integer saturated);
    BuildStep carbohydrate(Integer carbohydrate);
    BuildStep sugar(Integer sugar);
    BuildStep sodium(Integer sodium);
  }
  

  public static class Builder implements BuildStep {
    private Integer energy;
    private Integer protein;
    private Integer fatTotal;
    private Integer saturated;
    private Integer carbohydrate;
    private Integer sugar;
    private Integer sodium;
    @Override
     public Nutrition build() {
        
        return new Nutrition(
          energy,
          protein,
          fatTotal,
          saturated,
          carbohydrate,
          sugar,
          sodium);
    }
    
    @Override
     public BuildStep energy(Integer energy) {
        this.energy = energy;
        return this;
    }
    
    @Override
     public BuildStep protein(Integer protein) {
        this.protein = protein;
        return this;
    }
    
    @Override
     public BuildStep fatTotal(Integer fatTotal) {
        this.fatTotal = fatTotal;
        return this;
    }
    
    @Override
     public BuildStep saturated(Integer saturated) {
        this.saturated = saturated;
        return this;
    }
    
    @Override
     public BuildStep carbohydrate(Integer carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }
    
    @Override
     public BuildStep sugar(Integer sugar) {
        this.sugar = sugar;
        return this;
    }
    
    @Override
     public BuildStep sodium(Integer sodium) {
        this.sodium = sodium;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Integer energy, Integer protein, Integer fatTotal, Integer saturated, Integer carbohydrate, Integer sugar, Integer sodium) {
      super.energy(energy)
        .protein(protein)
        .fatTotal(fatTotal)
        .saturated(saturated)
        .carbohydrate(carbohydrate)
        .sugar(sugar)
        .sodium(sodium);
    }
    
    @Override
     public CopyOfBuilder energy(Integer energy) {
      return (CopyOfBuilder) super.energy(energy);
    }
    
    @Override
     public CopyOfBuilder protein(Integer protein) {
      return (CopyOfBuilder) super.protein(protein);
    }
    
    @Override
     public CopyOfBuilder fatTotal(Integer fatTotal) {
      return (CopyOfBuilder) super.fatTotal(fatTotal);
    }
    
    @Override
     public CopyOfBuilder saturated(Integer saturated) {
      return (CopyOfBuilder) super.saturated(saturated);
    }
    
    @Override
     public CopyOfBuilder carbohydrate(Integer carbohydrate) {
      return (CopyOfBuilder) super.carbohydrate(carbohydrate);
    }
    
    @Override
     public CopyOfBuilder sugar(Integer sugar) {
      return (CopyOfBuilder) super.sugar(sugar);
    }
    
    @Override
     public CopyOfBuilder sodium(Integer sodium) {
      return (CopyOfBuilder) super.sodium(sodium);
    }
  }
  
}
