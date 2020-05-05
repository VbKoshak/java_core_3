package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

public class Game {
  private Garage garage;
  private Player player;
  private Race currentRace = null;

  public Game(String playerName){
    this.garage = Support.getGarage();
    this.player = new Player(Support.getCar(1),playerName);
  }

  public void startRace(){
    Route rt = Support.getRoute((int)(Math.round(Math.random()*2+1)));
    Car[] enemies = {Support.getCar(2),Support.getCar(4)};
    this.currentRace = new Race(rt,enemies,100,this.player.getCar());
    this.currentRace.getRoute().showRoute();
    boolean winner = this.currentRace.start();
    if(winner == true){
      System.out.println("You win!!!");
      this.player.winMoney(this.currentRace.getPrize());
    } else {
      System.out.println("You lose");
      this.player.winMoney(5); // just to mood player up
    }
  }
}
