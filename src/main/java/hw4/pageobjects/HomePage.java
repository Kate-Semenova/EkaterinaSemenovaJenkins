package hw4.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static hw4.enums.Pages.HOME_PAGE;

/**
 *
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    private final String URL = HOME_PAGE.url;
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = "a[href='dates.html']")
    private SelenideElement datesPageButton;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceDropDown;

    @FindBy(css = "a[href='different-elements.html']")
    SelenideElement differentElementsPageButton;

    @Step ("Open Home Page")
    public void openHomePage() {
        Selenide.open(URL);
    }

    @Step ("Check the title")
    public void checkTitle() {
        Assert.assertEquals(Selenide.title(), HOME_PAGE.title);
    }

    @Step("Login")
    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step("Open dropdown Service")
    public void openService() {
        serviceDropDown.shouldBe(visible);
        serviceDropDown.click();
    }

    @Step("Open Dates Page by href")
    public void openDatesPage() {
        openPage(datesPageButton);
    }

    @Step("Open Different ElementsPage Page by href")
    public void openDifferentElementsPage() {
        openPage(differentElementsPageButton);
    }

    private void openPage(SelenideElement pageButton){
        pageButton.shouldBe(visible);
        pageButton.click();
    }
}
