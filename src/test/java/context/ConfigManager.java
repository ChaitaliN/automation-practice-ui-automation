package context;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileNotFoundException;

public class ConfigManager {
    private Properties prop;

    public Properties load(String propFileName) throws Exception {
        prop = new Properties();
        InputStream inputStream;

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
