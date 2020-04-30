package edu.solvd.mentoring.road;

import java.util.ArrayList;

public class Route {
  private double totalDistance;
  private ArrayList<Stage> stages = new ArrayList<>();
  private String points = "|";
  private int length;
  private int charLength = 5;

  public Route(Stage firstStage) {
    this.stages.add(firstStage);
    this.totalDistance = firstStage.getStageDistance();
    putPoints(firstStage);
    this.length = 1;
  }

  public double getTotalDistance() {
    return totalDistance;
  }

  public void addStage(Stage stage){
    this.stages.add(stage);
    this.totalDistance += stage.getStageDistance();
    putPoints(stage);
    this.length++;
  }

  private void putPoints(Stage stage){
    //each character represents length ~= charLength (5 by default)
    int length = (int)Math.ceil(stage.getStageDistance()/charLength);
    char sym = stage.getSurface().getSym();
    for (int i = 0; i < length; i++){
      this.points += sym;
    }
  }

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
