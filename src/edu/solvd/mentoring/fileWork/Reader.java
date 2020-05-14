package edu.solvd.mentoring.fileWork;

import edu.solvd.mentoring.exceptions.UnableToCloseExcepton;
import edu.solvd.mentoring.exceptions.UnableToReadException;

public interface Reader {
  String read() throws UnableToReadException, UnableToCloseExcepton;
}
