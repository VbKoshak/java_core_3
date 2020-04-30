package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;

public class Player {
  private Car car;
  private String nickName;
  private int money = 100;

  public Player(){
    this.car = null;
    this.nickName = "guest";
  }

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

  public boolean spendMoney(int value){
    if (value < this.money && value > 0){
      this.money -= value;
      return true;
    } else {
      return false;
    }
  }

  public boolean winMoney(int value){
    if (value > 0 && (this.money + value > this.money)){
      this.money += value;
      return true;
    } else {
      return false;
    }
  }
}
