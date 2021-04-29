package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class WaitsOneTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
    }

    // @Test
    public void testPageImplicit() {
        WebElement loc_btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        loc_btnStart.click();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement loc_lblSaludo = driver.findElement(By.xpath("//div[@id='finish']/h4"));

        Assert.assertEquals("Hello World!", loc_lblSaludo.getText());
    }

    // @Test
    public void testPageExplicit() {
        WebElement loc_btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        loc_btnStart.click();

        By loc_lblSaludo = By.xpath("//div[@id='finish']/h4");

        // Explicit Wait
        WebDriverWait expWait = new WebDriverWait(driver, 5);
        expWait.until(ExpectedConditions.visibilityOfElementLocated(loc_lblSaludo));

        WebElement loc_msgSaludo = driver.findElement(loc_lblSaludo);

        Assert.assertEquals("Hello World!", loc_msgSaludo.getText());
    }

    @Test
    public void testPageFluent() {
        WebElement loc_btnStart = driver.findElement(By.xpath("//div[@id='start']/button"));
        loc_btnStart.click();

        By loc_txtSaludo = By.xpath("//div[@id='finish']/h4");

        // Fluent Wait
        Wait<WebDriver> fluWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
        fluWait.until(ExpectedConditions.visibilityOfElementLocated(loc_txtSaludo));

        WebElement loc_lblSaludo = driver.findElement(loc_txtSaludo);

        Assert.assertEquals("Hello World!", loc_lblSaludo.getText());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
