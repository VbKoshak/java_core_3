package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

import java.util.HashMap;

public class Wheel extends CarDetail {
  private HashMap<Short, Short> clutch = new HashMap<>();

  public Wheel(DetailQuality quality, String name, HashMap<Short,Short> clutch){
    super(quality,name);
    this.clutch = clutch;
  }

  public HashMap<Short, Short> getClutch() {
    return clutch;
  }
}
