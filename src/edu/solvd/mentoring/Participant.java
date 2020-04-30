package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

public class Participant {
  private Car car;
  private short currentSpeed;
  private double[] progress;
  private Short[] surfacesId;
  private int currentStage = 0;
  private double kmGone = 0;
  private char sym;

  public Participant(Car car, Route route, char sym){
    this.car = car;
    this.sym = sym;
    this.currentSpeed = 1;
    int length = route.getLength();
    this.progress = new double[length];
    this.surfacesId = new Short[length];
    for (int i = 0; i < length; i++){
      this.progress[i] = route.getStage(i).getStageDistance();
      this.surfacesId[i] = route.getStage(i).getSurface().getSurfaceId();
    }
  }

  private void tryBoost(){
    if (Math.random() > this.car.getBoost() / 10){
      this.currentSpeed++;
    }
  }

  private double getSurfaceMovement(double movementPoints, Short surfaceId){
    return movementPoints * this.car.getClutchBySurfaceId(surfaceId) / 10;
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
    if (this.progress[this.currentStage] > surfaceMovement){
      this.progress[this.currentStage] -= surfaceMovement;
      this.kmGone += surfaceMovement;
      return -1;
    } else if (this.progress[this.currentStage] == surfaceMovement){
      this.progress[this.currentStage] = 0;
      this.currentStage++;
      this.kmGone += surfaceMovement;
      if (this.currentStage == this.progress.length){
        return 0.0001;
      } else {
        return -1;
      }
    } else {
      double pointsLeftToFinishStage = this.progress[this.currentStage] * 10 / this.car.getClutchBySurfaceId(this.surfacesId[this.currentStage]);
      movementPoints -= pointsLeftToFinishStage;
      this.kmGone += this.progress[this.currentStage];
      //substracting points needed to finish current stage
      this.progress[this.currentStage] = 0;
      this.currentStage++;
      if (this.currentStage == this.progress.length){  // check if race is finished
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
