Feature: Student borrowing books feature
  As a user, I should able to see my borrowing books.


  Scenario: Scenario: borrowing books tabe columns names

    Given the student on the homepage
    When the user click Borrowing Books module
    Then the user shoulde see the following column names in a borrowing books table:
      | Action                    |
      | Book Name                 |
      | Borrowed Date             |
      | Planned Return Date       |
      | Return Date               |
      |Is Returned ?              |




