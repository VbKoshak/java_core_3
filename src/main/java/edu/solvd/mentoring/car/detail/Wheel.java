package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

import java.util.HashMap;
import java.util.Map;

/**
 * Class wheel as a part of a car
 * has only clutch that increase car's characteristicks
 */
public class Wheel extends CarDetail {
  private Map<Integer, Short> clutch = new HashMap<>();

  /**
   *
   * @param name represents the name of the detail
   * @see CarDetail#name
   * @param clutch
   * @see Car#clutch
   */
  public Wheel(String name, Map<Integer,Short> clutch){
    super(name);
    this.clutch = clutch;
  }

  public Map<Integer, Short> getClutch() {
    return clutch;
  }


  /**
   * @see CarBase#calcRarity()
   *
   * implementation to be provided
   */
  @Override
  protected void calcRarity() {
    //no logic yet
    this.rarity = DetailRarity.C;
  }
}
