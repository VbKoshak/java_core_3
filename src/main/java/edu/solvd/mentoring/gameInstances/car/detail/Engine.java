package edu.solvd.mentoring.gameInstances.car.detail;

import edu.solvd.mentoring.resources.enums.DetailRarity;

/**
 * Class engine as a part of a car
 * has only speed and boost that increase car's characteristicks
 */
public class Engine extends CarDetail {
  private short maxSpeed;
  private short boost;

  /**
   * basic constructor for engine
   *
   * @param name represents the name of the detail
   * @see CarDetail#name
   * @param maxSpeed increase in maximum it gives to a car
   * @see Car#maxSpeed
   * @param boost increase in boost it gives to a car
   * @see Car#boost
   */
  public Engine(String name, short maxSpeed, short boost) {
    super(name);
    this.maxSpeed = maxSpeed;
    this.boost = boost;
    this.calcRarity();
  }

  public short getMaxSpeed() {
    return maxSpeed;
  }

  public short getBoost() {
    return boost;
  }

  /**
   * @see CarBase#calcRarity()
   *
   * implementation to be provided
   */
  @Override
  protected void calcRarity() {
    //no logic yet
    this.rarity = DetailRarity.B;
  }
}
