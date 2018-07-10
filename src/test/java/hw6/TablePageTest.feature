Feature: User Table Page Interface
Scenario: User Table Page test
Given I am on Home Page
And I am logged in as Piter Chailovskii
And I open User Table Page through the header menu Service -> User Table
And I am on Users Table Page
#And User Table Page is Active
#And User Table Page's interface contains correct elements
#
When I check Number and User columns of Users table
Then User table contain correct values for numbers and users
| Number | User |
| 1 | Roman |
| 2 | Sergey Ivan |
| 3 | Vladzimir |
| 4 | Helen Bennett |
| 5 | Yoshi Tannamuri |
| 6 | Giovanni Rovelli |
#
When I check Description column of Users table
Then All cells of 'Description' column contains text
| Number | Desciption |
| 1 | Lorem ipsum |
| 2 | Lorem ipsum |
| 3 | Lorem ipsum |
| 4 | Lorem ipsum some description|
| 5 | Lorem ipsum some description|
| 6 | Lorem ipsum some description|
#
When I set 'vip' status to Sergey Ivan
Then 'Log' section shows a log row in format: FIELDNAME: condition changed to STATUS
#
#
When I click on dropdown in column Type for user Roman
Then droplist contains values
| Dropdown Values |
| Admin |
| User |
| Manager |
