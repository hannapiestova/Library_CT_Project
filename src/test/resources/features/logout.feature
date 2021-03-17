@smoke_test
Feature: Logout feature
  As a user I should be able to logout from the library app

  Scenario Outline: User logout verification
    Given user is on the login page
    And user login as a "<role>"
    Then user logout as a "<role>"
    And user is on the login page


    Examples:
    |role     |
    |student  |
    |librarian|