package edu.solvd.mentoring.exceptions.inputErrors;

public class UnknownInputException extends IncorrectInputException {
  public UnknownInputException(String msg){
    super(msg);
  }

  @Override
  public String getMessage(){
    return "Unknown error happened with " + msg;
  }
}
