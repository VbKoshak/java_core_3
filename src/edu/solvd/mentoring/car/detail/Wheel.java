package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailRarity;

import java.util.HashMap;
import java.util.Map;

public class Wheel extends CarDetail {
  private Map<Integer, Short> clutch = new HashMap<>();

  public Wheel(String name, Map<Integer,Short> clutch){
    super(name);
    this.clutch = clutch;
  }

  public Map<Integer, Short> getClutch() {
    return clutch;
  }

  @Override
  protected void calcRarity() {
    //no logic yet
    this.rarity = DetailRarity.C;
  }
}
