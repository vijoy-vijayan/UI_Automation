package selenium.basics;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkForceType extends Salesforce_Automation {

    public static void WorkForceType_CreateAccount() throws InterruptedException {

        driver.findElement(By.xpath("//a/span[text()='Work Type Groups']/parent::a/following-sibling::one-app-nav-bar-item-dropdown/div//a")).click();

        WebElement newWTG = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
        driver.executeScript("arguments[0].click();", newWTG);

        String name_WTG="Salesforce Automation by Vijoy Vijayan";

        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name_WTG);

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        String xpath_toastMessage= "//lightning-icon[@icon-name='utility:success']/following-sibling::div//span[text()='Work Type Group']";

        String actualText = driver.findElement(By.xpath(xpath_toastMessage + "/a/div")).getText();

        if(actualText.equals(name_WTG))
        {
            System.out.println("WTG Creation is successful");
        }
        else
        {
            System.out.println("WTG Creation is not successful");
            throw new AssertionError("WTG Creation is not successful");
        }


    }

    public static void WorkForceType_EditAccount() throws InterruptedException {



        String name_WTG="Salesforce Automation by Vijoy Vijayan";

        driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(name_WTG);

        driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody//td[5]//a")).click();

        WebElement editButton = driver.findElement(By.xpath(" //div[@title='Edit']"));
        driver.executeScript("arguments[0].click();", editButton);

        driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea")).sendKeys("Automation");
        driver.findElement(By.xpath("//label[text()='Group Type']/following-sibling::div//button")).click();
        driver.findElement(By.xpath("//span[@title='Capacity']")).click();

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        Thread.sleep(1000);
        String xpath_toastMessage= "//lightning-icon[@icon-name='utility:success']/following-sibling::div//span[text()='Work Type Group']";

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='"+name_WTG+"']")).click();
        driver.findElement(By.xpath("//h3//span[text()='Description']/ancestor::button")).click();

        String actualText = driver.findElement(By.xpath("(//span[text()='Description'])[2]/ancestor::div[2]//lightning-formatted-text")).getText();
        System.out.println("Description value: "+actualText);
        if(actualText.equals("Automation"))
        {
            System.out.println("WTG Edit is successful");
        }
        else
        {
            System.out.println("WTG Edit is not successful");
            throw new AssertionError("WTG Creation is not successful");
        }


    }

    public static void WorkForceType_DeleteAccount() throws InterruptedException {


        String name_WTG="Salesforce Automation by Vijoy Vijayan";

        driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(name_WTG);

        driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody//td[5]//a")).click();

        WebElement deleteButton = driver.findElement(By.xpath(" //div[@title='Delete']"));
        driver.executeScript("arguments[0].click();", deleteButton);


        driver.findElement(By.xpath("//button[@title='Delete']")).click();

        Thread.sleep(1000);
        String xpath_toastMessage= "//lightning-icon[@icon-name='utility:success']/following-sibling::div//span[text()='Work Type Group']";

        Thread.sleep(2000);

//        boolean isDisplayed = driver.findElement(By.xpath("//a[text()='" + name_WTG + "']")).;

        boolean isRowDeleted = driver.findElements(By.xpath("//a[text()='" + name_WTG + "']")).isEmpty();

        if (isRowDeleted) {
            System.out.println("WTG Delete is successful");
        } else {
            System.out.println("WTG Delete is not successful");
            throw new AssertionError("WTG Deletion is not successful");
        }



    }

    public static void WorkForceType_CreateAccount_WithoutMandatoryFields() throws InterruptedException {

        driver.findElement(By.xpath("//a/span[text()='Work Type Groups']/parent::a/following-sibling::one-app-nav-bar-item-dropdown/div//a")).click();

        WebElement newWTG = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
        driver.executeScript("arguments[0].click();", newWTG);

        driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea")).sendKeys("Automation");
        driver.findElement(By.xpath("//label[text()='Group Type']/following-sibling::div//button")).click();
        driver.findElement(By.xpath("//span[@title='Capacity']")).click();

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@title='Close error dialog']")).click();

        boolean isEnabled = driver.findElement(By.xpath("//input[@name='Name']/ancestor::lightning-input/div[2][text()='Complete this field.']")).isEnabled();


        if(isEnabled)
        {
            System.out.println("WTG Alert Validation is successful");
        }
        else
        {
            System.out.println("WTG Alert Validation is not successful");
            throw new AssertionError("WTG Creation is not successful");
        }


    }

    public static void WorkForceType_ValidateAscendingOrder() throws InterruptedException {

        driver.findElement(By.xpath("//span[text()='Work Type Groups']")).click();
        String flag_Sorting = driver.findElement(By.xpath("//span[@title='Work Type Group Name']/parent::a/following-sibling::span")).getText();

        System.out.println("Before: "+flag_Sorting );

        if(flag_Sorting.equals("Sorted Descending"))
            driver.findElement(By.xpath("//span[@title='Work Type Group Name']")).click();

        flag_Sorting = driver.findElement(By.xpath("//span[@title='Work Type Group Name']/parent::a/following-sibling::span")).getText();

        System.out.println("After"+flag_Sorting );
        if(flag_Sorting.equals("Sorted Ascending"))
        {
            System.out.println("WTG is displayed in Ascending order");
        }
        else
        {
            System.out.println("WTG is not sorted properly");
            throw new AssertionError("WTG Creation is not successful");
        }


    }
}
