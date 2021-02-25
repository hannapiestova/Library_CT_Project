@user_group
Feature: User group category verification
  As a user , I should be able to see all group category feature

  Scenario: verify user categories
    Given librarian is on the home page
    Then librarian navigates to "Users" page
    And librarian clicks on user group button
    Then librarian should see the following options
    |ALL      |
    |Librarian|
    |Students |
