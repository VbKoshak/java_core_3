package edu.solvd.mentoring.road;

public class Surface {
  private String name;
  private char sym;
  private short surfaceId;

  public Surface(String name, char sym, short surfaceid) {
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

  public short getSurfaceId() {
    return surfaceId;
  }
}
