package hw6.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static hw6.enums.Pages.HOME_PAGE;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    @FindBy(css = ".sub")
    public SelenideElement serviceLeftDropDown;

    public HomePage() {
        page(this);
    }

    private final String URL = HOME_PAGE.url;
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceHeader;

    @FindBy(css = "a[href='different-elements.html']")
    SelenideElement differentElementsPageButton;

    @FindBy(css = ".benefit-icon")
    ElementsCollection icons;
    @FindBy(css = ".benefit-txt")
    ElementsCollection textsBellow;
    @FindBy(css = ".main-content > [class*='main']")
    ElementsCollection textsAbove;

    @Step
    @Given("I am on Home Page")
    public void openHomePage() {
        Selenide.open(URL);
    }

    @Step
    @Then("The title is correct")
    public void checkTitle() {
        Assert.assertEquals(Selenide.title(), HOME_PAGE.title);
    }

    @Step("Login")
    @When("I perform login as user (.*)/(.*)")
    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @FindBy(css = ".logout")
    public SelenideElement logOut;

    @Step("Login")
    @Given("I am logged in as (.*)")
    public void login(String userName) {
        User user = User.getUserByName(userName);
        userIcon.click();
        if (isLoggedIn()) {
            logOut.click();
        }
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();

    }

    private boolean isLoggedIn() {
        return !loginInput.isDisplayed();
    }

    @Step
    @Then("The user name is (.*)")
    public void checkUserName(String name) {
        userIcon.shouldHave(text(name));
    }


    @Step
    @Then("The interface on Home page, contains all needed elements") //4 - pictures, 4 texts under them, 2 text above
    public void checkAllElements() {
        icons.shouldHaveSize(4);
        textsBellow.shouldHaveSize(4);
        textsAbove.shouldHaveSize(2);
    }

    @Step
    @When("I click oh Service subcategory in the header")
    @Given("I open through the header menu Service")
    public void clickServiceHeader() {
        serviceHeader.shouldBe(visible);
        serviceHeader.click();
    }

    @Step
    @When("I click on Service subcategory in the left section")
    public void clickServiceLeft() {
        serviceLeft.shouldBe(visible);
        serviceLeft.click();
    }

    @FindBy(css = ".dropdown-menu")
    public SelenideElement serviceHeaderDropDown;

    @FindBy(css = ".fa-caret-down")
    public SelenideElement serviceLeft;

    @Step
    @Then("(.+) drop down contains options")
    public void checkTheOptions(String position) {
        SelenideElement dropDown = null;
        if (position.equals("Header")) {
            dropDown = serviceHeaderDropDown;
        }
        if (position.equals("Left")) {
            dropDown = serviceLeftDropDown;
        }
        dropDown.shouldBe(visible);
        for (SelenideElement element : dropDown.$$("li")
                ) {
            element.shouldBe(visible);
        }
        dropDown.$$("li").shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    @Step()
    @Given("I open User Table Page through the header menu Service -> User Table")
    public void openUserTablePage() {
        openPage(userTablePageButton);
    }

    @FindBy(css = "a[href='user-table.html']")
    public SelenideElement userTablePageButton;


    @Step("Open Different ElementsPage Page by href")
    @Given("I open Different Elements Page")
    public void openDifferentElementsPage() {
        openPage(differentElementsPageButton);
    }

    private void openPage(SelenideElement pageButton) {
        if (!pageButton.isDisplayed()) {
            serviceHeader.click();
        }
        pageButton.click();
    }
}
