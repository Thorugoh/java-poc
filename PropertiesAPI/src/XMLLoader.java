import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XMLLoader {
    public static void main(String[] args) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String iconsConfigPath = rootPath + "icons.xml";

        try{
            Properties iconProps = new Properties();
            iconProps.loadFromXML(new FileInputStream(iconsConfigPath));
            String image = iconProps.getProperty("imageIcon");

            System.out.println("Image Icon: " + image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
