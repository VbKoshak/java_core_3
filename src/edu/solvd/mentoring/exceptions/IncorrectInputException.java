package edu.solvd.mentoring.exceptions;

import edu.solvd.mentoring.enums.ErrReason;

public class IncorrectInputException extends RuntimeException{
  private ErrReason reason;
  public IncorrectInputException(ErrReason reason, String msg){
    super(msg);
    this.reason = reason;
  }

  public String showMessage(){
    switch(reason){
      case LogicError:
        return (new LogicErrorException(this.getMessage())).getMessage();
      case EmptyArray:
        return (new EmptyArrayException(this.getMessage())).getMessage();
      case InappropriateNum:
        return (new InappropriateNumException(this.getMessage())).getMessage();
      default:
        return ("Unknown error with: " + this.getMessage());
    }
  }
}
