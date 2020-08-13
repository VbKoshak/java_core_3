package edu.solvd.mentoring.gameInstances.road;

/**
 * represents vector in 2D space, which is made of 2 point on (x,y) axis
 * a - 'from' point
 * b - 'to' point
 * distance - distance between point e.g. length of vector
 */
public class Vector {
  private Point a;
  private Point b;
  private double distance;

  public Vector(Point a, Point b) {
    this.a = a;
    this.b = b;
    countDistance();
  }

  /**
   * calculates the distance of the vector
   */
  private void countDistance() {
    this.distance = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(),2) + Math.pow(this.a.getY() - this.b.getY(),2));
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
