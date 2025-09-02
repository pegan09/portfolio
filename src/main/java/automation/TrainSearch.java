package automation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TrainSearch {

	public static void main(String[] args) {

       LocalDate today = LocalDate.now();
       LocalDate futureDate = today.plusDays(4);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
       String formattedDate = futureDate.format(formatter);
       System.out.println(formattedDate);
       System.setProperty("webdriver.edge.driver","C:\\Users\\2425555\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("start-maximized");
//		WebDriver driver = new EdgeDriver(options);
       ChromeOptions options = new ChromeOptions();
       WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in ");
		driver.getTitle();
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().window().maximize();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='OK']"))));
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		driver.findElement(By.xpath("//p-autocomplete[@id='origin']/span/input")).sendKeys("Hyd");
		//driver.findElement(By.xpath("//p-dialog[1]/div/div/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"pr_id_1_list\"]/li[2]")).click();
		driver.findElement(By.xpath("//p-autocomplete[@id='destination']/span/input")).sendKeys("Pune");
		driver.findElement(By.xpath("//ul[@id=\"pr_id_2_list\"]/li[1]")).click();
		//String xpath="//table/tbody/tr/td/a[text()='"+formattedDate+"')"]
		driver.findElement(By.xpath("//p-calendar/span/input")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+formattedDate+"')]")).click();
		/*driver.findElement(By.xpath("//p-calendar/span/input")).clear();
		driver.findElement(By.xpath("//p-calendar/span/input")).sendKeys(formattedDate);*/
		driver.findElement(By.xpath("//label[@class='css-label_c t_c']")).click();
		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-check']")).click();
		driver.findElement(By.id("journeyClass")).click();
		driver.findElement(By.xpath("//li[@aria-label='Sleeper (SL)']")).click();
	}
}
