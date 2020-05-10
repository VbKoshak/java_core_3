package edu.solvd.mentoring.exceptions;

public class EmptyArrayException extends Throwable {
  private String msg;
  public EmptyArrayException(String msg){
    this.msg = msg;
  }

  @Override
  public String getMessage(){
    return "" + msg + " array should not be empty";
  }
}
