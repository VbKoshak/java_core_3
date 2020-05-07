package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

public abstract class CarDetail {
  protected DetailRarity rarity;
  private String name;

  public CarDetail(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public DetailRarity getRarity() {
    return rarity;
  }

  protected abstract void calcRarity();
}
