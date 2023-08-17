package selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Salesforce_Automation {


	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		Salesforce_Login();
		
		try
		{

		Salesforce_CreateAccount();
		}
//		catch(Exception e)
//		{
//			
//		}
		finally
		{
		
		Thread.sleep(5000);
		driver.quit();
		}


	}

	public static void Salesforce_Login()
	{
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		//load URL
		driver.get("https://login.salesforce.com/");

		//sendkeys() method pass values in textbox
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.id("password")).sendKeys("Leaf$1234");

		driver.findElement(By.id("Login")).click();

		System.out.println("Salesforce login is successful");

		
	}

	public static void Salesforce_CreateAccount()
	{

		driver.findElement(By.className("slds-icon-waffle")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();


		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		WebElement accountName = driver.findElement(By.xpath("//input[@name='Name']"));
		driver.executeScript("arguments[0].click();", accountName);
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf User");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		System.out.println("Create Account is successful in Salesforce");

	}
}
