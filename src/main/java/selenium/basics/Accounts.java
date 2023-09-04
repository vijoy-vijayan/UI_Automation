package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Accounts extends Salesforce_Automation {

    public static void Accounts_CreateAccount()
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
