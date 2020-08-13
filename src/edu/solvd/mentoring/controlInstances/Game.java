package edu.solvd.mentoring.controlInstances;

import edu.solvd.mentoring.Support;
import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

/**
 * main game object
 * player - the main player of the game
 * currentRace - race player currently take part in
 */
public class Game {
  private Player player;
  private Race currentRace = null;

  /**
   * creates a player ccording to param nickname, initialize basic garage instance
   * @param playerName - nickname of the player
   */
  public Game(String playerName){
    Support.initGarage();
    this.player = new Player(Support.getCar(1),playerName);
  }


  /**
   * starts a random race from a presets
   * generate some enemies
   * plays the race
   *    show the result of the race
   *    if player wins
   *        add winning prize to cash
   *    else
   *        gives some money to cheer up
   */
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
      this.player.winMoney(5);
    }
  }
}
