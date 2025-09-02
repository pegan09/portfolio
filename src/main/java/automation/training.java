package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class training {
	public static void main(String[] args) {
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(Options);
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.findElement(By.id("my-text-id")).sendKeys("pegan");
		driver.findElement(By.name("my-password")).sendKeys("redcyrus");
		driver.findElement(By.name("my-textarea")).sendKeys("welcome");
		driver.findElement(By.name("my-select")).click();
		driver.findElement(By.xpath("//select/option[2]")).click();
		driver.findElement(By.name("my-datalist")).sendKeys("New York");
		driver.findElement(By.name("my-radio")).click();
		driver.findElement(By.name("my-check")).click();
		String year="August 2027";
		String date="23";
		driver.findElement(By.name("my-date")).click();
		while(true) {
			String currentyear=driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
		    if(currentyear.equals(year)) {
		       break;
		       }
		    	driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[3]")).click();
		    	
		    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> alldates=driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody"));
		                                                       
		for(WebElement sdate:alldates) {
			if(sdate.getText().equals(date)) {
				sdate.click();
				break;
			}
			
		}
		}
	}


