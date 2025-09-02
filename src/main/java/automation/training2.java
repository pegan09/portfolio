package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class training2 {
	public static void main(String[] args) throws InterruptedException {
			ChromeDriver driver=new ChromeDriver();
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("--start-maximized");
			driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
			driver.findElement(By.cssSelector("[placeholder='Clickable']")).click();
			WebElement source=driver.findElement(By.id("draggable"));
			WebElement target=driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
	        actions.dragAndDrop(source,target).build().perform();
	        WebElement hover=driver.findElement(By.id("hover"));
	        actions.moveToElement(hover).perform();
	        Thread.sleep(5000);
	        WebElement move=driver.findElement(By.id("mouse-tracker"));
	        actions.moveToElement(move);
	}

}
