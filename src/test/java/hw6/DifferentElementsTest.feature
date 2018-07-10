Feature: Data Page Interface
Scenario:
Given I am on Home Page
Then The title is correct

When I perform login as user epam/1234
Then The user name is PITER CHAILOVSKII
And The interface on Home page, contains all needed elements

When I click oh Service subcategory in the header
Then Header drop down contains options

When I click on Service subcategory in the left section
Then Left drop down contains options

Given I open through the header menu Service
And I open Different Elements Page
Then Interface on Different elements page contains all needed elements
And Assert that there is Left Section
And Assert that there is Right Section

When I select checkboxes Water, Wind
Then CheckBoxes Water, Wind are selected
And Log row is displayed
And Value is corresponded to the status of checkbox

When I select radio button Selen
Then Radio is checked
And Log row is displayed
And Radio button name and its status is corresponding to selected

When I select in dropdown Yellow
Then Color is selected
And Log row is displayed
And Dropdown name and its status is corresponding to selected

When I unselect and assert checkboxes Water, Wind
Then CheckBoxes Water, Wind are unselected
And Log row is displayed
And Value is corresponded to the status of checkbox
