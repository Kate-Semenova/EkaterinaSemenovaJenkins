package hw4;

import hw4.pageobjects.DifferentElements;
import hw4.pageobjects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.FailesTestAttachmentListener;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.CheckBox.*;
import static hw4.enums.DropDown.*;
import static hw4.enums.Radio.SELEN;
import static hw4.enums.User.PITER_CHAILOVSKII;

/**
 * Created by Ekaterina on 18.06.2018.
 */
@Feature("Home page, Different Element Page")
@Story("Login and check interface")
@Listeners({FailesTestAttachmentListener.class})
public class DifferentElementsPageTest extends ServiceSuiteBase {
    private HomePage homePage;

    @DataProvider
    public Object[][] information() {

        return new Object[][]{
                {WATER, WIND},
                {SELEN},
                {YELLOW},
                {WATER, WIND}
        };
    }

    @Test(dataProvider = "information")
    public void elementsTest(Object[] elements) throws InterruptedException {
        homePage = page(HomePage.class);
        //1 Open test site by URL
        homePage.openHomePage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Open through the header menu Service -> Different Elements Page
        homePage.openService();
        homePage.openDifferentElementsPage();

        DifferentElements differentElementPage = page(DifferentElements.class);

        //5 Check interface on Different elements page, it contains all needed elements
        differentElementPage.shouldHasAllNeededElements();

        //6 Assert that there is Right Section
        differentElementPage.shouldHasRightSection();

        //7 Assert that there is Left Section
        differentElementPage.shouldHasLeftSection();

        //8 Select elements: checkBoxes, radio, dropdown, checkBoxes
        differentElementPage.selectElement(elements);

        //9 Assert there is an individual log row
        differentElementPage.shouldHasCorrectLogRow(elements);

        //10 Close browser
        close();
    }
}
