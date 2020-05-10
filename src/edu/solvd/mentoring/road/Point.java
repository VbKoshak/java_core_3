package edu.solvd.mentoring.road;

/**
 * represents point as point in 2D with x,y ordinates system
 * x - ordinate on x-axis
 * y - ordinates on y-axis
 */

public class Point implements  Cloneable  {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Point clone(){
    try {
      return (Point)super.clone();
    } catch (CloneNotSupportedException ex ){
      throw new InternalError();
    }
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String toString(){
    return ("x: " + this.x + " y: " + this.y);
  }
}
