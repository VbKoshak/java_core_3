package edu.solvd.mentoring.road;

public class Surface {
  private String name;
  private short influence; // 0-100
  private char sym;
  private short surfaceId;

  protected Surface(String name, short influence, char sym, short surfaceid) {
    this.name = name;
    this.influence = influence;
    this.sym = sym;
    this.surfaceId = surfaceid;
  }

  public String getName() {
    return name;
  }

  public short getInfluence() {
    return influence;
  }

  public char getSym() {
    return sym;
  }

  public short getSurfaceId() {
    return surfaceId;
  }
}
