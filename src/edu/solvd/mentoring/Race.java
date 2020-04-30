package edu.solvd.mentoring;

import edu.solvd.mentoring.car.Car;
import edu.solvd.mentoring.road.Route;

import java.util.Arrays;

public class Race {
  private Route route;
  private Participant[] participants;
  private double[] positions;
  private int prize;

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

  private void showParticipantsProgress(){
    double totalDistance = this.route.getTotalDistance();
    System.out.println("------");
    for (int i = 0; i < participants.length; i++){
      System.out.println(participants[i].getSym() + ": " + Double.toString(participants[i].getKmGone()) + "/" + totalDistance);
    }
    System.out.println("------");
  }

  private int getWinnerIndex(){
    int winnerIndex = 0;
    for (int i = 0; i < positions.length; i++) {
      if (positions[i] > positions[winnerIndex]){
        winnerIndex = i;
      }
    }
    return positions[winnerIndex] > 0 ? winnerIndex : -1; //index of winner or -1 if mistake appeared and no winner
  }

  //return true  if player wins else returns false
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
