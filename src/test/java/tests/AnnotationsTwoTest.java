package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnnotationsTwoTest {
    
    static WebDriver driver;
    
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    
    @Test
    public void logIn() throws InterruptedException {
        WebElement loc_txtUsername = driver.findElement(By.id("user-name"));
        WebElement loc_txtPassword = driver.findElement(By.id("password"));
        WebElement loc_btnLogin = driver.findElement(By.id("login-button"));
        
        loc_txtUsername.clear();
        loc_txtUsername.sendKeys("standard_user");
        loc_txtPassword.clear();
        loc_txtPassword.sendKeys("secret_sauce");
        
        loc_btnLogin.click();
        
        Thread.sleep(2000);
    }
    
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
