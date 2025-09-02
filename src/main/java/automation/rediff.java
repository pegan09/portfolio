package automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
 
public class rediff {
	
	
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	public static List<WebElement> list;
	public rediff()throws IOException {
		fis=new FileInputStream("./src/main/resources/config.properties");
		prop=new Properties();
		prop.load(fis);
	}
	
	public void formFill() {
		driver.manage().window().maximize();//Maximizing browser window
		//Clicking "Create a new account"
		WebElement element=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/p/a"));
		element.click();
		//Sending name to its web element
		driver.findElement(By.cssSelector("[placeholder='Enter your full name']")).sendKeys(prop.getProperty("name"));
		//Sending Rediffmail id to its web element
		driver.findElement(By.cssSelector("[placeholder='Enter Rediffmail ID']")).sendKeys(prop.getProperty("mail"));
		//Checking availability of mail Id and then selecting a random generated mail Id
		driver.findElement(By.cssSelector("[value='Check availability']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("radio_login")).click();
		//Sending password to its web element
		driver.findElement(By.id("newpasswd")).sendKeys(prop.getProperty("pass"));
		//Sending Re-enter password to its web element
		driver.findElement(By.id("newpasswd1")).sendKeys(prop.getProperty("repass"));
		//Clicking "Click if you don't have an alternate ID" checkbox
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.className("nomargin")).click();
		//Entering DOB
		driver.findElement(By.className("day")).sendKeys(prop.getProperty("date"));
		driver.findElement(By.xpath("//select[@class='middle month']")).sendKeys(prop.getProperty("month"));
		driver.findElement(By.className("year")).sendKeys(prop.getProperty("year"));
	}
	public void printDropdownList() {
		WebElement element=driver.findElement(By.id("country"));
		element.click();
		Select select=new Select(element);
		list=select.getOptions();
		System.out.println("Printing all available countries in dropdown menu");
		for(WebElement option:list) {
			
			System.out.println(option.getText());//printing all country names
		}
	}
	public void printNoOfCountries(){
		System.out.println("Number of countries in the list are: ");
		System.out.println(list.size());
	}
	
	public void countrySelect() {
		Select select=new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText(prop.getProperty("country"));
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[16]/div[1]/label")).click();
		WebElement element=select.getFirstSelectedOption();
		System.out.println("The selected option is ");
		System.out.println(element.getText());
	}
	
	public void validate() {
		Select select=new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText(prop.getProperty("country"));
		WebElement element=select.getFirstSelectedOption();
		if(element.getText().equals(prop.getProperty("validate"))) {
			System.out.println("India is selected");
		}
		else {
			System.out.println("Wrong country selected");
		}
	}
	                                                                                                                                                                                                                                                                                                                                                                                                   
	
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		driverSetups obj=new driverSetups();
		rediff obj1=new rediff();
		driver=obj.getDriver();
		obj1.formFill();
		obj1.printDropdownList();
		obj1.printNoOfCountries();
		obj1.countrySelect();
		obj1.validate();
	}
 
}
 
 
 
 