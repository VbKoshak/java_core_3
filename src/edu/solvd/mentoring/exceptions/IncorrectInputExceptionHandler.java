package edu.solvd.mentoring.exceptions;

import edu.solvd.mentoring.enums.ErrReason;

public class IncorrectInputExceptionHandler extends RuntimeException{
  private ErrReason reason;
  public IncorrectInputExceptionHandler(ErrReason reason, String msg){
    super(msg);
    this.reason = reason;
  }

  public String showMessage(){
    String excError;
    switch(reason){
      case LogicError:
        excError = (new LogicErrorException(this.getMessage())).getMessage();
        break;
      case EmptyArray:
        excError = (new EmptyArrayException(this.getMessage())).getMessage();
        break;
      case InappropriateNum:
        excError = (new InappropriateNumException(this.getMessage())).getMessage();
        break;
      default:
        excError = ("Unknown error with: " + this.getMessage());
        break;
    }
    return excError;
  }
}
