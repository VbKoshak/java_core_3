package edu.solvd.mentoring.fileWork.Reader;

import edu.solvd.mentoring.exceptions.fileWorkErrors.UnableToCloseExcepton;
import edu.solvd.mentoring.exceptions.fileWorkErrors.UnableToReadException;

public interface Reader {
  String read() throws UnableToReadException, UnableToCloseExcepton;
}
