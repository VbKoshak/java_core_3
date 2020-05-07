package edu.solvd.mentoring;

/**
 * class that can be defined as settings
 * !IMPORTANT! do not influence predefined sets of element
 * @see Support#initSurfaces , Support#initWheels etc.
 */
public class Constants {
  /**
   * DEFAULT_NAME - name used for generated carDetails
   * MAX(MIN)_AXISLENGTH_INCREASE - maximum (minimum) increase in axes between to ordered points of the road
   * DEFAULT_ROUTES_VECTOR_COUNT - default number of vectors in route
   * MAX(MIN)_ENGINE_SPEED - maximum(minimum) speed engine can possess
   * SPEED_DECREASE - value from [0-1] showing the lost in speed after sharp angle
   * same goes with:
   *        MAX(MIN)_ENGINE_BOOST
   *        MAX(MIN)_WHEEL_CLUTCH
   *        MAX(MIN)_CARBASE_SPEED
   *        MAX(MIN)_CARBASE_BOOST
   *        MAX(MIN)_CARBASE_CLUTCH
   */
  public static final String DEFAULT_NAME = "Some default name";
  public static final short MAX_AXISLENGTH_INCREASE = 5;
  public static final int DEFAULT_ROUTES_VECTOR_COUNT = 3;
  public static final short MAX_ENGINE_SPEED = 7;
  public static final short MIN_ENGINE_SPEED = 0;
  public static final short MAX_ENGINE_BOOST = 7;
  public static final short MIN_ENGINE_BOOST = 0;
  public static final short MAX_WHEEL_CLUTCH = 7;
  public static final short MIN_WHEEL_CLUTCH = 7;
  public static final short MAX_CARBASE_SPEED = 3;
  public static final short MIN_CARBASE_SPEED = 1;
  public static final short MAX_CARBASE_BOOST = 3;
  public static final short MIN_CARBASE_BOOST = 1;
  public static final short MAX_CARBASE_CLUTCH = 3;
  public static final short MIN_CARBASE_CLUTCH = 1;
  public static final double SPEED_DECREASE = 0.4;
}
