package edu.solvd.mentoring.exceptions;

public class InappropriateNumException extends RuntimeException{
  private String msg;

  public InappropriateNumException(String msg){
    this.msg = msg;
  }

  @Override
  public String getMessage(){
    return "" + msg + " got not suitable value";
  }
}
