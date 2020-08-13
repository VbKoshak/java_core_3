package edu.solvd.mentoring.gameInstances.road;

import java.util.ArrayList;
import java.util.List;

/**
 * the road that cars take race in
 * consists of several stages
 * @see Stage
 *
 */

public class Route {
  /**
   * total distance - distance of the entire route
   * stages - list of stages (parts) of the route
   * points - string that presents the entire route in symbols,
   * where each symbol represents part of the road with { charLength } length and appropriate symbol
   * @see Surface#sym
   * length - number of stages in the route
   */
  private double totalDistance;
  private List<Stage> stages = new ArrayList<>();
  private String points = "|";
  private int length;
  private int charLength = 5;

  /**
   *
   * @param firstStage - first stage of the route
   */
  public Route(Stage firstStage) {
    this.stages.add(firstStage);
    this.totalDistance = firstStage.getStageDistance();
    putPoints(firstStage);
    this.length = 1;
  }

  public double getTotalDistance() {
    return totalDistance;
  }

  /**
   * add stage to the road
   * total distance, String representation and length will bew updated automatically
   * @param stage - Stage to be added
   */
  public void addStage(Stage stage){
    this.stages.add(stage);
    this.totalDistance += stage.getStageDistance();
    putPoints(stage);
    this.length++;
  }

  /**
   * inner method to update String representation of the route by getting { sym } from stage
   * @param stage stage that should be added to points
   */
  private void putPoints(Stage stage){
    //each character represents length ~= charLength (5 by default)
    int length = (int)Math.ceil(stage.getStageDistance()/charLength);
    char sym = stage.getSurface().getSym();
    for (int i = 0; i < length; i++){
      this.points += sym;
    }
  }

  /**
   * Prints String representation of the entire road in Route
   */
  public void showRoute(){
    System.out.println(points);
  }

  public Stage getStage(int index){
    return stages.get(index);
  }

  public int getLength(){
    return this.length;
  }

  public int getCharLength(){
    return this.charLength;
  }
}
