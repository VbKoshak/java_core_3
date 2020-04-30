package edu.solvd.mentoring.road;

import java.util.ArrayList;

public class Route {
  private double totalDistance;
  private ArrayList<Stage> stages = new ArrayList<>();
  private String points = "|";

  public Route(Stage firstStage) {
    this.stages.add(firstStage);
    this.totalDistance = firstStage.getStageDistance();
    putPoints(firstStage);
  }

  public double getTotalDistance() {
    return totalDistance;
  }

  public void addStage(Stage stage){
    this.stages.add(stage);
    this.totalDistance += stage.getStageDistance();
    putPoints(stage);
  }

  private void putPoints(Stage stage){
    //each character represents length ~= 5
    int length = (int)Math.ceil(stage.getStageDistance()/5);
    char sym = stage.getSurface().getSym();
    for (int i = 0; i < length; i++){
      this.points += sym;
    }
  }

  public void showRoute(){
    System.out.println(points);
  }
}
