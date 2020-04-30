package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

import java.util.HashMap;

public class CarBase extends CarDetail {
  short basicMaxSpeed;
  short basicBoost;
  HashMap<Short,Short> basicClutch = new HashMap<>();

  public CarBase(DetailQuality quality, String name, short basicMaxSpeed, short basicBoost, HashMap<Short,Short> basicClutch) {
    super(quality, name);
    this.basicBoost = basicBoost;
    this.basicClutch = basicClutch;
    this.basicMaxSpeed = basicMaxSpeed;
  }

  public short getBasicMaxSpeed(){
    return basicMaxSpeed;
  }

  public short getBasicBoost(){
    return basicBoost;
  }

  public HashMap<Short,Short> getBasicClutch() {
    return basicClutch;
  }
}
