package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Participant {
  private Car car;
  private short currentSpeed;
  private double[] progressLeft;
  private double[] progress;
  private ArrayList<HashMap<Double,Double>> veerMarks;
  private Integer[] surfacesId;
  private int currentStage = 0;
  private double kmGone = 0;
  private char sym;

  public Participant(Car car, Route route, char sym){
    this.car = car;
    this.sym = sym;
    this.currentSpeed = 1;
    int length = route.getLength();
    this.progressLeft = new double[length];
    this.progress = new double[length];
    this.surfacesId = new Integer[length];
    this.veerMarks = new ArrayList<>();
    for (int i = 0; i < length; i++){
      this.progressLeft[i] = route.getStage(i).getStageDistance();
      this.surfacesId[i] = route.getStage(i).getSurface().getSurfaceId();
      this.veerMarks.add(route.getStage(i).getAngles());
    }
  }

  private void tryBoost(){
    if (Math.random() > this.car.getBoost() / 10){
      this.currentSpeed++;
    }
  }

  private double getSurfaceMovement(double movementPoints, Integer surfaceId){
    return movementPoints * this.car.getClutchBySurfaceId(surfaceId) / 10;
  }

  private boolean haveSharpAngles(double startPoint, double distance){
    double endPoint = startPoint + distance;
    for (Map.Entry<Double, Double> entry : this.veerMarks.get(currentStage).entrySet()) {
      if (entry.getKey() > startPoint && entry.getKey() < endPoint){
        if (entry.getValue() > 1.0472){  //1.0472 == 60*
          return true;
        }
      }
      if (entry.getKey() > endPoint){
        return false;
      }
    }
    return false;
  }

  private void checkAngles(double surfaceMovement){
    if(this.currentSpeed > 2){
      if ( haveSharpAngles(this.progress[this.currentStage],surfaceMovement) == true){
        this.currentSpeed = (short)Math.ceil(this.currentSpeed * 0.6);
      }
    }
  }


  //return -1 if race is not finished else returnes left movementPoints
  public double makeTick(double points){
    if (points == 0) {
      if (this.currentSpeed < car.getMaxSpeed()) {
        tryBoost();
      }
    }
    double movementPoints = points > 0 ? points : this.currentSpeed;
    double surfaceMovement = getSurfaceMovement(movementPoints,this.surfacesId[this.currentStage]);
    if (this.progressLeft[this.currentStage] > surfaceMovement){
      this.progressLeft[this.currentStage] -= surfaceMovement;
      checkAngles(surfaceMovement);
      this.progress[this.currentStage] += surfaceMovement;
      this.kmGone += surfaceMovement;
      return -1;
    } else if (this.progressLeft[this.currentStage] == surfaceMovement){
      this.progressLeft[this.currentStage] = 0;
      checkAngles(surfaceMovement);
      this.progress[this.currentStage] += surfaceMovement;
      this.currentStage++;
      this.kmGone += surfaceMovement;
      if (this.currentStage == this.progressLeft.length){
        return 0.0001;
      } else {
        return -1;
      }
    } else {
      double pointsLeftToFinishStage = this.progressLeft[this.currentStage] * 10 / this.car.getClutchBySurfaceId(this.surfacesId[this.currentStage]);
      movementPoints -= pointsLeftToFinishStage;
      this.progressLeft[currentStage] = 0;
      checkAngles(pointsLeftToFinishStage);
      this.progress[currentStage] += pointsLeftToFinishStage;
      this.kmGone += this.progressLeft[this.currentStage];
      //substracting points needed to finish current stage
      this.progressLeft[this.currentStage] = 0;
      this.currentStage++;
      if (this.currentStage == this.progressLeft.length){  // check if race is finished
        return movementPoints;
      } else {
        return makeTick(movementPoints);
      }
    }

  }

  public double getKmGone() {
    return kmGone;
  }

  public char getSym() {
    return sym;
  }
}
