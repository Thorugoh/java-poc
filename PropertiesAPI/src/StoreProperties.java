import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

public class StoreProperties {
    public static void main(String[] args) {
        String configName = "app.properties";

        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configName)) {
            if(inputStream == null) {
                System.out.println("Sorry, unable to find " + configName);
                return;
            }

            Properties appProps = new Properties();
            appProps.load(inputStream);
            appProps.setProperty("app.version", "1.0.1");

            try(FileWriter writer = new FileWriter(configName)){
                appProps.store(writer, "Updated Application Properties");
            }

            System.out.println("Properties stored successfully in updated-app.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
