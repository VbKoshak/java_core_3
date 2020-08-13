package edu.solvd.mentoring.controlInstances;

import edu.solvd.mentoring.resources.Settings;
import edu.solvd.mentoring.gameInstances.car.Car;
import edu.solvd.mentoring.gameInstances.road.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Participant {
  /**
   * participant's car
   */
  private Car car;

  /**
   * current speed of a participant's car
   */
  private short currentSpeed;

  /**
   * distance left until finish of i stage
   */
  private double[] progressLeft;

  /**
   * distance gone in each stage
   */
  private double[] progress;

  /**
   * shows the list of destances from the start where angle appears and the value of the angle for each stage
   */
  private List<Map<Double,Double>> veerMarks;

  /**
   * ids of surfaces in stages of the route
   */
  private Integer[] surfacesId;

  /**
   * current stage, where player's car is
   */
  private int currentStage = 0;

  /**
   * total distance gone from the start line
   */
  private double kmGone = 0;

  /**
   * symbol that represents participant's icon in the current race
   */
  private char sym;

  /**
   * creates participant, fullfillls necessary info about the race
   *
   * @param car - car to be used in race
   * @param route - route of the race
   * @param sym - symbol for participant's icon
   */
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

  /**
   * tries to increase players speed if possible (depends on boost property of a car)
   */
  private void tryBoost(){
    if (Math.random() > this.car.getBoost() / (Settings.MAX_ENGINE_BOOST + Settings.MAX_CARBASE_BOOST)){
      this.currentSpeed++;
    }
  }

  /**
   * shows how much distance can current car come with such amount of movement points in such surface
   * @param movementPoints - ability of car to move on in this 'tick'
   * @param surfaceId - id of surface of the current stage
   * @return distance that can ve gone with current amount of movementPoints in such surface
   */
  private double getSurfaceMovement(double movementPoints, Integer surfaceId){
    return movementPoints * this.car.getClutchBySurfaceId(surfaceId) / 10;
  }

  /**
   * shows if the part of the road from startPoint have sharp angle (e.g. angle value > 1.0472 (60*))
   * @param startPoint
   * @param distance
   * @return  if sharp angle presents
   *              true
   *          else
   *              false
   */
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


  /**
   * decrease speed by 40% if sharp angle is on the road
   * @param surfaceMovement distance to be gone by a participant in current tick
   */
  private void checkAngles(double surfaceMovement){
    if(this.currentSpeed > 2){
      if ( haveSharpAngles(this.progress[this.currentStage],surfaceMovement) == true){
        this.currentSpeed = (short)Math.ceil(this.currentSpeed * (1 - Settings.SPEED_DECREASE));
      }
    }
  }


  //return -1 if race is not finished else returnes left movementPoints

  /**
   * makes a tick that presents equivalent to a time in this project
   * @param points - if != 0 presents left movementPoints from previous stage but the same tick
   * @return -1 if race continues
   *         some value - movementPoints left after finishing the race
   */
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
