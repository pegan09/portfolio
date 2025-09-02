package automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class alert {
	public static void main(String[] args) {
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(Options);
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		driver.findElement(By.id("prompt")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("alert"+alert.getText());
		alert.sendKeys("pegan");
		alert.accept();
		
	}

}
