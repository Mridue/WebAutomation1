package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Contact {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arifq\\webautomationmaven\\generic\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.get("http://automationpractice.com");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


    }
    @Test
    public void contactAsCustomerService(){
        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();

        Select dropHeading = new Select(driver.findElement(By.id("id_contact")));
        dropHeading.selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("automation@test.com");
        driver.findElement(By.name("id_order")).sendKeys("F015362E");
        driver.findElement(By.name("message")).sendKeys("Contact us testing as customer service");
        WebElement upload = driver.findElement(By.id("fileUpload"));
        upload.sendKeys("C:\\Users\\arifq\\Pictures\\Screenshots\\Screenshot.png");

        driver.findElement(By.xpath("//*[@id=\'submitMessage\']/span")).click();
        String actualText = driver.findElement(By.xpath("//*[@id=\'center_column\']/p")).getText();

        Assert.assertEquals(actualText,"Your message has been successfully sent to our team.");

        System.out.println("Test passed as customer service");
        driver.close();
    }



}

