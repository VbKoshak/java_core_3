package edu.solvd.mentoring.road;

public class Vector {
  private Point a;
  private Point b;
  private double distance;

  public Vector(Point a, Point b) {
    this.a = a;
    this.b = b;
    countDistance();
  }

  private void countDistance() {
    this.distance = Math.sqrt(Math.pow(this.a.getX(),2) + Math.pow(this.b.getX(),2));
  }

  public double getDistance() {
    return distance;
  }
  public Point getA(){
    return this.a;
  }

  public Point getB(){
    return this.b;
  }
}
