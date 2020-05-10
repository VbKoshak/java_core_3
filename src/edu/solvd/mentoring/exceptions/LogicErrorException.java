package edu.solvd.mentoring.exceptions;

public class LogicErrorException extends Throwable{
  private String msg;

  public LogicErrorException(String msg){
    this.msg = msg;
  }

  @Override
  public String getMessage(){
    return "" + msg + " caused logic error";
  }
}
