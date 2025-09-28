import java.io.InputStream;
import java.util.Properties;

public class SetProperties {
    public static void main(String[] args) {
        String configName = "app.properties";
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(configName)) {

            if(inputStream == null) {
                System.out.println("Sorry, unable to find " + configName);
                return;
            }
            Properties appProps = new Properties();
            appProps.load(inputStream);

            appProps.setProperty("name", "UpdatedAppName");
            appProps.setProperty("downloadAddr", "http://example.com/download");

            System.out.println("Application Name: " + appProps.getProperty("name"));
            System.out.println("Application Download Address: " + appProps.getProperty("downloadAddr"));


        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
