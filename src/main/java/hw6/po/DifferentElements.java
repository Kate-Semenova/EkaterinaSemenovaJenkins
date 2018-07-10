package hw6.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.CheckBox;
import hw6.enums.DropDown;
import hw6.enums.Radio;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Екатерина on 18.06.2018.
 */
public class DifferentElements {
    public DifferentElements() {
        page(this);
    }

    @FindBy(css = ".label-checkbox > input")
    public ElementsCollection checkBoxes;

    @FindBy(css = "[type = radio]")
    public ElementsCollection radios;

    @FindBy(css = ".colors > [class = uui-form-element]")
    public SelenideElement dropDown;

    @FindBy(css = "option")
    private ElementsCollection dropDownOptions;

    @FindBy(css = ".main-content-hg > [class = 'uui-button']")
    public ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    public SelenideElement rightSection;

    @FindBy(css = ".mCSB_vertical")
    public SelenideElement leftSection;

    @FindBy(css = ".logs > li")
    public ElementsCollection logCollection;

    @Step
    @Then("Interface on Different elements page contains all needed elements")
    public void shouldHasAllNeededElements() {
        checkBoxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        dropDown.shouldBe(visible);
        buttons.shouldHaveSize(2);
    }

    @Step
    @Then("Assert that there is Left Section")
    public void shouldHasLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    @Then("Assert that there is Right Section")
    public void shouldHasRightSection() {
        rightSection.shouldBe(visible);
    }


    @Step
    @When("I select checkboxes (.+)")
    public void selectCheckBox(String checkBoxNames) {
        List<CheckBox> list = new ArrayList<>();
        for (String elementName : checkBoxNames.split(", ")) {
            list.add((CheckBox.valueOf(elementName.toUpperCase())));
            amountOfLogs++;
        }

        for (CheckBox element : list
                ) {
            if (!checkBoxes.get(element.index).is(selected)) {
                checkBoxes.get(element.index).click();
            }
        }
        selectedCheckBoxes = list;

    }

    @Step
    @When("I unselect and assert checkboxes (.+)")
    public void unselectCheckBox(String checkBoxNames) {
        List<CheckBox> list = new ArrayList<>();
        for (String elementName : checkBoxNames.split(", ")) {
            list.add((CheckBox.valueOf(elementName.toUpperCase())));
            amountOfLogs++;
        }
selectedCheckBoxes = new ArrayList<>();
        for (CheckBox element : list
                ) {
            if (checkBoxes.get(element.index).is(selected)) {
                checkBoxes.get(element.index).click();
                selectedCheckBoxes.add(element);
            }
        }
       // selectedCheckBoxes = list;
    }


    @Step
    @Then("Log row is displayed")
    public void checkLogRow() {

        logCollection.shouldHave(size(amountOfLogs));
        //System.out.println("AMOUNT OF ROWS" + amount);

    }

    private List<CheckBox> selectedCheckBoxes = new ArrayList<>();

    @Step
    @Then("Value is corresponded to the status of checkbox")
    public void checkLogRowValueForCheckBox() {
        int size = selectedCheckBoxes.size();
        for (int i = 0; i < size; i++) {
            logCollection.get(i).should(matchText("\\d\\d:\\d\\d:\\d\\d "
                    + selectedCheckBoxes.get(size - i - 1).name + ": condition changed to "
                    + checkBoxes.get(selectedCheckBoxes.get(size - i - 1).index).is(checked)));


        }
    }


    @Step
    @Then("CheckBoxes (.+) are selected")
    public void checkBoxesAreSelected(String checkBoxNames) {
        for (CheckBox checkBox : selectedCheckBoxes
                ) {
            checkBoxes.get(checkBox.index).shouldBe(selected);
        }
        for (String elementName : checkBoxNames.split(", ")) {
            checkBoxes.get(CheckBox.getCheckBox(elementName).index);
        }
    }
    @Step
    @Then("CheckBoxes (.+) are unselected")
    public void checkBoxesAreUnSelected(String checkBoxNames) {
        for (CheckBox checkBox : selectedCheckBoxes
                ) {
            checkBoxes.get(checkBox.index).shouldNotBe(selected);
        }
        for (String elementName : checkBoxNames.split(", ")) {
            checkBoxes.get(CheckBox.getCheckBox(elementName).index);
        }
    }

    private SelenideElement radioButton;

    @Step
    @When("I select radio button (.+)")
    public void selectRadio(String radio) {
        radioButton = radios.get(Radio.valueOf(radio.toUpperCase()).index);
        radioButton.click();
        amountOfLogs++;

    }

    private int amountOfLogs;

    @Step
    @Then("Radio is checked")
    public void radioIsSelected() {
        radioButton.shouldBe(selected);
    }

    @Step
    @Then("Radio button name and its status is corresponding to selected")
    public void checkLogRowValueForRadio() {
        logCollection.get(0).should(matchText("\\d\\d:\\d\\d:\\d\\d metal: value changed to "
                + radioButton.getText()));
    }

    public SelenideElement selectedColor;

    @Step
    @When("I select in dropdown (.+)")
    public void selectDropDown(String color) {
        dropDown.click();
        selectedColor = dropDownOptions.get(DropDown.valueOf(color.toUpperCase()).index);
        selectedColor.click();
        amountOfLogs++;
    }

    @Step
    @Then("Color is selected")
    public void dropDownIsSelected() {
        selectedColor.shouldBe(selected);
    //    dropDown.shouldHave(text(selectedColor.getText()));
    }

    @Step
    @Then("Dropdown name and its status is corresponding to selected")
    public void checkLogRowValueForDropDown() {
        logCollection.get(0).should(matchText("\\d\\d:\\d\\d:\\d\\d Colors: value changed to "
                + selectedColor.getText()));
    }

}
