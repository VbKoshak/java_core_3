package edu.solvd.mentoring.road;

import java.util.ArrayList;

public class Route {
  private double totalDistance;
  private ArrayList<Stage> stages = new ArrayList<>();
  private ArrayList<Character> points = new ArrayList<>();

  public Route(Stage firstStage) {
    this.stages.add(firstStage);
    this.totalDistance = firstStage.getStageDistance();
  }

  public double getTotalDistance() {
    return totalDistance;
  }

  public void addStage(Stage stage){
    this.stages.add(stage);
    this.totalDistance += stage.getStageDistance();
  }

  private void putPoints(){
    // to be implemented ...
  }

  public void getPoints(){
    // to be implemented ...
  }
}
