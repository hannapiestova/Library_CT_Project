@add_user
Feature: Librarian should be able to add and modify user from users page
  As a librarian , I should be able to add users from user page

  Scenario: Add and modify users from user page
    Given librarian is on the home page
    And librarian navigates to "Users" page
    Then librarian clicks on add user button
    Then librarian clicks on edit user button
    And librarian is able to edit user info

