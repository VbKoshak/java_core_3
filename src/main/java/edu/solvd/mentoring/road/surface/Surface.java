package edu.solvd.mentoring.road.surface;

public class Surface {
  /**
   * name for better user differentiation
   * sym is used in graphical interpretation of the road
   * surfaceId is  used to identificate surface within programm
   */
  private String name;
  private char sym;
  private int surfaceId;

  public Surface(String name, char sym, int surfaceid) {
    this.name = name;
    this.sym = sym;
    this.surfaceId = surfaceid;
  }

  public String getName() {
    return name;
  }

  public char getSym() {
    return sym;
  }

  public int getSurfaceId() {
    return surfaceId;
  }
}
