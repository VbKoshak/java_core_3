package edu.solvd.mentoring;

import edu.solvd.mentoring.car.detail.CarDetail;

import java.util.HashMap;
import java.util.Map;

public class Garage {
  private static Map<CarDetail, Integer> stock = new HashMap<>();

  public static Map<CarDetail, Integer> getStock() {
    return stock;
  }

  public static void addCarDetail(CarDetail detail, Integer price){
    stock.put(detail,price);
  }

  public static void buyCarDetail(CarDetail detail){
    stock.remove(detail);
  }

  public static Integer getPrice(CarDetail detail){
    return stock.get(detail);
  }

  public static void showStock(){
    //to be implemented
  }
}
