package tests;

import java.time.Duration;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsTwoTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
    }

    // @Test
    public void testDynamicDataExplicit() {
        WebElement loc_btnGetUser = driver.findElement(By.id("save"));
        loc_btnGetUser.click();

        By loc_imgUser = By.xpath("//div[@id='loading']/img");

        // Explicit Wait
        WebDriverWait expWait = new WebDriverWait(driver, 5);
        expWait.until(ExpectedConditions.attributeContains(loc_imgUser, "src", "https://randomuser.me/"));

        WebElement loc_userPic = driver.findElement(loc_imgUser);

        Assert.assertTrue(!loc_userPic.getAttribute("src").isEmpty());
    }

    @Test
    public void testDynamicDataFluent() {
        WebElement loc_btnGetUser = driver.findElement(By.id("save"));
        loc_btnGetUser.click();

        By loc_imgUser = By.xpath("//div[@id='loading']/img");

        // Fluent Wait
        Wait<WebDriver> fluWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
        fluWait.until(ExpectedConditions.visibilityOfElementLocated(loc_imgUser));

        WebElement loc_userPic = driver.findElement(loc_imgUser);

        Assert.assertTrue(loc_userPic.isDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
