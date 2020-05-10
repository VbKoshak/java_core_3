package edu.solvd.mentoring.exceptions;

public abstract class IncorrectInputException extends Throwable {
  protected String msg;

  public IncorrectInputException(String msg){
    this.msg = msg;
  }

  public abstract String getMessage();
}
