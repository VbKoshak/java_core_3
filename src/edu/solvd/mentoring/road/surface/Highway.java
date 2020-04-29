package edu.solvd.mentoring.road.surface;

import edu.solvd.mentoring.road.Surface;

public class Highway extends Surface {
  public Highway(String name, short influence, char sym, short surfaceid) {
    super("highway",(short)100,'=',(short)3);
  }
}