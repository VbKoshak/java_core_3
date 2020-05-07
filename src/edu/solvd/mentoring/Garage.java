package edu.solvd.mentoring;

import edu.solvd.mentoring.car.detail.CarDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * Garage instance that contains details in stock that can be bough(in future)
 * stock - a list of details appropriate for sale + price for details
 */
public class Garage {
  private static Map<CarDetail, Integer> stock = new HashMap<>();

  public static Map<CarDetail, Integer> getStock() {
    return stock;
  }


  /**
   * place given detail with a current price to a stock
   * @param detail
   * @param price
   */
  public static void addCarDetail(CarDetail detail, Integer price){
    stock.put(detail,price);
  }

  /**
   * removes detail from stock
   * @param detail - detail to be removed (bought)
   */
  public static void buyCarDetail(CarDetail detail){
    stock.remove(detail);
  }


  /**
   *
   * @param detail - detail which price want to be known
   * @return price of the given detail
   */
  public static Integer getPrice(CarDetail detail){
    return stock.get(detail);
  }


  /**
   * gives a visual interpretation of details in stock
   */
  public static void showStock(){
    //to be implemented
  }
}
