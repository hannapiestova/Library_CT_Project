Feature: User status
  As a librarian user, I should be able to see users status options under Users module
@wip
  Scenario: verify user status

    Given the user (Librarian) on the homepage
    When the user click users moudle
    And the user click Status dopdown
    Then the user should see the following options:

      |ACTIVE        |
      |INACTIVE    |





