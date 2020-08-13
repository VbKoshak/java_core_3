package edu.solvd.mentoring.fileWork.loader;

import edu.solvd.mentoring.exceptions.fileWorkErrors.UnableToReadException;
import edu.solvd.mentoring.fileWork.Reader.PropertyFileReader;

import java.io.File;
import java.util.Properties;

public class PropsLoader {
  private File file;
  private Properties props;


  public PropsLoader(File file) {
    this.file = file;
  }

  public PropsLoader(String filePath) {
    this.file = new File(filePath);
  }

  private void scan(){
    try {
      PropertyFileReader pfr = new PropertyFileReader(this.file);
      pfr.read();
      this.props = pfr.getProps();
    } catch(UnableToReadException ex) {
      System.out.println(ex.getMessage());
      System.exit(2);
    } catch (Exception exc){
      System.out.println(exc.getMessage());
      exc.printStackTrace();
      System.exit(-1);
    }
  }

  public String getPropertyValue(String key) {
    if (this.props == null){
      this.scan();
    }

    return this.props.getProperty(key);
  }
}
