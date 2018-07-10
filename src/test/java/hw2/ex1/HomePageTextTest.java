package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ekaterina on 28.05.2018.
 */

public class HomePageTextTest {
    private ChromeOptions options;
    private final String TEXT_LOCATOR = ".benefit-txt";
    private final String URL = "https://epam.github.io/JDI/index.html";
    private WebDriver driver;
    private List<WebElement> imageAndTextDivs;

    @DataProvider(parallel = true)
    public Object[][] textInformation() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    //TODO Should check spelling
    @BeforeClass
    public void setUpConfigurations() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //TODO learn about options
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Open "https://epam.github.io/JDI/index.html"
        driver.navigate().to(URL);
        imageAndTextDivs = driver.findElements(By.cssSelector(TEXT_LOCATOR));
    }

    @AfterClass
    public void closeDriver() {
        //Close browser
        driver.close();
    }

    @Test(dataProvider = "textInformation")
    public void textTest(int i, String text) {
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        Assert.assertEquals(imageAndTextDivs.get(i).getText(), text);
    }
}
