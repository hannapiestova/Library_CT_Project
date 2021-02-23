Feature: Login functionality
   As a user, I should be able to login to the library app.

  Scenario: User login verification
    Given user is on the login page
    When user login as a <role>
    Then user is on the <page>

