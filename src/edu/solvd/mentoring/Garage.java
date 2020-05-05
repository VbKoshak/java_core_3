package edu.solvd.mentoring;

import edu.solvd.mentoring.car.detail.CarDetail;

import java.util.HashMap;

public class Garage {
  private HashMap<CarDetail, Integer> stock = new HashMap<>();

  public HashMap<CarDetail, Integer> getStock() {
    return stock;
  }

  public void addCarDetail(CarDetail detail, Integer price){
    stock.put(detail,price);
  }

  public void buyCarDetail(CarDetail detail){
    stock.remove(detail);
  }

  public Integer getPrice(CarDetail detail){
    return stock.get(detail);
  }

  public void showStock(){
    //to be implemented
  }
}
