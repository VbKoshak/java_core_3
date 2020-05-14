package edu.solvd.mentoring.fileWork.Reader;

import edu.solvd.mentoring.exceptions.fileWork.UnableToReadException;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader extends BaseReader implements Reader {
  private Properties props;

  public PropertyFileReader(File file) {
    super(file);
  }

  public PropertyFileReader(String path) {
    super(path);
  }

  @Override
  public String read() throws UnableToReadException {
    this.props = new Properties();
    try {
      if (!this.absolutePath.contains(".properties")) {
        throw new RuntimeException("Provide the file in proper format");
      }
      InputStream inputStream = new FileInputStream(new File(this.absolutePath).getAbsolutePath());
      this.props.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
      throw new UnableToReadException("");
    }
    return "OK"; // :)
  }

  public String getPropertyValue(String key) {
    return this.props.getProperty(key);
  }
}
