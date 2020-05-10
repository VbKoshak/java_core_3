package edu.solvd.mentoring.exceptions;

public class InappropriateNumException extends IncorrectInputException{
  public InappropriateNumException(String msg){
    super(msg);
  }

  @Override
  public String getMessage(){
    return "" + msg + " got not suitable value";
  }
}
