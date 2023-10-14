package SeleniumTest.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

public String getPropertyValue(String key) throws IOException {
    Properties prop=new Properties();

    FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/GloabalData.properties");
    prop.load(fis);
    String value =prop.getProperty(key);
    return value;
}
}
