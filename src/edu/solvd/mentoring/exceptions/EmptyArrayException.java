package edu.solvd.mentoring.exceptions;

public class EmptyArrayException extends IncorrectInputException {
  public EmptyArrayException(String msg){
    super(msg);
  }

  @Override
  public String getMessage(){
    return "" + msg + " array should not be empty";
  }
}
