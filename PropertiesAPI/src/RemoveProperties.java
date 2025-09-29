import java.io.InputStream;
import java.util.Properties;

public class RemoveProperties {
    public static void main(String[] args) {
        String configName = "app.properties";

        try(InputStream inputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(configName)) {

            if(inputStream == null) {
                System.out.println("Sorry, unable to find " + configName);
                return;
            }

            Properties appProps = new Properties();
            appProps.load(inputStream);

            System.out.println("Before removal: " + appProps.getProperty("version"));

            appProps.remove("version");
            System.out.println("After removal: " + appProps.getProperty("version"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
