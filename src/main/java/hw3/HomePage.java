package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    private final String title = "Home Page";
    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = ".footer-content")
    private WebElement footer;

    @FindBy(css = ".nav > li")
    private List<WebElement> navigateBarElements;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private WebElement sideBar;

    @FindBy(css = ".text-center")
    private List<WebElement> centerTexts;

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void logIn(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String text) {
        assertEquals(userIcon.getText(), text);
    }

    public void checkHomePageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), title);
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }

    public void checkNavigationBar() {
        assertEquals(navigateBarElements.size(), 4);
        assertEquals(navigateBarElements.get(0).getText(), "HOME");
        assertEquals(navigateBarElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navigateBarElements.get(2).getText(), "SERVICE");
        assertEquals(navigateBarElements.get(3).getText(), "METALS & COLORS");
    }

    public void checkImagesOnIndexPage() {
        Assert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTexts() {
        Assert.assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public void checkSideBar() {
        assertTrue(sideBar.isDisplayed());
    }


    public void checkTextsOnMainHeaderAreDisplayed() {
        assertEquals(centerTexts.size(), 4);
        for (WebElement text : centerTexts) {
            assertTrue(text.isDisplayed());
        }
    }

    public void checkTextsOnMainHeader() {
        assertEquals(centerTexts.get(0).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(centerTexts.get(1).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                        "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."
        );
        assertEquals(centerTexts.get(2).getText(), "JDI GITHUB");
    }

    public void checkJDILink() {
        assertEquals(centerTexts.get(2).findElement(By.cssSelector("a"))
                .getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void close(WebDriver driver) {
        driver.close();
    }
}
