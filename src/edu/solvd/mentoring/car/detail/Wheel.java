package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

import java.util.HashMap;

public class Wheel extends CarDetail {
  private HashMap<Integer, Short> clutch = new HashMap<>();

  public Wheel(DetailQuality quality, String name, HashMap<Integer,Short> clutch){
    super(quality,name);
    this.clutch = clutch;
  }

  public HashMap<Integer, Short> getClutch() {
    return clutch;
  }
}
