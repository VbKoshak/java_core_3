package edu.solvd.mentoring.exceptions.inputErrors;

public abstract class IncorrectInputException extends Throwable {
  protected String msg;

  public IncorrectInputException(String msg){
    this.msg = msg;
  }

  public abstract String getMessage();
}
