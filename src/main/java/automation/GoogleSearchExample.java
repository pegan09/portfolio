package automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class GoogleSearchExample {
	static WebDriver driver;
	static Properties prop=new Properties();
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		prop.load(fis);
		driverSetups setUp=new driverSetups();
		driver=setUp.setup(prop.getProperty("browser"));
		driver.get("https://www.google.com");
	}

}
