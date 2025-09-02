package automation;
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver getDriver() {
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("start-maximized");
		//return new ChromeDriver(options);
		//launching ChromeBrowser
				WebDriver driver=new ChromeDriver();
				
				//maximizing the ChromeBrowser window
				driver.manage().window().maximize();
				
				//implicit wait is implemented to locate the element in the DOM
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				return driver;
	}
}
 