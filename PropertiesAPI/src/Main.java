import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        String catalogConfigPath = rootPath + "catalog";

        try {
            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));

            Properties catalogProps = new Properties();
            catalogProps.load(new FileInputStream(catalogConfigPath));

            String appVersion = appProps.getProperty("version");
            String catalog  = catalogProps.getProperty("c1");
            System.out.println("Application Version: " + appVersion);
            System.out.println("Catalog: " + catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}