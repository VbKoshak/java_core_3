package edu.solvd.mentoring.car;

import edu.solvd.mentoring.Settings;
import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;

import java.util.HashMap;

/**
 * RaceCar class
 * contains details it is build from
 * and total characteristicks calculated based on details
 * additional points to maxSpeed and boost
 */
public class OffroadCar extends Car {


  public OffroadCar(Engine engine, Wheel wheel, CarBase base) {
    super(engine,wheel,base);
    calculateCharacteristicks();
  }

  public void calculateCharacteristicks(){
    this.maxSpeed = (short)(carBase.getBasicMaxSpeed() + engine.getMaxSpeed());
    this.boost = (short)(carBase.getBasicBoost() + engine.getBoost());
    this.clutch = new HashMap<>(this.carBase.getBasicClutch());
    this.wheel.getClutch().forEach(
      (key, value) -> this.clutch.merge( key, value, (v1, v2) -> (short)(v1 + v2  + Settings.SPECIFICATION_BONUS))
    );
  }
}
