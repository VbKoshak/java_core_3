package edu.solvd.mentoring.controlInstances;

import edu.solvd.mentoring.Settings;
import edu.solvd.mentoring.car.Car;

/**
 * defines main chracter of the game (player)
 */
public class Player {
  private Car car;
  private String nickName;
  /** player's in-game balance*/
  private int money = Settings.DEFAULT_MONEY;

  public Player(){
    this.car = null;
    this.nickName = "guest";
  }

  /**
   *
   * @param car gives a certain car to a player
   * @param nickName nickname of the player
   */
  public Player(Car car, String nickName) {
    this.car = car;
    this.nickName = nickName;
  }

  public Car getCar() {
    return car;
  }

  public String getNickName() {
    return nickName;
  }

  public int getMoney() {
    return money;
  }

  /**
   * function to spend player's money
   * @param value suggest amount to spend
   * @return true if transaction successfull
   *         false if wrong amount of money tto spend requested
   */
  public boolean spendMoney(int value){
    if (value < this.money && value > 0){
      this.money -= value;
      return true;
    } else {
      return false;
    }
  }

  /**
   * gives some money to player
   * @param value suggested amount to win
   * @return true if transaction succesfull
   *         false if input value is not appropriate
   */
  public boolean winMoney(int value){
    if (value > 0 && (this.money + value > this.money)){
      this.money += value;
      return true;
    } else {
      return false;
    }
  }
}
