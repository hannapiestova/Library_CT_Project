@smoke_test
Feature: Login functionality
   As a user, I should be able to login to the library app.


  Scenario Outline: User login verification
    Given user is on the login page
    When user login as a "<role>"
    Then user is on the "<page>"

    Examples:
    |role     |page      |
    |student  |books     |
    |librarian|dashboard |

