Feature: Tables Default Info
  As a students, I should be able to see tables with default info

  @wip
  Scenario: Table columns names

    Given the user on the homepage
    Then the user shoulde see the following column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      |Year         |
      |Borrowed By  |



