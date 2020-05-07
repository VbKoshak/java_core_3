package edu.solvd.mentoring.car;

import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;

import java.util.HashMap;
import java.util.Map;

public class Car {
  Engine engine;
  Wheel wheel;
  CarBase carBase;

  short maxSpeed;
  short boost;
  Map<Integer,Short> clutch;

  public Car(Engine engine, Wheel wheel, CarBase base){
    this.engine = engine;
    this.wheel = wheel;
    this.carBase = base;
    calculateCharacteristicks();
  }

  private void calculateCharacteristicks(){
    this.maxSpeed = (short)(carBase.getBasicMaxSpeed() + engine.getMaxSpeed());
    this.boost = (short)(carBase.getBasicBoost() + engine.getBoost());
    this.clutch = new HashMap<>(this.carBase.getBasicClutch());
    this.wheel.getClutch().forEach(
      (key, value) -> this.clutch.merge( key, value, (v1, v2) -> (short)(v1 + v2))
    );
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
    calculateCharacteristicks();
  }

  public void setWheel(Wheel wheel) {
    this.wheel = wheel;
    calculateCharacteristicks();
  }

  public void setCarBase(CarBase carBase) {
    this.carBase = carBase;
    calculateCharacteristicks();
  }

  public Engine getEngine() {
    return engine;
  }

  public Wheel getWheel() {
    return wheel;
  }

  public CarBase getCarBase() {
    return carBase;
  }

  public short getMaxSpeed() {
    return maxSpeed;
  }

  public short getBoost() {
    return boost;
  }

  public Map<Integer, Short> getClutch() {
    return clutch;
  }

  public short getClutchBySurfaceId(Integer id){
    return this.clutch.get(id);
  }
}
