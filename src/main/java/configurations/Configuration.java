package configurations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Configuration {
    private static Config config;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream == null) {
                throw new RuntimeException("config.json not found in classpath");
            }
            config = mapper.readValue(inputStream, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String getBaseUrl() {
        return config.getBaseUrl();
    }

    public static String getEndpoint(String key) {
        return config.getEndpoints().get(key);
    }

    public static class Config {
        private String baseUrl;
        private Map<String, String> endpoints;

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public Map<String, String> getEndpoints() {
            return endpoints;
        }

        public void setEndpoints(Map<String, String> endpoints) {
            this.endpoints = endpoints;
        }
    }
}
