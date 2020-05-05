package edu.solvd.mentoring.road.surface;

public class Surface {
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
