package edu.solvd.mentoring.exceptions.inputErrors;

import edu.solvd.mentoring.enums.ErrReason;

public class IncorrectInputExceptionHandler extends RuntimeException{
  private ErrReason reason;
  public IncorrectInputExceptionHandler(ErrReason reason, String errCause){
    super(errCause);
    this.reason = reason;
  }

  public IncorrectInputException getError(){
    IncorrectInputException excError;
    switch(reason){
      case LogicError:
        excError = new LogicErrorException(this.getMessage());
        break;
      case EmptyArray:
        excError = new EmptyArrayException(this.getMessage());
        break;
      case InappropriateNum:
        excError = new InappropriateNumException(this.getMessage());
        break;
      default:
        excError = new UnknownInputException(this.getMessage());
        break;
    }
    return excError;
  }
}
