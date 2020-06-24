package edu.solvd.mentoring.gameInstances.car;

import edu.solvd.mentoring.gameInstances.car.detail.CarBase;
import edu.solvd.mentoring.gameInstances.car.detail.Engine;
import edu.solvd.mentoring.gameInstances.car.detail.Wheel;

import java.util.HashMap;

/**
 * Car class
 * contains details it is build from
 * and total characteristicks calculated based on details
 * no additional bonuses in characteristicks for this cars
 */
public class Car extends CarLike{

  public Car(Engine engine, Wheel wheel, CarBase base){
    super(engine,wheel,base);
  }

  /**
   * method that is used to calculate final characteristicks based on details car possess
   */
  public void calculateCharacteristicks(){
    this.maxSpeed = (short)(carBase.getBasicMaxSpeed() + engine.getMaxSpeed());
    this.boost = (short)(carBase.getBasicBoost() + engine.getBoost());
    this.clutch = new HashMap<>(this.carBase.getBasicClutch());
    this.wheel.getClutch().forEach(
      (key, value) -> this.clutch.merge( key, value, (v1, v2) -> (short)(v1 + v2))
    );
  }
}
