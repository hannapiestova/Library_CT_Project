
Feature: Modules verification
     As a user , I should be able to see several modules once I login


@wip
     Scenario: Modules verification for student
       Given student is on the home page
       Then student should see following modules
       |Books|
       |Borrowing Books|

    @modules_librarian
       Scenario: Modules verification for librarian
         Given librarian is on the home page
         Then librarian should see following modules
         |Dashboard      |
         |Users          |
         |Books          |