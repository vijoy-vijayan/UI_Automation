package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Common extends Salesforce_Automation{


    public static void launchChrome()
    {
        ChromeOptions options = new ChromeOptions();

        //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void viewAllApps() throws InterruptedException {

        driver.findElement(By.className("slds-icon-waffle")).click();

        driver.findElement(By.xpath("//button[text()='View All']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();

        Thread.sleep(2000);
    }

    public static void searchSpecificApp(String appName) throws InterruptedException {


//        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(appName);

        driver.findElement(By.xpath("//p/mark[text()='"+appName+"']")).click();

        System.out.println("Progressed on Create account part of Work Force Type");
    }
}
