import java.io.FileInputStream;
import java.util.Properties;

public class StoreToXML {
    public static void main(String[] args) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String outputXMLPath = rootPath + "output.xml";

        try {
            Properties props = new Properties();
            props.load(new FileInputStream(rootPath + "app.properties"));

            props.setProperty("username", "admin");
            props.setProperty("password", "secret");
            props.setProperty("url", "http://example.com");

            props.storeToXML(new java.io.FileOutputStream(outputXMLPath), "User Credentials");

            System.out.println("Properties saved to XML file at: " + outputXMLPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
