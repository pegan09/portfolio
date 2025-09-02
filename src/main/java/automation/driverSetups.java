package automation;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class driverSetups {
	public static WebDriver driver;
	public static String browser;
	public static Properties prop=new Properties();

	public  WebDriver getDriver() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		prop.load(fis);
		browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
			driver.get(prop.getProperty("baseUrl"));
			
			
			
		}
		else if (browser.equals("edge")){
			System.setProperty("webDriver.edge.driver","C:\\Users\\2425544\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get(prop.getProperty("baseUrl"));
			
		}
		return driver;
		
	}

	
 
}
 