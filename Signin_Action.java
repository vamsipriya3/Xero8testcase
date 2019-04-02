package appModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.XeroReuse;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Signin_Action  {
	static ExtentReports extent;
	 static ExtentTest logger;
	 WebDriver driver;
	public static void Execute(WebDriver driver) throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();

		driver.get("https://login.xero.com/");
		WebDriverWait wait=new WebDriverWait(driver,40);

		System.out.println("Application Launched Successfully");
		Thread.sleep(2000);

		WebElement EmailAddress=driver.findElement(By.id("email"));
		EmailAddress.sendKeys("vamsi30394@gmail.com");
		System.out.println("Email Address field got entered successfully");
	
		WebElement Password=driver.findElement(By.id("password"));
		Password.sendKeys("Va3ms3i94");
		System.out.println("password field got entered successfully");
		
		WebElement Login=driver.findElement(By.id("submitButton"));
		Login.click();
		System.out.println("Login button got clicked successfully");
		
	}

}

