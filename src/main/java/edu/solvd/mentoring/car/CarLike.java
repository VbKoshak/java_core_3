package edu.solvd.mentoring.car;

import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;

import java.util.Map;

public abstract class CarLike{
  /**
   * car details
   *
   * @see CarBase
   * @see Engine
   * @see Wheel
   */
  protected Engine engine;
  protected Wheel wheel;
  protected CarBase carBase;

  /**
   * total car characteristicks that define it's movement
   *
   * maxSpeed defines maximum speed car can achieve
   * boost defines chance to increase speed
   * clutch defines how well car goes on different surfaces
   */
  protected short maxSpeed;
  protected short boost;
  protected Map<Integer,Short> clutch;

  abstract void calculateCharacteristicks();

  public CarLike(Engine engine, Wheel wheel, CarBase base){
    this.engine = engine;
    this.wheel = wheel;
    this.carBase = base;
    calculateCharacteristicks();
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

  /**
   * returns clutch on a particular surface using surface id
   *
   * @param id id of a surface
   * @return clutch on surface with such id
   */
  public short getClutchBySurfaceId(Integer id){
    return this.clutch.get(id);
  }
}
