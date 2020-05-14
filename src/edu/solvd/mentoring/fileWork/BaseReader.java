package edu.solvd.mentoring.fileWork;

import java.io.File;

public abstract class BaseReader {
  protected File file;
  protected String absolutePath;

  public BaseReader(File file) {
    this.file = file;
    this.absolutePath = file.getAbsolutePath();
  }

  public BaseReader(String path) {
    file = new File(path);
    this.absolutePath = file.getAbsolutePath();
  }

  public String getPath() {
    return absolutePath;
  }
}