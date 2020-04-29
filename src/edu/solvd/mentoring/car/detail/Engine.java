package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

public class Engine extends CarDetail {
  private short maxSpeed;
  private short boost;
  public Engine(DetailQuality quality, String name, short maxSpeed, short boost) {
    super(quality, name);
    this.maxSpeed = maxSpeed;
    this.boost = boost;
  }

  public short getMaxSpeed() {
    return maxSpeed;
  }

  public short getBoost() {
    return boost;
  }
}
