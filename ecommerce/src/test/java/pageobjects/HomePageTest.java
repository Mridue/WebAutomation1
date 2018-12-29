package pageobjects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends CommonAPI {
//    WebDriver driver = null;
//
//
//    @BeforeMethod
//    public void setup() {
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arifq\\webautomationmaven\\generic\\Driver\\chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.get("http://automationpractice.com");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--incognito");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

  //  }


    @Test
    public void searchTest() {




        driver.findElement(By.id("search_query_top")).sendKeys("Shoes", Keys.ENTER);
        driver.findElement(By.name("submit_search")).click();
        String actualText = driver.findElement(By.partialLinkText("Printed Chiffon Dress")).getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Printed Chiffon Dress");




    }

    @Test
    public void contactUsTest() {

        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        String actualText = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(actualText, "CUSTOMER SERVICE - CONTACT US");


        System.out.println("ContactTest us Test");


    }

//    @AfterMethod
//    public void tearDown() {
//
//
//        driver.quit();
        //driver.close();
    }

//}

