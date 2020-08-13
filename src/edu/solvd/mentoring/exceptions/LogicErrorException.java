package edu.solvd.mentoring.exceptions;

public class LogicErrorException extends IncorrectInputException{
  public LogicErrorException(String msg){
    super(msg);
  }

  @Override
  public String getMessage(){
    return "" + msg + " caused logic error";
  }
}
