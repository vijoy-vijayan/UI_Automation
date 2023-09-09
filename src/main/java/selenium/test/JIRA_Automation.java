package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JIRA_Automation {

    static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {

        try {

            String URL = "https://api-training.atlassian.net/";
            String email = "hari.radhakrishnan@testleaf.com";
            String password = "India@123";

            String ticketName="SDET5_Group2_Vijoy1";

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            driver.get(URL);

            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
            driver.findElement(By.xpath("//button[@id='login-submit']")).click();

            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@id='login-submit']")).click();


            driver.findElement(By.xpath("//h2[text()='Recent projects']/parent::div/following-sibling::div/section/div[1]")).click();
            driver.findElement(By.xpath("//span[text()='Create']")).click();
            driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(ticketName);
            driver.findElement(By.xpath("//button[@type='submit']/span")).click();

            driver.findElement(By.xpath("(//span[text()='View issue'])[1]")).click();
            driver.findElement(By.xpath("//span[text()='Create subtask']")).isDisplayed();

            driver.findElement(By.xpath("//span[text()='Backlog']")).click();

            driver.findElement(By.xpath("//input[@name='search']")).sendKeys(ticketName);
            Thread.sleep(5000);
            String expectedText = driver.findElement(By.xpath("(//div[text()='Backlog'])[2]/following-sibling::div")).getText();

            System.out.println("Expected Test"+expectedText);
            if(expectedText.contains("1 of"))
                System.out.println("Created Ticket successfully");

        } catch (Exception e) {
            System.out.println("EXCEPTION THROWN IN SCRIPT... Check the below error");
            System.out.println(e.getMessage());
        } finally {

            driver.quit();

            System.out.println("Executed Finally Block");

        }

    }

}
