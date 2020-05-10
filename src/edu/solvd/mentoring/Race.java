package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

import java.util.Arrays;

/**
 * class to represent the actual race in the game
 * route - route to take race in
 * Participants - all participants of the race including player
 * positions - helps to define the winner of the race,
 *    so, when value == 0 participant still in the race
 *        else shows how much movemment points left after the final tick for each participant who finished the race
 *        winner is the one who has the most
 */
public class Race {
  private Route route;
  private Participant[] participants;
  private double[] positions;
  private int prize;

  /**
   * basic cnstructor for a race
   * @param route - route of the race
   * @param enemies - array of enemy Cars
   * @param prize - prizepool of the race
   * @param playerCar - Player's car
   */
  public Race(Route route, Car[] enemies, int prize, Car playerCar){
    this.route = route;
    this.participants = new Participant[enemies.length + 1];
    for (int i = 0; i < enemies.length; i++){
      this.participants[i] = new Participant(enemies[i],this.route,(char)i);
    }
    this.participants[enemies.length] = new Participant(playerCar,this.route,'P'); // player always late)
    this.prize = prize;
    this.positions = new double[enemies.length + 1];
  }

  public Route getRoute() {
    return route;
  }

  public int getPrize() {
    return prize;
  }

  /**
   * tick is the representation of time in th game
   * each tick every participant make a move
   * if someone finished the race, return false, else returns true
   * @return
   */
  public boolean makeTick(){
    boolean haveWinner = false;
    for (int i = 0; i < participants.length; i++){
      double status = participants[i].makeTick(0);
      if (status != -1){ //if someone finished the race
        haveWinner = true;
        positions[i] = status;
      }
    }
    return haveWinner;
  }

  /**
   * printing some ui to show how long each participant move in current race
   */
  private void showParticipantsProgress(){
    double totalDistance = this.route.getTotalDistance();
    System.out.println("------");
    for (int i = 0; i < participants.length; i++){
      System.out.println(participants[i].getSym() + ": " + Double.toString(participants[i].getKmGone()) + "/" + totalDistance);
    }
    System.out.println("------");
  }

  /**
   * function that returnes index of the winner of the race in participants list
   *
   * @return index of the winner if there is one
   *         if no winner yet: -1
   */
  private int getWinnerIndex(){
    int winnerIndex = 0;
    for (int i = 1; i < positions.length; i++) {
      if (positions[i] > positions[winnerIndex]){
        winnerIndex = i;
      }
    }
    return positions[winnerIndex] > 0 ? winnerIndex : -1;
  }

  //return true  if player wins else returns false

  /**
   * plays the race, showing participants progress each tick
   * when the winner defined returnes value
   * @return true if the winner is player
   *         false if the winner is someone else
   */
  public boolean start(){
    while(makeTick() == false){
      showParticipantsProgress();
    }
    int index = getWinnerIndex();
    if (index == this.participants.length -1){
      return true; //player  wins
    } else {
      return false;
    }
  }
}
