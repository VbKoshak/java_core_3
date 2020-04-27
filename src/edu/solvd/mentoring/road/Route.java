package edu.solvd.mentoring.road;

import java.util.ArrayList;

public class Route {
  private double totalDistance;
  private ArrayList<Stage> stages = new ArrayList<>();
  private ArrayList<Character> points = new ArrayList<>();

  public Route(Stage firstStage) {
    this.totalDistance = firstStage.getStageDistance();
    this.stages.add(firstStage);
  }

  public double getTotalDistance() {
    return totalDistance;
  }
}
