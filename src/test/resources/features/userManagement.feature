@table
Feature: user management table feature
  As a use I should be able to see following user management table columns names

  Scenario: user management table columns names
    Given librarian is on the home page
    When librarian navigates to "Users" page
    Then librarian should see following column names
    |Actions  |
    |User ID  |
    |Full Name|
    |Email    |
    |Group    |
    |Status   |