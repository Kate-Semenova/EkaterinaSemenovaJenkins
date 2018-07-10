package hw6.po;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.Pages;
import hw6.enums.Table;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by Ekaterina on 05.07.2018.
 */
public class UserTable {
    public UserTable() {
        page(this);
    }

    public static final String URL = Pages.USER_TABLE.url;
    @FindBy(css = "tbody > tr")
    public ElementsCollection tableLines;

    @Step
    @Given("I am on Users Table Page")
    public void check() {
        Assert.assertEquals(url(), URL);
    }

    @Step
    @Then("User table contain correct values for numbers and users")
    public void checkValues(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        int i = 0;
        for (List<String> line : data) {

            String number = line.get(0);
            String user = line.get(1);

            if (i == 0) {
                tableLines.get(i).$$("th").get(Table.Number.index).shouldHave(Condition.text(number));
                tableLines.get(i).$$("th").get(Table.User.index).shouldHave(Condition.text(user));

            } else {
                tableLines.get(i).$$("td").get(Table.Number.index).shouldHave(Condition.text(number));
                tableLines.get(i).$$("td").get(Table.User.index).shouldHave(Condition.text(user));
            }
            i++;
        }
    }

    @Step
    @When("I check Number and User columns of Users table")
    public void checkNumberUser() {
        System.out.println("I check Number and User columns of Users table");
    }

    @Step
    @Then("All cells of 'Description' column contains text")
    public void checkDescription(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        int i = 0;
        for (List<String> line : data) {

            String number = line.get(0);
            String user = line.get(1);

            if (i == 0) {
                tableLines.get(i).$$("th").get(Table.Number.index).shouldHave(Condition.text(number));
                tableLines.get(i).$$("th").get(Table.Desciption.index).shouldHave(Condition.text(user));

            } else {
                tableLines.get(i).$$("td").get(Table.Number.index).shouldHave(Condition.text(number));
                tableLines.get(i).$$("td").get(Table.Desciption.index).shouldHave(Condition.text(user));
            }
            i++;
        }
    }

    //
    @Step
    @When("I check Description column of Users table")
    public void checkDescription() {
        //  System.out.println("I check Number and User columns of Users table");
        tableLines.get(0).$$("th").get(Table.Desciption.index).shouldBe(Condition.visible);
        for (int i = 1; i < tableLines.size(); i++) {
            tableLines.get(i).$$("td").get(Table.Desciption.index).shouldBe(Condition.visible);

        }
    }

    private SelenideElement getVIPCheckBox(SelenideElement cell) {
        return cell.$("[type='checkbox']");
    }

    @Step
    @When("I set 'vip' status to (.*)")
    public void setVIP(String name) {
        for (int i = 1; i < tableLines.size(); i++) {
            if (tableLines.get(i).$$("td").get(Table.User.index).has(Condition.text(name))) {
                changedVIP = getVIPCheckBox(tableLines.get(i));
                changedVIP.click();
            }
        }
    }

    private SelenideElement changedVIP;

    @Step
    @Then("'Log' section shows a log row in format: FIELDNAME: condition changed to STATUS")
    public void checkLog() {
        String regex = "Vip: condition changed to " + changedVIP.is(Condition.checked);
        logs.get(0).should(Condition.matchText(regex));
    }

    @FindBy(css = ".logs > li")
    public ElementsCollection logs;

    @Step
    @When("I click on dropdown in column Type for user (.*)")
    public void clickOnDropDown(String name) {
        for (int i = 1; i < tableLines.size(); i++) {
            if (tableLines.get(i).$$("td").get(Table.User.index).has(Condition.text(name))) {
                openedDropDown = tableLines.get(i).$("select");
                openedDropDown.click();
            }
        }
    }

    @Step
    @Then("droplist contains values")
    public void checkDropDownValues(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        List<String> options = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            options.add(data.get(i).get(0));
        }
        openedDropDown.$$("option").shouldHave(CollectionCondition.texts(options));
    }

    private SelenideElement openedDropDown;
}
