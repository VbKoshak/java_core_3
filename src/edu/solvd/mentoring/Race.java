package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

import java.util.Arrays;

public class Race {
  private Route route;
  private Car[] enemies;
  private int tick = 0;
  private int[] positions;
  private int prize;

  public Race(Route route, Car[] enemies, int prize){
    this.route = route;
    this.enemies = Arrays.copyOf(enemies, enemies.length);
    this.prize = prize;
    this.positions = new int[enemies.length + 1];
  }

  public Route getRoute() {
    return route;
  }

  public Car[] getEnemies() {
    return enemies;
  }

  public int[] getPositions() {
    return positions;
  }

  public int getPrize() {
    return prize;
  }
}
