package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Ekaterina on 29.05.2018.
 */
public class SmokeAndRegressionTest {

    @Test(groups = "Smoke")
    public void simpleSeleniumTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Open URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //Check page title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();


        //5 Assert User name in the left-top side of screen that user is logged in
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        //6 Close browser
        driver.close();
    }

    @Test(groups = "Regression")
    public void simpleSeleniumTest2() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Open URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //Check page title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();


        //5 Assert User name in the left-top side of screen that user is logged in
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        //6 Close browser
        driver.close();
    }

    @Test(groups = "Regression")
    public void simpleSeleniumTest3() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Open URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //Check page title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();


        //5 Assert User name in the left-top side of screen that user is logged in
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //6 Close browser
        driver.close();
    }
}
