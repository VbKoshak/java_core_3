package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

/**
 * abstract class that represents details which build car
 */
public abstract class CarDetail {
  protected DetailRarity rarity;
  private String name;

  /**
   * @param name name of the detail
   */
  public CarDetail(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public DetailRarity getRarity() {
    return rarity;
  }

  /**
   * calculates rarity of a detail based on characteristicks of a detail
   */
  protected abstract void calcRarity();
}
