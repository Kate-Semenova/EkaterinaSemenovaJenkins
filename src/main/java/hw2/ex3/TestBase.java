package hw2.ex3;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

/**
 * Created by Екатерина on 01.06.2018.
 */
public class TestBase {
    public static final String driverPath = "src\\main\\resources\\chromedriver.exe";

    @BeforeSuite(alwaysRun = true)
    public static void setUpSuit() {
        setProperty("webdriver.chrome.driver", driverPath);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDownSuit() {
        System.out.println(System.currentTimeMillis());
    }

}
