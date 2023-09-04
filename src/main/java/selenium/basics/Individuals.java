package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Individuals extends Salesforce_Automation {

    public static void Individual_CreateAccount() throws InterruptedException {

        driver.findElement(By.className("slds-icon-waffle")).click();

        driver.findElement(By.xpath("//button[text()='View All']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Individuals");

        driver.findElement(By.xpath("//p/mark[text()='Individuals']")).click();

        System.out.println("Progressed on Create account part of Work Force Type");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//a/span[text()='Individuals']/parent::a/following-sibling::one-app-nav-bar-item-dropdown/div//a")).click();

//        driver.findElement(By.xpath("//span[text()='New Work Type Group']")).click();


        WebElement newWTG = driver.findElement(By.xpath("//span[text()='New Individual']"));
        driver.executeScript("arguments[0].click();", newWTG);

//        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Vijoy Vijayan");
//
//        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();



/*
        WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
        driver.executeScript("arguments[0].click();", account);

        driver.findElement(By.xpath("//div[@title='New']")).click();

        WebElement accountName = driver.findElement(By.xpath("//input[@name='Name']"));
        driver.executeScript("arguments[0].click();", accountName);

        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf User");

        driver.findElement(By.xpath("//button[text()='Save']")).click();
*/
        System.out.println("Create Account is successful in Salesforce");

    }
}
