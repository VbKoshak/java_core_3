package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.car.detail.CarBase;
import edu.solvd.mentoring.car.detail.CarDetail;
import edu.solvd.mentoring.car.detail.Engine;
import edu.solvd.mentoring.car.detail.Wheel;
import edu.solvd.mentoring.enums.DetailQuality;
import edu.solvd.mentoring.road.*;
import edu.solvd.mentoring.road.Surface;

import java.util.HashMap;

public class Support {
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
  //1 garage
  private HashMap<Integer, Surface> surfaces = new HashMap<>();

  private HashMap<Integer,Wheel> wheels = new HashMap<>();
  private HashMap<Integer, Engine> engines = new HashMap<>();
  private HashMap<Integer, CarBase> carBases = new HashMap<>();

  private HashMap<Integer, Car> cars = new HashMap<>();
  private HashMap<Integer, Route> routes = new HashMap<>();
  private Garage garage = new Garage();

  public Support(){
    initSurfaces();
    initWheels();
    initEngines();
    initCarBases();
    initCars();
    initRoutes();
    initGarage();
  }

  //just a quick converter
  private short s(int i){
    return (short)i;
  }

  private void initSurfaces(){
      this.surfaces.put(1,new Surface("highway",'=',(short)1));
      this.surfaces.put(2,new Surface("city road",'-',(short)2));
      this.surfaces.put(3,new Surface("ferry road",'+',(short)3));
      this.surfaces.put(4,new Surface("country road",'*',(short)4));
  }

  public Surface getSurface(int id){
    return this.surfaces.get(id);
  }

  private void initWheels(){
      HashMap<Short,Short> wheelClutch1 = new HashMap<>();
      HashMap<Short,Short> wheelClutch2 = new HashMap<>();
      HashMap<Short,Short> wheelClutch3 = new HashMap<>();
      HashMap<Short,Short> wheelClutch4 = new HashMap<>();
      HashMap<Short,Short> wheelClutch5 = new HashMap<>();

      //Surface id, clutch [1-7]
      wheelClutch1.put(s(1),s(2));
      wheelClutch1.put(s(2),s(2));
      wheelClutch1.put(s(3),s(2));
      wheelClutch1.put(s(4),s(2));

      wheelClutch2.put(s(1),s(5));
      wheelClutch2.put(s(2),s(1));
      wheelClutch2.put(s(3),s(2));
      wheelClutch2.put(s(4),s(1));

      wheelClutch3.put(s(1),s(1));
      wheelClutch3.put(s(2),s(1));
      wheelClutch3.put(s(3),s(3));
      wheelClutch3.put(s(4),s(4));

      wheelClutch4.put(s(1),s(1));
      wheelClutch4.put(s(2),s(1));
      wheelClutch4.put(s(3),s(7));
      wheelClutch4.put(s(4),s(7));

      wheelClutch5.put(s(1),s(4));
      wheelClutch5.put(s(2),s(6));
      wheelClutch5.put(s(3),s(5));
      wheelClutch5.put(s(4),s(3));



      this.wheels.put(1,new Wheel(DetailQuality.C,"Basic",wheelClutch1));
      this.wheels.put(2,new Wheel(DetailQuality.B,"Sport",wheelClutch1));
      this.wheels.put(3,new Wheel(DetailQuality.B,"OffRoad",wheelClutch1));
      this.wheels.put(4,new Wheel(DetailQuality.A,"OffRoad II",wheelClutch1));
      this.wheels.put(5,new Wheel(DetailQuality.S,"Universal LU",wheelClutch1));
  }

  public Wheel getWheel(int id){
    return this.wheels.get(id);
  }

  private void initEngines(){
      //maxSpeed 0-7
      //boost 0-7
      this.engines.put(1, new Engine(DetailQuality.C, "Horse 1v", s(1), s(1)));
      this.engines.put(2, new Engine(DetailQuality.B, "Just fine", s(5), s(2)));
      this.engines.put(3, new Engine(DetailQuality.B, "Rabbit power", s(2), s(5)));
      this.engines.put(4, new Engine(DetailQuality.A, "HAUDI corp.", s(4), s(4)));
      this.engines.put(5, new Engine(DetailQuality.S, "TERRARI v20", s(6), s(7)));
  }

  public Engine getEngine(int id){
    return this.engines.get(id);
  }

  private void initCarBases(){
      HashMap<Short,Short> baseClutch1 = new HashMap<>();
      HashMap<Short,Short> baseClutch2 = new HashMap<>();
      HashMap<Short,Short> baseClutch3 = new HashMap<>();

      //Surface id, clutch [1-3]
      baseClutch1.put(s(1),s(1));
      baseClutch1.put(s(2),s(1));
      baseClutch1.put(s(3),s(1));
      baseClutch1.put(s(4),s(1));

      baseClutch2.put(s(1),s(1));
      baseClutch2.put(s(2),s(1));
      baseClutch2.put(s(3),s(2));
      baseClutch2.put(s(4),s(3));

      baseClutch3.put(s(1),s(3));
      baseClutch3.put(s(2),s(2));
      baseClutch3.put(s(3),s(1));
      baseClutch3.put(s(4),s(1));

      //maxSpeed 1-3
      //boost 1-3
      this.carBases.put(1,new CarBase(DetailQuality.C,"Basic",s(1),s(1),baseClutch1));
      this.carBases.put(2,new CarBase(DetailQuality.B,"Truck",s(1),s(2),baseClutch2));
      this.carBases.put(3,new CarBase(DetailQuality.B,"Sport",s(2),s(1),baseClutch3));

  }

  public CarBase getCarBase(int id){
    return this.carBases.get(id);
  }

  private void initCars(){
      this.cars.put(1, new Car(this.getEngine(1), this.getWheel(1), this.getCarBase(1)));
      this.cars.put(2, new Car(this.getEngine(3), this.getWheel(2), this.getCarBase(2)));
      this.cars.put(3, new Car(this.getEngine(4), this.getWheel(3), this.getCarBase(2)));
      this.cars.put(4, new Car(this.getEngine(4), this.getWheel(1), this.getCarBase(3)));
      this.cars.put(5, new Car(this.getEngine(3), this.getWheel(4), this.getCarBase(1)));
  }

  public Car getCar(int id){
    return this.cars.get(id);
  }

  private void initRoutes(){
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


      Stage stage1 = new Stage(v1, "Beginner", this.getSurface(1));
      stage1.addVector(v2);
      stage1.addVector(v3);
      Stage stage2 = new Stage(v4, "Cross", this.getSurface(3));
      stage2.addVector(v5);
      stage2.addVector(v6);
      Stage stage3 = new Stage(v7, "Devil Hill", this.getSurface(2));
      stage3.addVector(v8);

      Stage stage11 = new Stage(v11, "Crocodile", this.getSurface(4));
      stage11.addVector(v12);
      stage11.addVector(v13);
      Stage stage12 = new Stage(v14, "Picnic", this.getSurface(3));
      stage12.addVector(v15);
      stage12.addVector(v16);
      Stage stage13 = new Stage(v17, "Beauties nose", this.getSurface(1));
      stage13.addVector(v18);

      Stage stage21 = new Stage(v21, "Loop field", this.getSurface(2));
      stage21.addVector(v22);
      stage21.addVector(v23);
      Stage stage22 = new Stage(v24, "Class rocks", this.getSurface(4));
      stage22.addVector(v25);
      Stage stage23 = new Stage(v26, "Thread hell", this.getSurface(1));
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


      this.routes.put(1, r1);
      this.routes.put(2, r2);
      this.routes.put(3, r3);
  }

  public Route getRoute(int id){return this.routes.get(id);}

  private void initGarage(){
    this.garage.addCarDetail(this.getCarBase(2),400);
    this.garage.addCarDetail(this.getCarBase(3),400);
    this.garage.addCarDetail(this.getEngine(3),250);
    this.garage.addCarDetail(this.getEngine(3),350);
    this.garage.addCarDetail(this.getEngine(4),500);
    this.garage.addCarDetail(this.getWheel(3),200);
    this.garage.addCarDetail(this.getWheel(6),450);
    this.garage.addCarDetail(this.getEngine(3),250);
    this.garage.addCarDetail(this.getEngine(5),750);
  }

  public Garage getGarage(){
    return this.garage;
  }
}
