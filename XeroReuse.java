package com.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XeroReuse {
	static WebDriver driver;

	public static void initialize_driver() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	}

	public static void LaunchDriver(String URL)
	{
		driver.get(URL);
	}
	/* name of the method:findElement
	 *Brief Description:
	 *arguments:location:location of the object
	 *			ElementName:name of the object
	 *Created By:Automation team
	 *created date:03/12/2019
	 *Last Modified:*/
	public static WebElement findElement(By location,String objName)
	{
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			System.out.println("Pass: " + objName + " found on the page.");
		} catch (NoSuchElementException errMessage) {
			System.out.println("Fail: " + objName + " cound not be found on the page.");
		}
		return obj;

	}

	/* name of the method:enterText--> Textbox
	 *Brief Description:enter a text into textbox
	 *arguments:WebElement String
	 *Created By:Automation team
	 *created date:03/12/2019
	 *Last Modified:*/
	public static void enterText(WebElement obj ,String textVal,String objName) throws InterruptedException 
	{
		if(obj.isDisplayed()) {
			Thread.sleep(2000);
			obj.sendKeys(textVal);

			System.out.println("Pass:" +objName+" entered into text field");
		}
		else {

			System.out.println("Fail:" +objName+" could not find the field");

		}
	}
	/* Name of the Method:clickObject--> Button
	 *Brief Description:Clicking on the button
	 *arguments:WebElement 
	 *Created By:Automation team
	 *created date:03/12/2019
	 *Last Modified:*/
	public static void clickObject(WebElement element,String objName) throws InterruptedException 
	{
		if(element.isDisplayed()) {
			Thread.sleep(1000);
			element.click();
			System.out.println("Pass:" +objName+ " got clicked succefully");
		}
		else {
			System.out.println("Fail:" +objName+ " unable to find the button");
		}}
	/*Name of the method:clickCheckbox--->checkbox
	 * Breif Description:clicking on the perticular checkobx
	 * argument:WebElement
	 * created by:Automation team
	 * created date:03/21/2019
	 * Last modified
	 * */
	public static void clickCheckBox(WebElement obj,String objName) throws InterruptedException {
		if(obj==null)
			return;
		if(obj.isDisplayed()) {
			if(!obj.isSelected()) {
				Thread.sleep(1000);
				obj.click();
			}
			System.out.println("Pass:" +objName+ "Element is successfully Selected");
		}
		else {
			System.out.println("Fail:" +objName+ "could not find the checkbox");
		}

	}

}
/*Name of the method:select option from dropdown--->Dropdown
 * Breif Description:selecting a perticular option from dropdown menu
 * argument:WebElement, ObjName
 * created by:Automation team
 * created date:03/21/2019
 * Last modified
 * */

