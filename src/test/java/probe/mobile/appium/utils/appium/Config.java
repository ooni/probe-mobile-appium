package probe.mobile.appium.utils.appium;

import java.io.InputStream;
import java.util.Map;

public final class Config {

    private static Config config;

    private YamlPropertyProvider.YamlEncoded yamlEncoded;

    private Config() {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("configuration.yaml");

        YamlPropertyProvider yamlPropertyProvider = new YamlPropertyProvider();
        yamlEncoded = yamlPropertyProvider.getProperties(inputStream);
    }

    public static synchronized Config instance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public String getProperty(String key) {
        return yamlEncoded.properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return yamlEncoded.properties.getProperty(key, defaultValue);
    }

    public Object getYamlProperty(String path) {
        String[] keys = path.split("\\.");
        Map<String, Object> map = yamlEncoded.yamlAsMap;
        Object value = null;

        for (String key : keys) {
            if (map == null) {
                return null;
            }
            value = map.get(key);
            map = value instanceof Map ? (Map<String, Object>) value : null;
        }
        return value;
    }

}