package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

import java.util.HashMap;
import java.util.Map;

public class Wheel extends CarDetail {
  private Map<Integer, Short> clutch = new HashMap<>();

  public Wheel(DetailQuality quality, String name, Map<Integer,Short> clutch){
    super(quality,name);
    this.clutch = clutch;
  }

  public Map<Integer, Short> getClutch() {
    return clutch;
  }
}
