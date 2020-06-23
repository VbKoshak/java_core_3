package edu.solvd.mentoring.factories;

import edu.solvd.mentoring.Support;
import edu.solvd.mentoring.car.*;
import edu.solvd.mentoring.road.surface.Surface;

import java.util.Map;

public class CarFactory {

  public static CarLike getCar(String carType, Map<Integer, Surface> surfaces){
    switch (carType.toUpperCase()) {
      case "RACECAR":
      case "RACE_CAR":
      case "RACE CAR":
        return new RaceCar(Support.getGeneratedEngine(),Support.getGeneratedWheel(surfaces),Support.getGeneratedCarBase(surfaces));
      case "OFFROADCAR":
      case "OFFROAD_CAR":
      case "OFFROAD CAR":
        return new OffroadCar(Support.getGeneratedEngine(),Support.getGeneratedWheel(surfaces),Support.getGeneratedCarBase(surfaces));
      default:
        return new Car(Support.getGeneratedEngine(),Support.getGeneratedWheel(surfaces),Support.getGeneratedCarBase(surfaces));
    }
  }
}
