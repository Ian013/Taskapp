package application.data;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.log4j.Logger;

public class PropertiesReader {

    private Configuration config;

    private static Logger log = Logger.getLogger(PropertiesReader.class);

    public PropertiesReader(String path) {

        Parameters params = new Parameters();
        var builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.properties()
                        .setFileName(path));
        try {
            config = builder.getConfiguration();
        } catch (ConfigurationException ex) {
            log.error(ex.getMessage());
        }
    }

    /**
     * @param key of property
     * @return int value of property with given key
     */
    public int readIntProperty(String key){
        return config.getInt(key);
    }
    /**
     * @param key of property
     * @return string value of property with given key
     */
    public String readStringProperty(String key){
        return config.getString(key);
    }
}
