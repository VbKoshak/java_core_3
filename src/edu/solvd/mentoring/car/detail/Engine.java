package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

public class Engine extends CarDetail {
  private short maxSpeed;
  private short boost;
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

  @Override
  protected void calcRarity() {
    //no logic yet
    this.rarity = DetailRarity.B;
  }
}
