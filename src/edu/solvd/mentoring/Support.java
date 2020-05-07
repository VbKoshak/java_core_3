package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;
import edu.solvd.mentoring.enums.DetailQuality;
import edu.solvd.mentoring.road.*;
import edu.solvd.mentoring.road.surface.Surface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

class Support {
  // make it random so for every new Support() different values are generated
  //
  //4 surfaces
  //
  //5 wheels
  //5 engines
  //3 carBases
  //
  //5 cars
  //3 routes
  private static HashMap<Integer, Surface> surfaces = new HashMap<>();

  private static HashMap<Integer, Wheel> wheels = new HashMap<>();
  private static HashMap<Integer, Engine> engines = new HashMap<>();
  private static HashMap<Integer, CarBase> carBases = new HashMap<>();

  private static HashMap<Integer, Car> cars = new HashMap<>();
  private static HashMap<Integer, Route> routes = new HashMap<>();

  private static final String DEFAULT_NAME = "Some default name";

  //just a quick converter
  private static short s(int i){
    return (short)i;
  }
  private static short s(double d){ return (short)d; }

  //some additional Functions
  private static short getShort(short maxValue, short minValue){
    return (short)(Math.round(Math.random() * (maxValue - minValue)) + minValue);
  }
  private static HashMap<Integer,Short> getGeneratedClutch(short maxClutch, short minClutch, HashMap<Integer,Surface> surfaces){
    HashMap<Integer,Short> clutch = new HashMap<>();
    Set<Integer> surfaceKeys = surfaces.keySet();

    for(Integer i: surfaceKeys){
      short val = s(getShort(maxClutch,minClutch));
      clutch.put(i,val);
    }

    return clutch;
  }

  private static void initSurfaces(){
      surfaces.put(1,new Surface("highway",'=',1));
      surfaces.put(2,new Surface("city road",'-',2));
      surfaces.put(3,new Surface("ferry road",'+',3));
      surfaces.put(4,new Surface("country road",'*',4));
  }

  public static Surface getSurface(int id){
    if (surfaces.isEmpty()){
      initSurfaces();
    }
    return surfaces.get(id);
  }

  public static HashMap<Integer, Surface> getSurfaces(){
    if (surfaces.isEmpty()){
      initSurfaces();
    }
    return surfaces;
  }

  private static void initWheels(){
      HashMap<Integer,Short> wheelClutch1 = new HashMap<>();
      HashMap<Integer,Short> wheelClutch2 = new HashMap<>();
      HashMap<Integer,Short> wheelClutch3 = new HashMap<>();
      HashMap<Integer,Short> wheelClutch4 = new HashMap<>();
      HashMap<Integer,Short> wheelClutch5 = new HashMap<>();

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



      wheels.put(1,new Wheel(DetailQuality.C,"Basic",wheelClutch1));
      wheels.put(2,new Wheel(DetailQuality.B,"Sport",wheelClutch2));
      wheels.put(3,new Wheel(DetailQuality.B,"OffRoad",wheelClutch3));
      wheels.put(4,new Wheel(DetailQuality.A,"OffRoad II",wheelClutch4));
      wheels.put(5,new Wheel(DetailQuality.S,"Universal LU",wheelClutch5));
  }

  public static Wheel getWheel(int id){
    if(wheels.isEmpty() == true){
      initWheels();
    }
    return wheels.get(id);
  }

  public static Wheel getGeneratedWheel(HashMap<Integer,Surface> surfaces){
    HashMap<Integer,Short> clutch = getGeneratedClutch(s(7),s(0),surfaces);
    int avg = 0;
    for (short val: clutch.values()){
      avg += val;
    }
    avg = Math.round(avg/clutch.size());
    DetailQuality dq;
    switch (avg) {
      case 1:
      case 2:
        dq = DetailQuality.C;
        break;
      case 3:
      case 4:
        dq = DetailQuality.B;
        break;
      case 5:
      case 6:
        dq = DetailQuality.A;
        break;
      case 7:
        dq = DetailQuality.S;
        break;
      case 0:
        default:
          dq = DetailQuality.C;
          break;
    }
    
    return new Wheel(dq,DEFAULT_NAME,clutch);

  }

  private static void initEngines(){
      //maxSpeed 0-7
      //boost 0-7
      engines.put(1, new Engine(DetailQuality.C, "Horse 1v", s(1), s(1)));
      engines.put(2, new Engine(DetailQuality.B, "Just fine", s(5), s(2)));
      engines.put(3, new Engine(DetailQuality.B, "Rabbit power", s(2), s(5)));
      engines.put(4, new Engine(DetailQuality.A, "HAUDI corp.", s(4), s(4)));
      engines.put(5, new Engine(DetailQuality.S, "TERRARI v20", s(6), s(7)));
  }

  public static Engine getEngine(int id){
    if(engines.isEmpty()){
      initEngines();
    }
    return engines.get(id);
  }

  public static Engine getGeneratedEngine(){
    short speed = getShort(s(7),s(0));
    short boost = getShort(s(7),s(0));
    DetailQuality dq;
    int avg = Math.round(speed + boost);
    switch (avg) {
      case 1:
      case 2:
        dq = DetailQuality.C;
        break;
      case 3:
      case 4:
        dq = DetailQuality.B;
        break;
      case 5:
      case 6:
        dq = DetailQuality.A;
        break;
      case 7:
        dq = DetailQuality.S;
        break;
      case 0:
      default:
        dq = DetailQuality.C;
        break;
    }
    return new Engine(dq,DEFAULT_NAME,speed,boost);
  }

  private static void initCarBases(){
      HashMap<Integer,Short> baseClutch1 = new HashMap<>();
      HashMap<Integer,Short> baseClutch2 = new HashMap<>();
      HashMap<Integer,Short> baseClutch3 = new HashMap<>();

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
      carBases.put(1,new CarBase(DetailQuality.C,"Basic",s(1),s(1),baseClutch1));
      carBases.put(2,new CarBase(DetailQuality.B,"Truck",s(1),s(2),baseClutch2));
      carBases.put(3,new CarBase(DetailQuality.B,"Sport",s(2),s(1),baseClutch3));

  }

  public static CarBase getCarBase(int id){
    if(carBases.isEmpty()){
      initCarBases();
    }
    return carBases.get(id);
  }

  public static CarBase getGeneratedCarBase(HashMap<Integer,Surface> surfaces){
    HashMap<Integer,Short> clutch = getGeneratedClutch(s(3),s(1),surfaces);
    short speed = getShort(s(3),s(1));
    short boost = getShort(s(3),s(1));
    return new CarBase(DetailQuality.B,DEFAULT_NAME,speed,boost,clutch);
  }

  private static void initCars(){
      cars.put(1, new Car(getEngine(1), getWheel(1), getCarBase(1)));
      cars.put(2, new Car(getEngine(3), getWheel(2), getCarBase(2)));
      cars.put(3, new Car(getEngine(4), getWheel(3), getCarBase(2)));
      cars.put(4, new Car(getEngine(4), getWheel(1), getCarBase(3)));
      cars.put(5, new Car(getEngine(3), getWheel(4), getCarBase(1)));
  }

  public static Car getCar(int id){
    if(cars.isEmpty()){
      initCars();
    }
    return cars.get(id);
  }

  public static Car getGeneratedCar(HashMap<Integer,Surface> surfaces){
    return new Car(getGeneratedEngine(),getGeneratedWheel(surfaces),getGeneratedCarBase(surfaces));
  }

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

  public static Route getRoute(int id){
    if(routes.isEmpty()){
      initRoutes();
    }
    return routes.get(id);
  }

  private static Stage generateStage(int vectorCount, Surface surf, Point startWith){
    final String DEFAULT_NAME = "someDefName";
    final short MAX_INCREASE = 5;
    Point beginPoint = new Point(startWith);
    Point endPoint = new Point(getShort(s(beginPoint.getX() + MAX_INCREASE), s(beginPoint.getX())),getShort(s(beginPoint.getY() + MAX_INCREASE), s(beginPoint.getY())));
    Stage st = new Stage(new Vector(new Point(beginPoint),new Point(endPoint)),DEFAULT_NAME,surf);

    for(int i = 0; i < vectorCount; i++){
      beginPoint = endPoint;
      endPoint = new Point(getShort(s(beginPoint.getX() + MAX_INCREASE), s(beginPoint.getX())),getShort(s(beginPoint.getY() + MAX_INCREASE), s(beginPoint.getY())));
      st.addVector(new Vector(new Point(beginPoint), new Point(endPoint)));
    }
    return st;
  }

  private static Surface getRandomSurface(HashMap<Integer, Surface> surfaces){
    Set<Integer> surfaceKeys = surfaces.keySet();
    Random rand = new Random();

    int index = rand.nextInt(surfaceKeys.size());
    Iterator<Integer> iter = surfaceKeys.iterator();
    for (int i = 0; i < index; i++) {
      iter.next();
    }
    return surfaces.get(iter.next());
  }

  public static Route getGeneratedRoute(int stagesCount, HashMap<Integer,Surface> surfaces) {
    final int DEFAULT_VECTOR_COUNT = 3;
    Stage st = generateStage(DEFAULT_VECTOR_COUNT,getRandomSurface(surfaces),new Point(0,0));
    Point lastPoint = st.getLastPoint();
    Route r = new Route(st);
    stagesCount--;
    for (int i = 0; i < stagesCount; i++){
      Stage stage = generateStage(DEFAULT_VECTOR_COUNT,getRandomSurface(surfaces),lastPoint);
      lastPoint = stage.getLastPoint();
      r.addStage(stage);
    }
    return r;
  }

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
