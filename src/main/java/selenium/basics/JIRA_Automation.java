package selenium.basics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static selenium.basics.Individuals.Individual_CreateAccount;
import static selenium.basics.WorkForceType.WorkForceType_CreateAccount;
import static selenium.basics.WorkForceType.WorkForceType_EditAccount;
import static selenium.basics.WorkForceType.WorkForceType_DeleteAccount;
import static selenium.basics.WorkForceType.WorkForceType_CreateAccount_WithoutMandatoryFields;
import static selenium.basics.WorkForceType.WorkForceType_ValidateAscendingOrder;
import static selenium.basics.Common.viewAllApps;
import static selenium.basics.Common.searchSpecificApp;
import static selenium.basics.Common.launchChrome;

public class Salesforce_Automation {
	static ChromeDriver driver;



	public static void main(String[] args) throws InterruptedException {

		try

		{

			WTG_TC001();

			WTG_TC002();

			WTG_TC003();

			WTG_TC004();
			WTG_TC005();

		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION THROWN IN SCRIPT... Check the below error");
			System.out.println(e.getMessage());
		}
		finally
		{
		
		Thread.sleep(3000);
//		driver.quit();
// 		setTimeout(function(){debugger;},5000);
		}


	}

	public static void Salesforce_Login()
	{
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		//load URL
		driver.get("https://login.salesforce.com/");

		//sendkeys() method pass values in textbox
		driver.findElement(By.id("username")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("Login")).click();

		System.out.println("Salesforce login is successful");

		
	}

	public static void WTG_TC001() throws InterruptedException {

		launchChrome();

		Salesforce_Login();

		viewAllApps();

		searchSpecificApp("Work Type Groups");

		WorkForceType_CreateAccount();

		driver.quit();
	}

	public static void WTG_TC002() throws InterruptedException {
		launchChrome();

		Salesforce_Login();

		viewAllApps();

		searchSpecificApp("Work Type Groups");

		WorkForceType_EditAccount();

		driver.quit();
	}

	public static void WTG_TC003() throws InterruptedException {
		launchChrome();

		Salesforce_Login();

		viewAllApps();

		searchSpecificApp("Work Type Groups");

		WorkForceType_DeleteAccount();

		driver.quit();
	}

	public static void WTG_TC004() throws InterruptedException {

		launchChrome();

		Salesforce_Login();

		viewAllApps();

		searchSpecificApp("Work Type Groups");

		WorkForceType_CreateAccount_WithoutMandatoryFields();

		driver.quit();
	}

	public static void WTG_TC005() throws InterruptedException {

		launchChrome();

		Salesforce_Login();

		viewAllApps();

		searchSpecificApp("Work Type Groups");

		WorkForceType_ValidateAscendingOrder();

		driver.quit();
	}



}
