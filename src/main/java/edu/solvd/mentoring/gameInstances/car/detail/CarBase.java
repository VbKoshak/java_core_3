package edu.solvd.mentoring.gameInstances.car.detail;

import edu.solvd.mentoring.resources.enums.DetailRarity;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that represents car base
 * has all characteristicks of the car, but limit is lower than in other detais
 */
public class CarBase extends CarDetail {
  /** @see Car#maxSpeed */
  private short basicMaxSpeed;
  /** @see Car#boost */
  private short basicBoost;
  /** @see Car#clutch */
  private Map<Integer,Short> basicClutch = new HashMap<>();

  /**
   * Basic constructor
   * @param name name of the detail
   * @see CarDetail#name
   * @param basicMaxSpeed basic speed it gives a car (upgraded by Engine)
   * @param basicBoost    basic boost it gives to a car (upgraded by Engine)
   * @param basicClutch   basic clutch to each Surface (upgraded by wheel)
   */
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

  /**
   * calculates rarity of a detail based on characteristicks of a detail
   * @see CarDetail#calcRarity()
   */
  @Override
  protected void calcRarity() {
    // no logic yet
    this.rarity = DetailRarity.A;
  }
}
