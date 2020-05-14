package edu.solvd.mentoring.fileWork.loader;

import edu.solvd.mentoring.enums.ErrReason;
import edu.solvd.mentoring.exceptions.inputErrors.IncorrectInputException;
import edu.solvd.mentoring.exceptions.inputErrors.IncorrectInputExceptionHandler;
import edu.solvd.mentoring.exceptions.fileWorkErrors.UnableToReadException;
import edu.solvd.mentoring.fileWork.Reader.TextFileReader;
import edu.solvd.mentoring.road.Point;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PointLoader {
  private File file;
  private List<Point> points;

  public PointLoader (String path) {
    this.file = new File(path);
  }

  public PointLoader (File file) {
    this.file = file;
  }

  private void processString(String s) {
    this.points = new ArrayList<Point>();
    try {
      if (s.split("\n").length == 0){
        throw new IncorrectInputExceptionHandler(ErrReason.EmptyArray,"Point loading file").getError();
      }
      s = s.replaceAll("\r",""); // just in case

      for (String str : s.split("\n")) {
        String[] ords = str.split(" ");
        if (ords.length != 2){
          throw new IncorrectInputExceptionHandler(ErrReason.InappropriateNum ,"Points ").getError();
        }
        points.add(new Point(Integer.parseInt(ords[0]),Integer.parseInt(ords[1])));
      }

    } catch (IncorrectInputException exc) {
      System.out.println(exc.getMessage());
      System.exit(3);
    } catch (Exception exc) {
      System.out.println(exc.getMessage());
      exc.printStackTrace();
      System.exit(-1);
    }

  }

  private String getText(File file) {
    String res = new String();
    try {
      res =  new TextFileReader(file).read();
    } catch (UnableToReadException e) {
      System.exit(1);
    }
    return res;
  }

  public List<Point> getPoints() {
    if (this.points == null) {
      processString(getText(this.file));
    }
    return this.points;
  }
}
