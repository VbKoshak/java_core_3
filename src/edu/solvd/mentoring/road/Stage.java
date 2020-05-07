package edu.solvd.mentoring.road;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.solvd.mentoring.road.surface.Surface;


/**
 * represents stage in the race
 * stage is some vectors with angles between stright parts of the road with one surface
 */
public class Stage {
  private String stageName;
  private ArrayList<Vector> vectors = new ArrayList<>();
  private Map<Double,Double> angles = new HashMap<>();
  private Surface surface;
  private double stageDistance;

  public Stage(Vector start, String stageName, Surface surface){
    this.stageName = stageName;
    this.surface = surface;
    vectors.add(start);
    this.stageDistance = start.getDistance();
  }



  public void addVector(Vector c){
    angles.put(this.stageDistance,calcAngle(vectors.get(vectors.size()-1),c));
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

  private double calcAngle(Vector v1, Vector v2){
    Point v1_1 = v1.getA();
    Point v1_2 = v1.getB();
    Point v2_1 = v2.getA();
    Point v2_2 = v2.getB();
    double sub1_1 = (v1_2.getX() - v1_1.getX()) * (v2_2.getX() - v2_1.getX());
    double sub1_2 = (v1_2.getY() - v1_1.getY()) * (v2_2.getY() - v2_1.getY());
    double sub2_1 = Math.sqrt(Math.pow((v1_2.getX() - v1_1.getX()),2) + Math.pow((v1_2.getY() - v1_1.getY()),2));
    double sub2_2 = Math.sqrt(Math.pow((v2_2.getX() - v2_1.getX()),2) + Math.pow((v2_2.getY() - v2_1.getY()),2));
    return Math.acos((sub1_1 + sub1_2) / (sub2_1 * sub2_2));
  }

  public Map<Double,Double> getAngles(){
    return this.angles;
  }

  public Point getLastPoint() {
    return this.vectors.get(this.vectors.size() - 1).getB();
  }
}
