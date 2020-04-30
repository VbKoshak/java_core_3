package edu.solvd.mentoring.road;

import java.util.ArrayList;
import edu.solvd.mentoring.road.Surface;

public class Stage {
  private String stageName;
  private ArrayList<Vector> vectors = new ArrayList<Vector>();
  private Surface surface;
  private double stageDistance;

  public Stage(Vector start, String stageName, Surface surface){
    this.stageName = stageName;
    this.surface = surface;
    vectors.add(start);
    this.stageDistance = start.getDistance();
  }

  public void addVector(Vector c){
    vectors.add(c);
    this.stageDistance += c.getDistance();
  }

  public String getStageName(){
    return this.stageName;
  }

  public Surface getSurface() {
    return this.surface;
  }

  public double getStageDistance() {
    return this.stageDistance;
  }
}
