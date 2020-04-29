package edu.solvd.mentoring.car.detail;

import edu.solvd.mentoring.enums.DetailQuality;

public class CarDetail {
  private DetailQuality quality;
  private String name;

  public CarDetail(DetailQuality quality, String name) {
    this.quality = quality;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public DetailQuality getQuality() {
    return quality;
  }
}
