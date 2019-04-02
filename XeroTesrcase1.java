package com.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import appModule.Signin_Action;

public class XeroTesrcase1 extends XeroReuse {
	private static WebDriver driver = null;
	 ExtentReports extent;
	 static ExtentTest logger;
	// WebDriver driver;

	

	public static void main(String[] args) throws InterruptedException {
		String path="C:\\Users\\vamsi\\Documents\\QaReport\\Xero Tetcases.html";
		ExtentReports report = new ExtentReports(path);
		logger=report.startTest("Login to Xero");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.log(LogStatus.INFO,"Chrome browser launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.get("https://login.xero.com/");
		Signin_Action.Execute( driver);
		System.out.println("Login successfull");
		driver.quit();

		Thread.sleep(3000);
		/*testcase1 B
		 * Incorrect password*/
		
		System.out.println("Testcase 1B");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.xero.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement EmailAddressTab=driver.findElement(By.id("email"));
		enterText(EmailAddressTab,"vamsi30394@gmail.com","Email address");
		logger.log(LogStatus.PASS,"Email got entered");
		WebElement PasswordTab=driver.findElement(By.id("password"));
		enterText(PasswordTab,"vamsipriya","Password");
		logger.log(LogStatus.PASS,"password got entered incorrectly");
		WebElement LoginButton=driver.findElement(By.id("submitButton"));
		clickObject(LoginButton,"Login");
		logger.log(LogStatus.PASS,"Login button got clicked");
		WebElement ErrorMsg=driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		System.out.println("ERROR:entered password is incorrect");
		logger.log(LogStatus.PASS,"Error message incorrect password");
		logger.log(LogStatus.INFO,"Testcase1 B got passed");
		report.endTest(logger);
		report.flush();

		System.out.println("End");
		driver.quit();
		
		/*Testcae1 C
		 * Incorrect Email*/
		System.out.println("Testcase 1C");
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.xero.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement EmailAddress=driver.findElement(By.id("email"));
		enterText(EmailAddress,"vamsi@gmail.com","Email address");
		logger.log(LogStatus.PASS,"Email entered is incorrect");
		WebElement Password=driver.findElement(By.id("password"));
		enterText(Password,"Va3ms3i94","Password");
		logger.log(LogStatus.PASS,"password got entered");
		WebElement LoginBttn=driver.findElement(By.id("submitButton"));
		clickObject(LoginBttn,"Login");
		logger.log(LogStatus.PASS,"Login button got clicked");
		Thread.sleep(1000);
		WebElement ErrMsg=driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		System.out.println("ERROR:entered EmailAddress is incorrect");
		logger.log(LogStatus.INFO,"ERROR msg Email entered is incorrect");
		logger.log(LogStatus.INFO,"Testcase1c got passed");
		
		report.endTest(logger);
		report.flush();

		System.out.println("End");
		driver.quit();
		/*TestCase1 D
		 * forgot password*/
		System.out.println("Testcase 1D");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://login.xero.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS,"CHROME BROWSER GOT LAUNCHED");
		WebElement ForgotPasswordLink=driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		clickObject(ForgotPasswordLink,"Forgot Your Password");
		logger.log(LogStatus.PASS,"Forgot password link got clicked");
		WebElement Email=driver.findElement(By.id("UserName"));
		enterText(Email,"vamsi30394@gmail.com","Email");
		logger.log(LogStatus.PASS,"user name in forgot password got entered");
		WebElement SendLinkButton=driver.findElement(By.xpath("//span[@class='text']"));
		clickObject(SendLinkButton,"Send Link");
		logger.log(LogStatus.PASS,"Send link button got clicked");
		System.out.println("NOTE:An Email is sent to your mail id to Reset your password ");
		
		report.endTest(logger);
		report.flush();
		
		System.out.println("End");
		
		/*TestCase2
		 * Sign Up to XDC*/
		System.out.println("Testcase 2A");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver.get("https://www.xero.com/us/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS,"Login successfull");

		WebElement FreeTrailLink=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink,"Free trail");
		logger.log(LogStatus.PASS,"Free trail link got clicked");

		WebElement FirstName=driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(FirstName,"Vamsi","First Name");
		logger.log(LogStatus.PASS,"first name got entered");

		WebElement LastName=driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(LastName,"Priya","Last Name");
		logger.log(LogStatus.PASS,"lastName got entered");

		WebElement EmailAddressTrail=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(EmailAddressTrail,"vamsi30394@gmail.com","Email address");
		logger.log(LogStatus.PASS,"email address got entered");

		WebElement PhoneNumber=driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(PhoneNumber,"1000000000","Phone Number");
		logger.log(LogStatus.PASS,"phone number got entered");

		
		Thread.sleep(2000);
		
		WebElement radioBtn1=driver.findElement(By.xpath("//input[@value='true']"));
		clickCheckBox(radioBtn1, "I have read and i agree");
		logger.log(LogStatus.PASS,"radio button I agree got selected");

		WebElement Start=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(Start, "Get started");
		logger.log(LogStatus.PASS,"start button got clicked");
		logger.log(LogStatus.INFO,"testcase2A is successfull");

		
        report.endTest(logger);
		report.flush();

		System.out.println("End");
		driver.quit();
        /*TestCase2 B
         * signup with xero 
         * without proper details */
		System.out.println("Testcase 2B");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement FreeTrailLink1=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink1,"Free trail");
		logger.log(LogStatus.PASS,"free trail Link got clicked");

		WebElement Start1=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(Start1, "Get started");
		logger.log(LogStatus.PASS,"start got clicked");

		System.out.println("ERROR: All firstname, lastname,phonenumber, email tabs can't be empty");
		driver.quit();
		logger.log(LogStatus.INFO,"error msg all fields are empty and highlighted");

		//
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		WebElement FreeTrailLink2=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink2,"Free trail");
		logger.log(LogStatus.PASS,"Free trail link got clicked");

		WebElement FirstName2=driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(FirstName2,"Vamsi","First Name");
		logger.log(LogStatus.PASS,"First name got entered");

		WebElement LastName2=driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(LastName2,"Priya","Last Name");
		logger.log(LogStatus.PASS,"last name got entered");

		WebElement EmailAddressTrail2=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(EmailAddressTrail2,"thujdb fh","Email address");
		logger.log(LogStatus.PASS,"email address entered incorrectly");

		WebElement PhoneNumber2=driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(PhoneNumber2,"1000000000","Phone Number");
		logger.log(LogStatus.PASS,"phone number got entered");

		
		Thread.sleep(2000);
		WebElement radioBtn2=driver.findElement(By.xpath("//input[@value='true']"));
		clickCheckBox(radioBtn2, "I have read and i agree");
		logger.log(LogStatus.PASS,"radio button I agree got selected");

		WebElement Start2=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(Start2, "Get started");
		logger.log(LogStatus.PASS,"start button got clicked");

		
		System.out.println("ERROR:Email address is invalid");
		
		logger.log(LogStatus.INFO,"Error msg Email address is invalid");
		driver.quit();
		//
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		WebElement FreeTrailLink3=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink3,"Free trail");
		logger.log(LogStatus.PASS,"Free trail button got clicked");

		WebElement FirstName3=driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(FirstName3,"Vamsi","First Name");
		logger.log(LogStatus.PASS,"first name field entered");

		WebElement LastName3=driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(LastName3,"Priya","Last Name");
		logger.log(LogStatus.PASS,"last name field got entered");

		WebElement EmailAddressTrail3=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(EmailAddressTrail3,"vamsi30394@gmail.com","Email address");
		logger.log(LogStatus.PASS,"Email address field got entered");

		WebElement PhoneNumber3=driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(PhoneNumber3,"1000000000","Phone Number");
		logger.log(LogStatus.PASS,"phone number field got entered");

		WebElement Start3=driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(Start3, "Get started");
		System.out.println("ERROR:Term and Policy checkbox highlighted.");
		logger.log(LogStatus.INFO,"Error msg Terms and policy checkbox not selected");
		logger.log(LogStatus.INFO,"Testcase2B completed successfully");

		
		report.endTest(logger);
		report.flush();

		System.out.println("End");
		driver.quit();
		/*TestCase2 C
		 * terms link
		 * privacy link*/
		System.out.println("Testcase 2C");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		WebElement FreeTrailLink4=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink4,"Free trail");
		logger.log(LogStatus.PASS,"Freetrail got clicked");

		WebElement termsLink=driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickObject(termsLink,"terms of use");
		System.out.println("terms of use page get generated");
		logger.log(LogStatus.PASS,"Terms link got clicked");
		logger.log(LogStatus.PASS,"terms of use page get generated");

		WebElement privacyLink=driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickObject(privacyLink,"Privacy notice");
		logger.log(LogStatus.PASS,"privacy link got clicked");

		System.out.println("privacy notice page get generated");
		logger.log(LogStatus.PASS,"privacy notice page get generated");
		logger.log(LogStatus.INFO,"Testcase2C completed successfull");

		report.endTest(logger);
		report.flush();
		System.out.println("End");
		//driver.quit();
		
		
		/*TestCase2 D
		 * offer details Link*/
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver.get("https://www.xero.com/us/");
		WebElement FreeTrailLink5=driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(FreeTrailLink5,"Free trail");
		logger.log(LogStatus.PASS,"Free trail link got clicked");
		System.out.println("Testcase 2D");

		WebElement OfferDetailsLink=driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickObject(OfferDetailsLink,"Offer Details");
		System.out.println("offer details page get navigated");
		logger.log(LogStatus.PASS,"offer details got clicked");
		logger.log(LogStatus.PASS,"offer details navigated to next page");

		WebElement Accountkeeper=driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		clickObject(Accountkeeper,"accountant or bookkeeper");
		logger.log(LogStatus.PASS,"accountant or bookkeeper link got clicked");
		System.out.println("A new Let's start a great partnership web page open");
		logger.log(LogStatus.PASS,"A new Let's start a great partnership web page opend");
		logger.log(LogStatus.INFO,"Test case2D is success");

		
		report.endTest(logger);
		report.flush();
		System.out.println("End");
		driver.quit();
		
		/*TestCase 3
		 * 
		 * Test all tabs page inside login page*/
		System.out.println("Testcase 3");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Signin_Action.Execute( driver);
		System.out.println("Login successfull");
		logger.log(LogStatus.PASS,"Login successfull");

		
		WebElement DashboardTab=driver.findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"));
		clickObject(DashboardTab,"Dashboard");
		System.out.println("Dashboard page is opened");
		logger.log(LogStatus.PASS,"Dashboard button got clicked and opened");

		
		WebElement AccountingTab=driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		clickObject(AccountingTab,"Accounting");
		System.out.println("Accounting dropdown will open");
		logger.log(LogStatus.PASS,"Accounting Tab got clicked and opened");

		WebElement ReportsTab=driver.findElement(By.xpath("//a[contains(text(),'Reports')]"));
		clickObject(ReportsTab,"Reports");
		System.out.println("Reports page is opened");
		logger.log(LogStatus.PASS,"Reports tab got clicked and opened");

		WebElement ContactsTab=driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
		clickObject(ContactsTab,"Contacts");
		System.out.println("contacts dropDown page is opened");
		logger.log(LogStatus.PASS,"contacts tab got clicked and opened");

		WebElement TeckArchTab=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
		clickObject(TeckArchTab,"TeckArch");
		System.out.println("TeckArch dropDown page is opened");
		logger.log(LogStatus.PASS,"TeckArch name tab got clicked and dropdown is opened");

		WebElement SettingsTab=driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		clickObject(SettingsTab,"Settings");
		System.out.println("Settings page is opened");
		logger.log(LogStatus.PASS,"Settings tab got clicked and opened");

		WebElement NewTab=driver.findElement(By.xpath("//button[@title='Create new']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(NewTab,"+");
		System.out.println("New(+) dropdown page  is opened");
		clickObject(NewTab,"+");
		logger.log(LogStatus.PASS,"+ symbol tab got clicked and dropdown got opened");

		Thread.sleep(1000);
		
		WebElement TeckArchTab1=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
		clickObject(TeckArchTab1,"TeckArch");
		System.out.println("TeckArch dropDown page is opened");
		logger.log(LogStatus.PASS,"TeckArch name tab got clicked and dropdown is opened");

		WebElement FilesTab=driver.findElement(By.xpath("//a[contains(text(),'Files')]"));
		clickObject(FilesTab,"Files");
		System.out.println("Files page is opened");
		logger.log(LogStatus.PASS,"File tab got clicked and opened");

		WebElement NotificationSymbol=driver.findElement(By.xpath("//button[@title='Notifications']"));
		clickObject(NotificationSymbol,"Notification");
		System.out.println("Notification DropDownpage is opened");
		logger.log(LogStatus.PASS,"Notification tab got clicked and dropdown got opened");

		WebElement SearchSymbol=driver.findElement(By.xpath("//button[@title='Search']"));
		clickObject(SearchSymbol,"Search");
		System.out.println("Search Tab is opened");
		logger.log(LogStatus.PASS,"Search symbol tab got clicked and opened");

		WebElement HelpTab=driver.findElement(By.xpath("//button[@title='Help']"));
		clickObject(HelpTab,"?/Help");
		System.out.println("Help dropdown Tab is opened");
		logger.log(LogStatus.PASS,"?/Help tab got clicked and opened");
		logger.log(LogStatus.INFO,"Testcase3 is success");

		
		report.endTest(logger);
		report.flush();
		System.out.println("End");
		driver.quit();
		/*TestCase 4
		 * Test Logout Functionality*/
		System.out.println("Testcase 4");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Signin_Action.Execute( driver);
		System.out.println("Login successfull");
		logger.log(LogStatus.PASS,"Login successfull");

		WebElement profileTab=driver.findElement(By.xpath("//button[@title='vamsi priya']"));
		clickObject(profileTab,"Profile");
		logger.log(LogStatus.PASS,"Profile tab got clicked and dropdown got opened");

		WebElement LogOutTab=driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')] "));
		clickObject(LogOutTab,"Logout");
		logger.log(LogStatus.PASS,"Logout got clicked");
		logger.log(LogStatus.PASS,"successfully logged out from login page");

		System.out.println("Logout successfull");
		WebElement UserName=driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		clickObject(UserName,"Username");
		System.out.println("UserName is displayed in the Textbox");
		logger.log(LogStatus.PASS,"Username field got clicked and user name is displayed on the tab");
		logger.log(LogStatus.INFO,"Testcase4 is success");

		report.endTest(logger);
		report.flush();
		System.out.println("End");
		driver.quit();
	/*TestCase 6
	 * Test Upload profile image
	 * */
		System.out.println("Testcase 6");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Signin_Action.Execute( driver);
		System.out.println("Login successfull");
		logger.log(LogStatus.PASS,"Login successfull");

		WebElement profileTab1=driver.findElement(By.xpath("//button[@title='vamsi priya']"));
		clickObject(profileTab1,"Profile");
		logger.log(LogStatus.PASS,"Profile tab got clickedand dropdown got opened");

		WebElement Edit=driver.findElement(By.xpath("//h4[@class='xrh-verticalmenuitem--heading']"));
		clickObject(Edit,"Edit");
		logger.log(LogStatus.PASS,"clicked on edit tab,navigated to next page");

//		WebElement Changeimage=driver.findElement(By.xpath("//span[contains(text(),'Change Image')]"));
//		clickObject(Changeimage,"Change");
//		logger.log(LogStatus.PASS,"change tab got clicked, and image chaninging page gets open");

		//switching to alert
		//driver.switchTo().alert().dismiss();
		//driver.findElement(By.name("file")).click();
		//WebElement BrowseImage=driver.findElement(By.name("file"));
		//clickObject(BrowseImage,"Browse");
		//WebElement UploadImage=driver.findElement(By.xpath("//input[@name='file']"));
		//enterText( "C:\\Users\\vamsi\\Desktop\\Tree.jpg","image");
		
		logger.log(LogStatus.PASS,"Image got selected");
		WebElement ed=driver.findElement(By.xpath("//div[@id='footer-1162-innerCt']"));
		WebElement UploadTab=driver.findElement(By.xpath("//div[@id='button-1164']"));
		clickObject(UploadTab,"Upload");
		
		logger.log(LogStatus.PASS,"image got uploaded");
		logger.log(LogStatus.INFO,"Testcase6 is success");
		report.endTest(logger);
		report.flush();
		System.out.println("End");
		driver.quit();
//		/*TestCase8 A 
//		 * Add another organization Trail version - 1
//		 * */
//		System.out.println("Testcase 8A");
//		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
//		String path10="C:\\Users\\vamsi\\Documents\\QaReport\\Xero Tetcase8A.html";
//		ExtentReports report10 = new ExtentReports(path10);driver = new ChromeDriver();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Signin_Action.Execute( driver);
//		System.out.println("Login successfull");
//		logger.log(LogStatus.PASS,"Login successfull");
//
//		WebElement TeckArchTab6=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
//		clickObject(TeckArchTab6,"TeckArch");
//		System.out.println("TeckArch dropDown page is opened");
//		logger.log(LogStatus.PASS,"Techarch tab got clicked and dropdown got opened");
//
//		WebElement AddOrganization=driver.findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"));
//		clickObject(AddOrganization,"Add new Organization");
//		Thread.sleep(1000);
//		logger.log(LogStatus.PASS,"Add Organization got clicked, and navigated to next page");
//
//		WebElement org=driver.findElement(By.xpath("//div[@id='container-1020']"));
//		Thread.sleep(1000);
//		WebElement OrganizationName=driver.findElement(By.name("OrganisationName"));
//		enterText(OrganizationName,"Clairvoyant","what is the name of your organization");
//		logger.log(LogStatus.PASS,"organization name got entered");
//
//		//Thread.sleep(1000);
////		WebElement org1=driver.findElement(By.id("container-1023"));
////		WebElement organizationpay=driver.findElement(By.id("ext-gen1096"));
////		Select dropdown=new Select(organizationpay);
////		dropdown.selectByVisibleText("United States");
////
////		//dropdown.selectByIndex(227);
////
////		WebElement TimeZone=driver.findElement(By.xpath("//div[@id='ext-gen1100']"));
////		Select dropdown1=new Select(TimeZone);
////		dropdown1.selectByIndex(60);
//		logger.log(LogStatus.PASS,"country USA got selected");
//
//		Thread.sleep(1000);
//		WebElement org2=driver.findElement(By.xpath("//div[@id='industryPnl']"));
//		WebElement organizationDo=driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
//		enterText(organizationDo,"engineering","What does your organization do?");
//		logger.log(LogStatus.PASS,"entered Engineering design in Do tab");
//
////		Select dropdown3=new Select(organizationDo);
////		dropdown3.selectByIndex(6);
////		org2.click();
////		WebElement org3=driver.findElement(By.xpath("//div[@id='container-1028']"));
////		//WebElement previous=driver.findElement(By.xpath("//div[@id='ext-gen1119']"));
////		Select dropdown2=new Select(driver.findElement(By.xpath("//div[@id='ext-gen1119']")));
////		dropdown2.selectByIndex(9);
//		
//		WebElement org4=driver.findElement(By.xpath("//div[@id='footer-1031-innerCt']"));
//		WebElement StartTrial1=driver.findElement(By.id("simplebutton-1035"));
//		clickObject(StartTrial1,"Start Trial");
//		System.out.println(" Organization added should be accurate with 'In trail' subscription	");
//		logger.log(LogStatus.PASS,"clicked on startTrail button");
//		logger.log(LogStatus.INFO,"Test case8A is success");
//
//		report10.endTest(logger);
//		report10.flush();
//		System.out.println("End");
//		driver.quit();
//		/*TestCase8 B
//		 * Add another organization - Paid version 1*/
//		System.out.println("Testcase 8B");
//		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
//		String path11="C:\\Users\\vamsi\\Documents\\QaReport\\Xero Tetcase8B.html";
//		ExtentReports report11 = new ExtentReports(path11);driver = new ChromeDriver();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Signin_Action.Execute( driver);
//		System.out.println("Login successfull");
//		logger.log(LogStatus.PASS,"XERO Login SUCCESS");
//
//		WebElement TeckArchTab3=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
//		clickObject(TeckArchTab3,"TeckArch");
//		System.out.println("TeckArch dropDown page is opened");
//		logger.log(LogStatus.PASS,"techarch tab got clickedand dropdown is opened");
//
//		WebElement AddOrganization2=driver.findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"));
//		clickObject(AddOrganization2,"Add new Organization");
//		Thread.sleep(1000);
//		logger.log(LogStatus.PASS,"Add organization got clicked and navigated to next page");
//
//		WebElement org7=driver.findElement(By.xpath("//div[@id='container-1020']"));
//		Thread.sleep(1000);
//		WebElement OrganizationName3=driver.findElement(By.name("OrganisationName"));
//		enterText(OrganizationName3,"Clairvoyant","what is the name of your organization");
//		logger.log(LogStatus.PASS,"organization name got entered");
//
//		//Thread.sleep(1000);
////		WebElement org1=driver.findElement(By.id("container-1023"));
////		WebElement organizationpay=driver.findElement(By.id("ext-gen1096"));
////		Select dropdown=new Select(organizationpay);
////		dropdown.selectByVisibleText("United States");
////
////		//dropdown.selectByIndex(227);
////
////		WebElement TimeZone=driver.findElement(By.xpath("//div[@id='ext-gen1100']"));
////		Select dropdown1=new Select(TimeZone);
////		dropdown1.selectByIndex(60);
//		logger.log(LogStatus.PASS,"selected country United states");
//
//		Thread.sleep(1000);
//		WebElement org6=driver.findElement(By.xpath("//div[@id='industryPnl']"));
//		WebElement organizationDo3=driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
//		enterText(organizationDo3,"engineering","What does your organization do?");
//		logger.log(LogStatus.PASS,"entered engineering in Do tab");
//
//	//	organizationDo.isSelected();
////		Select dropdown3=new Select(organizationDo);
////		dropdown3.selectByIndex(6);
////		org2.click();
////		WebElement org3=driver.findElement(By.xpath("//div[@id='container-1028']"));
////		//WebElement previous=driver.findElement(By.xpath("//div[@id='ext-gen1119']"));
////		Select dropdown2=new Select(driver.findElement(By.xpath("//div[@id='ext-gen1119']")));
////		dropdown2.selectByIndex(9);
////		WebElement org5=driver.findElement(By.xpath("//div[@id='footer-1031-innerCt']"));
////		WebElement BuyNowbutton=driver.findElement(By.id("simplebutton-1036"));
////		
////		clickObject(BuyNowbutton,"Buy Now");
////		System.out.println(" Should be able to navigate to \"Purchase Plan\" Subscription and Billing page");
//		logger.log(LogStatus.PASS,"Time zone pacific time got selected");
//		logger.log(LogStatus.PASS,"Buy now got clicked");
//		logger.log(LogStatus.INFO,"Testcase8B is success");
//
//		report11.endTest(logger);
//		report11.flush();
//		System.out.println("End");



	}

}