package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;
import edu.solvd.mentoring.enums.ErrReason;
import edu.solvd.mentoring.exceptions.IncorrectInputException;
import edu.solvd.mentoring.exceptions.IncorrectInputExceptionHandler;
import edu.solvd.mentoring.road.*;
import edu.solvd.mentoring.road.Vector;
import edu.solvd.mentoring.road.surface.Surface;

import java.util.*;

/**
 * Support class that helps to generate some instances of everythiing in the game)
 *
 * contains :
 *  pre-defined
 *    4 surfaces
 *    5 wheels
 *    5 engines
 *    3 carBases
 *    5 cars
 *    3 routes
 *    1 garage
 *  generators for:
 *    Wheel
 *    Engine
 *    CarBase
 *    Car
 *    Route
 */
class Support {
  /**
   * map of pre-defined
   *    surfaces
   *    wheels
   *    engines
   *    CarBases
   *    Cars
   *    Routes
   * where key is id of pre-defined object
   */
  private static Map<Integer, Surface> surfaces = new HashMap<>();

  private static Map<Integer, Wheel> wheels = new HashMap<>();
  private static Map<Integer, Engine> engines = new HashMap<>();
  private static Map<Integer, CarBase> carBases = new HashMap<>();

  private static Map<Integer, Car> cars = new HashMap<>();
  private static Map<Integer, Route> routes = new HashMap<>();

  /**
   * quick converter to Short from int and double
   * @param i value to convert
   * @return short variant of i
   */
  private static short s(int i) {
    try{
      if (i > 32767 || i < -32768) {
        throw new IncorrectInputExceptionHandler(ErrReason.InappropriateNum,"ToShort " + i + " ");
      }
      return (short)i;
    } catch (IncorrectInputExceptionHandler err) {
      System.out.println(err.showMessage());
      return 0;
    }
  }
  private static short s(double i) {
    try {
      if (i > 32767 || i < -32768) {
        throw new IncorrectInputExceptionHandler(ErrReason.InappropriateNum,"ToShort " + i + " ");
      }
      return (short)i;
    } catch (IncorrectInputExceptionHandler err) {
      System.out.println(err.showMessage());
      return 0;
    }
  }


  /**
   * returnes a random short value from minValue to maxValue included
   * @param maxValue - upper bound of a short
   * @param minValue - lower bound of a short
   * @return some random short from minValue to maxValue
   */
  private static short getShort(short maxValue, short minValue){
    return (short)(Math.round(Math.random() * (maxValue - minValue)) + minValue);
  }

  /**
   * return a random clutch for certain surfaces map with values between minValue and maxValue
   * @param maxClutch - maximum value of clutch
   * @param minClutch - minimum value of clutch
   * @param surfaces - surface map to get clutch for
   * @return Clutch corresponding to requested surface Map
   */
  private static Map<Integer,Short> getGeneratedClutch(short maxClutch, short minClutch, Map<Integer,Surface> surfaces){
    Map<Integer,Short> clutch = new HashMap<>();
    Set<Integer> surfaceKeys = surfaces.keySet();
    try {
      if (surfaceKeys.size() == 0) {
        throw new IncorrectInputExceptionHandler(ErrReason.EmptyArray,"Surfaces").getError();
      }
      if (maxClutch <= minClutch) {
        throw new IncorrectInputExceptionHandler(ErrReason.LogicError,"Min and Max Clutch values").getError();
      }
    } catch (IncorrectInputException exc){
      exc.getMessage();
      System.exit(2);
    }

    for(Integer i: surfaceKeys){
      short val = getShort(maxClutch,minClutch);
      clutch.put(i,val);
    }

    return clutch;
  }

  /**
   * initialize some basic manually pre-defined Surfaces and put them in this.surfaces
   */
  private static void initSurfaces(){
      surfaces.put(1,new Surface("highway",'=',1));
      surfaces.put(2,new Surface("city road",'-',2));
      surfaces.put(3,new Surface("ferry road",'+',3));
      surfaces.put(4,new Surface("country road",'*',4));
  }

  /**
   * returnes a Surface from predefined values by id
   * @param id - surface id to get
   * @return surface, corresponding to given id
   */
  public static Surface getSurface(int id){
    if (surfaces.isEmpty()){
      initSurfaces();
    }
    return surfaces.get(id);
  }

  /**
   * returnes a random Surfaces from a given Map
   * @param surfaces a map of surfaces to choose from
   * @return surface a random surface from the map
   */
  private static Surface getRandomSurface(Map<Integer, Surface> surfaces){
    Set<Integer> surfaceKeys = surfaces.keySet();
    Random rand = new Random();

    int index = rand.nextInt(surfaceKeys.size());
    Iterator<Integer> iter = surfaceKeys.iterator();
    for (int i = 0; i < index; i++) {
      iter.next();
    }
    return surfaces.get(iter.next());
  }

  /**
   * return a map of manually pre-defined surfaces
   * @return Map of surfaces
   */
  public static Map<Integer, Surface> getSurfaces(){
    if (surfaces.isEmpty()){
      initSurfaces();
    }
    return surfaces;
  }

  /**
   * initialize some basic manually pre-defined Wheels and put them in this.wheels
   */
  private static void initWheels(){
      Map<Integer,Short> wheelClutch1 = new HashMap<>();
      Map<Integer,Short> wheelClutch2 = new HashMap<>();
      Map<Integer,Short> wheelClutch3 = new HashMap<>();
      Map<Integer,Short> wheelClutch4 = new HashMap<>();
      Map<Integer,Short> wheelClutch5 = new HashMap<>();

      //Surface id, clutch [0-7]
      wheelClutch1.put(1,s(2));
      wheelClutch1.put(2,s(2));
      wheelClutch1.put(3,s(2));
      wheelClutch1.put(4,s(2));

      wheelClutch2.put(1,s(5));
      wheelClutch2.put(2,s(1));
      wheelClutch2.put(3,s(2));
      wheelClutch2.put(4,s(1));

      wheelClutch3.put(1,s(1));
      wheelClutch3.put(2,s(1));
      wheelClutch3.put(3,s(3));
      wheelClutch3.put(4,s(4));

      wheelClutch4.put(1,s(1));
      wheelClutch4.put(2,s(1));
      wheelClutch4.put(3,s(7));
      wheelClutch4.put(4,s(7));

      wheelClutch5.put(1,s(4));
      wheelClutch5.put(2,s(6));
      wheelClutch5.put(3,s(5));
      wheelClutch5.put(4,s(3));



      wheels.put(1,new Wheel("Basic",wheelClutch1));
      wheels.put(2,new Wheel("Sport",wheelClutch2));
      wheels.put(3,new Wheel("OffRoad",wheelClutch3));
      wheels.put(4,new Wheel("OffRoad II",wheelClutch4));
      wheels.put(5,new Wheel("Universal LU",wheelClutch5));
  }

  /**
   * returnes a Wheel from predefined values by id
   * @param id - whell id to get
   * @return wheel, corresponding to given id
   */
  public static Wheel getWheel(int id){
    if(wheels.isEmpty() == true){
      initWheels();
    }
    return wheels.get(id);
  }

  /**
   * generate a wheel with random characteristics according to Settings
   * @param surfaces surfaces for a wheel to be able to go with
   * @return Wheel
   */
  public static Wheel getGeneratedWheel(Map<Integer,Surface> surfaces){
    Map<Integer,Short> clutch = getGeneratedClutch(Settings.MAX_WHEEL_CLUTCH, Settings.MIN_WHEEL_CLUTCH,surfaces);
    return new Wheel(Settings.DEFAULT_NAME,clutch);

  }

  /**
   * initialize some basic manually pre-defined Engines and put them in this.engines
   */
  private static void initEngines(){
      //maxSpeed 0-7
      //boost 0-7
      engines.put(1, new Engine("Horse 1v", s(1), s(1)));
      engines.put(2, new Engine("Just fine", s(5), s(2)));
      engines.put(3, new Engine("Rabbit power", s(2), s(5)));
      engines.put(4, new Engine("HAUDI corp.", s(4), s(4)));
      engines.put(5, new Engine("TERRARI v20", s(6), s(7)));
  }

  /**
   * returnes an Engine from predefined values by id
   * @param id - engine id to get
   * @return engine, corresponding to given id
   */
  public static Engine getEngine(int id){
    if(engines.isEmpty()){
      initEngines();
    }
    return engines.get(id);
  }

  /**
   * generate an engine with random characteristics according to Settings
   * @return Engine
   */
  public static Engine getGeneratedEngine(){
    short speed = getShort(Settings.MAX_ENGINE_SPEED, Settings.MIN_ENGINE_SPEED);
    short boost = getShort(Settings.MAX_ENGINE_BOOST, Settings.MIN_ENGINE_BOOST);
    return new Engine(Settings.DEFAULT_NAME,speed,boost);
  }

  /**
   * initialize some basic manually pre-defined CarBases and put them in this.carBases
   */
  private static void initCarBases(){
      Map<Integer,Short> baseClutch1 = new HashMap<>();
      Map<Integer,Short> baseClutch2 = new HashMap<>();
      Map<Integer,Short> baseClutch3 = new HashMap<>();

      //Surface id, clutch [1-3]
      baseClutch1.put(1,s(1));
      baseClutch1.put(2,s(1));
      baseClutch1.put(3,s(1));
      baseClutch1.put(4,s(1));

      baseClutch2.put(1,s(1));
      baseClutch2.put(2,s(1));
      baseClutch2.put(3,s(2));
      baseClutch2.put(4,s(3));

      baseClutch3.put(1,s(3));
      baseClutch3.put(2,s(2));
      baseClutch3.put(3,s(1));
      baseClutch3.put(4,s(1));

      //maxSpeed 1-3
      //boost 1-3
      carBases.put(1,new CarBase("Basic",s(1),s(1),baseClutch1));
      carBases.put(2,new CarBase("Truck",s(1),s(2),baseClutch2));
      carBases.put(3,new CarBase("Sport",s(2),s(1),baseClutch3));

  }

  /**
   * returnes a CarBase from predefined values by id
   * @param id - CarBase id to get
   * @return carBase, corresponding to given id
   */
  public static CarBase getCarBase(int id){
    if(carBases.isEmpty()){
      initCarBases();
    }
    return carBases.get(id);
  }

  /**
   * generate a CarBase with random characteristics according to Settings
   * @param surfaces surfaces for a carBase to be able to deal with
   * @return CarBase
   */
  public static CarBase getGeneratedCarBase(Map<Integer,Surface> surfaces){
    Map<Integer,Short> clutch = getGeneratedClutch(Settings.MAX_CARBASE_CLUTCH, Settings.MIN_CARBASE_CLUTCH,surfaces);
    short speed = getShort(Settings.MAX_CARBASE_SPEED, Settings.MIN_CARBASE_SPEED);
    short boost = getShort(Settings.MAX_CARBASE_BOOST, Settings.MIN_CARBASE_BOOST);
    return new CarBase(Settings.DEFAULT_NAME,speed,boost,clutch);
  }

  /**
   * initialize some basic manually pre-defined Cars and put them in this.cars
   */
  private static void initCars(){
      cars.put(1, new Car(getEngine(1), getWheel(1), getCarBase(1)));
      cars.put(2, new Car(getEngine(3), getWheel(2), getCarBase(2)));
      cars.put(3, new Car(getEngine(4), getWheel(3), getCarBase(2)));
      cars.put(4, new Car(getEngine(4), getWheel(1), getCarBase(3)));
      cars.put(5, new Car(getEngine(3), getWheel(4), getCarBase(1)));
  }

  /**
   * returnes a Car from predefined values by id
   * @param id - Car id to get
   * @return Car, corresponding to given id
   */
  public static Car getCar(int id){
    if(cars.isEmpty()){
      initCars();
    }
    return cars.get(id);
  }

  /**
   * generate a Car with random characteristics according to Settings
   * @param surfaces surfaces for a car to be able to deal with
   * @return Car
   */
  public static Car getGeneratedCar(Map<Integer,Surface> surfaces){
    return new Car(getGeneratedEngine(),getGeneratedWheel(surfaces),getGeneratedCarBase(surfaces));
  }

  /**
   * initialize some basic manually pre-defined Routes and put them in this.routes
   */
  private static void initRoutes(){
      Vector v1 = new Vector(new Point(1, 1), new Point(2, 4));
      Vector v2 = new Vector(new Point(2, 4), new Point(5, 2));
      Vector v3 = new Vector(new Point(5, 2), new Point(6, 6));
      Vector v4 = new Vector(new Point(6, 6), new Point(7, 6));
      Vector v5 = new Vector(new Point(7, 6), new Point(9, 8));
      Vector v6 = new Vector(new Point(9, 8), new Point(10, 12));
      Vector v7 = new Vector(new Point(10, 12), new Point(13, 15));
      Vector v8 = new Vector(new Point(13, 15), new Point(14, 18));

      Vector v11 = new Vector(new Point(1, 1), new Point(5, 4));
      Vector v12 = new Vector(new Point(5, 4), new Point(10, 5));
      Vector v13 = new Vector(new Point(10, 5), new Point(14, 6));
      Vector v14 = new Vector(new Point(13, 6), new Point(17, 8));
      Vector v15 = new Vector(new Point(17, 8), new Point(20, 10));
      Vector v16 = new Vector(new Point(20, 10), new Point(24, 17));
      Vector v17 = new Vector(new Point(24, 17), new Point(24, 30));
      Vector v18 = new Vector(new Point(24, 30), new Point(25, 40));

      Vector v21 = new Vector(new Point(1, 1), new Point(2, 8));
      Vector v22 = new Vector(new Point(2, 8), new Point(10, 18));
      Vector v23 = new Vector(new Point(10, 18), new Point(15, 19));
      Vector v24 = new Vector(new Point(15, 19), new Point(20, 20));
      Vector v25 = new Vector(new Point(20, 20), new Point(22, 30));
      Vector v26 = new Vector(new Point(22, 30), new Point(24, 40));
      Vector v27 = new Vector(new Point(24, 40), new Point(30, 50));
      Vector v28 = new Vector(new Point(30, 50), new Point(35, 51));


      Stage stage1 = new Stage(v1, "Beginner", getSurface(1));
      stage1.addVector(v2);
      stage1.addVector(v3);
      Stage stage2 = new Stage(v4, "Cross", getSurface(3));
      stage2.addVector(v5);
      stage2.addVector(v6);
      Stage stage3 = new Stage(v7, "Devil Hill", getSurface(2));
      stage3.addVector(v8);

      Stage stage11 = new Stage(v11, "Crocodile", getSurface(4));
      stage11.addVector(v12);
      stage11.addVector(v13);
      Stage stage12 = new Stage(v14, "Picnic", getSurface(3));
      stage12.addVector(v15);
      stage12.addVector(v16);
      Stage stage13 = new Stage(v17, "Beauties nose", getSurface(1));
      stage13.addVector(v18);

      Stage stage21 = new Stage(v21, "Loop field", getSurface(2));
      stage21.addVector(v22);
      stage21.addVector(v23);
      Stage stage22 = new Stage(v24, "Class rocks", getSurface(4));
      stage22.addVector(v25);
      Stage stage23 = new Stage(v26, "Thread hell", getSurface(1));
      stage23.addVector(v27);
      stage23.addVector(v28);


      Route r1 = new Route(stage1);
      r1.addStage(stage2);
      r1.addStage(stage3);

      Route r2 = new Route(stage11);
      r2.addStage(stage12);
      r2.addStage(stage13);

      Route r3 = new Route(stage21);
      r3.addStage(stage22);
      r3.addStage(stage23);


      routes.put(1, r1);
      routes.put(2, r2);
      routes.put(3, r3);
  }

  /**
   * returnes a Route from predefined values by id
   * @param id - route id to get
   * @return route, corresponding to given id
   */
  public static Route getRoute(int id){
    if(routes.isEmpty()){
      initRoutes();
    }
    return routes.get(id);
  }

  /**
   *  generate a stage with given amount of vectos, surface and startPoint
   * @param vectorCount - number f vectors in the stage
   * @param surf - surface for a stage
   * @param startWith - Point where Stage begins
   * @return Stage
   */
  private static Stage generateStage(int vectorCount, Surface surf, Point startWith){

    Point beginPoint = startWith.clone();
    Point endPoint = new Point(getShort(s(beginPoint.getX() + Settings.MAX_AXISLENGTH_INCREASE), s(beginPoint.getX())),getShort(s(beginPoint.getY() + Settings.MAX_AXISLENGTH_INCREASE), s(beginPoint.getY())));
    Stage st = new Stage(new Vector(beginPoint.clone(),endPoint.clone()), Settings.DEFAULT_NAME,surf);

    for(int i = 0; i < vectorCount; i++){
      beginPoint = endPoint;
      endPoint = new Point(getShort(s(beginPoint.getX() + Settings.MAX_AXISLENGTH_INCREASE), s(beginPoint.getX())),getShort(s(beginPoint.getY() + Settings.MAX_AXISLENGTH_INCREASE), s(beginPoint.getY())));
      st.addVector(new Vector(beginPoint.clone(),endPoint.clone()));
    }
    return st;
  }

  /**
   * returnes a randomly generated route according to settings with given amount of stages and surfaces
   * @param stagesCount - number of stages in Route
   * @param surfaces - map of available surfaces for the current Route
   * @return Route
   */
  public static Route getGeneratedRoute(int stagesCount, Map<Integer,Surface> surfaces) {
    Stage st = generateStage(Settings.DEFAULT_ROUTES_VECTOR_COUNT,getRandomSurface(surfaces),new Point(0,0));
    Point lastPoint = st.getLastPoint();
    Route r = new Route(st);
    stagesCount--;
    for (int i = 0; i < stagesCount; i++){
      Stage stage = generateStage(Settings.DEFAULT_ROUTES_VECTOR_COUNT,getRandomSurface(surfaces),lastPoint);
      lastPoint = stage.getLastPoint();
      r.addStage(stage);
    }
    return r;
  }

  /**
   * initialize some basic manually pre-defined garage and put them in this.garage
   */
  public static void initGarage(){
    Garage.addCarDetail(getCarBase(2),400);
    Garage.addCarDetail(getCarBase(3),400);
    Garage.addCarDetail(getEngine(3),250);
    Garage.addCarDetail(getEngine(3),350);
    Garage.addCarDetail(getEngine(4),500);
    Garage.addCarDetail(getWheel(3),200);
    Garage.addCarDetail(getWheel(6),450);
    Garage.addCarDetail(getEngine(3),250);
    Garage.addCarDetail(getEngine(5),750);
  }
}
