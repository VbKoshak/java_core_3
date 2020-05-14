package edu.solvd.mentoring.fileWork.Reader;

import edu.solvd.mentoring.exceptions.fileWork.UnableToCloseExcepton;
import edu.solvd.mentoring.exceptions.fileWork.UnableToReadException;

public interface Reader {
  String read() throws UnableToReadException, UnableToCloseExcepton;
}
