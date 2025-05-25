package components;


import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {


    static Properties prop = new Properties();

    public static String getPropertyValueByKey(String fileName, String key) throws Exception {
        String propFilePath = System.getProperty("user.dir")  + "/src/main/resources/" + fileName + ".properties";
        String value = null;
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);
            value = prop.get(key).toString();
            if(StringUtils.isEmpty(value)) {
                throw new Exception("Value is not specified for key: "+key + " in properties file."); // replace with robust logging
            }
        } catch (Exception e) {
            e.printStackTrace(); // replace with robust logging
        }
        return value;
    }

}