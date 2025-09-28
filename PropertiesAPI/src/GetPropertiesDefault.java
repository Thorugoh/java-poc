import java.io.FileInputStream;
import java.util.Properties;

public class GetPropertiesDefault {
    public static void main(String[] args) {
        try{
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        String appVersion = appProps.getProperty("version");
        String appName = appProps.getProperty("name", "defaultAppName");
        String appGroup = appProps.getProperty("group", "defaultAppGroup");
        String appDownloadAddr = appProps.getProperty("downloadAddr");


        System.out.println("Application Version: " + appVersion);
        System.out.println("Application Name: " + appName);
        System.out.println("Application Group: " + appGroup);
        System.out.println("Application Download Address: " + appDownloadAddr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
