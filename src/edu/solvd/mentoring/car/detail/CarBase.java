package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

import java.util.HashMap;
import java.util.Map;

public class CarBase extends CarDetail {
  private short basicMaxSpeed;
  private short basicBoost;
  private Map<Integer,Short> basicClutch = new HashMap<>();

  public CarBase(String name, short basicMaxSpeed, short basicBoost, Map<Integer,Short> basicClutch) {
    super(name);
    this.basicBoost = basicBoost;
    this.basicClutch = basicClutch;
    this.basicMaxSpeed = basicMaxSpeed;
    this.calcRarity();
  }

  public short getBasicMaxSpeed(){
    return basicMaxSpeed;
  }

  public short getBasicBoost(){
    return basicBoost;
  }

  public Map<Integer,Short> getBasicClutch() {
    return basicClutch;
  }

  @Override
  protected void calcRarity() {
    // no logic yet
    this.rarity = DetailRarity.A;
  }
}
