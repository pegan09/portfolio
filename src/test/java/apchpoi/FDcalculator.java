package apchpoi;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDcalculator {
	public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	driver.manage().window().maximize();
    
	String filepath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
	int rows =Excelutility.getRowCount(filepath,"Sheet1");
	
	for(int i=1;i<=rows;i++) {
		//read data from excel
		String pric=Excelutility.getCellData(filepath,"Sheet1", i, 0);
		String rateofintres=Excelutility.getCellData(filepath,"Sheet1", i, 1);
		String period1=Excelutility.getCellData(filepath,"Sheet1", i, 2);
		String period2=Excelutility.getCellData(filepath,"Sheet1", i, 3);
		String fre=Excelutility.getCellData(filepath,"Sheet1", i, 4);
		String exp_mvalue=Excelutility.getCellData(filepath,"Sheet1", i, 5);
		//pass above data into application
		driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
		driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofintres);
		driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
		
		Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
		perdrp.selectByVisibleText(period2);
		
		
		Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		fredrp.selectByVisibleText(fre);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("wzrk-cancel")).click();
		}
		catch(Exception e)        {
			System.out.println("not found");
		}
		driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); //clicked on calculate
		//validation
		String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
		
		if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
		{
			System.out.println("Test Passed");
			Excelutility.setCellData(filepath, "Sheet1", i,7, "Passed");
			Excelutility.fillGreenColor(filepath, "Sheet1",  i,7);
		}else {
			System.out.println("Test failed");
			Excelutility.setCellData(filepath, "Sheet1", i,7, "Failed");
			Excelutility.fillRedColor(filepath, "Sheet1",  i,7);
			
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clicked on clear button
		
		
	}driver.quit();
	
}
}