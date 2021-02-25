package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.student.BooksPage_stu;
import com.libraryAutomation.pages.student.BorrowingBooksPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import static com.libraryAutomation.utilities.BrowserUtils.*;

public class StudentBorrowingBooksStepDefenitions {

    LogInPage logInPage=new LogInPage();
    BooksPage_stu booksPage_stu=new BooksPage_stu();
    BorrowingBooksPage borrowingBooksPage=new BorrowingBooksPage();

    @When("the user click Borrowing Books module")
    public void the_user_click_borrowing_books_module() {
      waitForElementToBoVisible(booksPage_stu.getBooksBtn());
       booksPage_stu.borrowingBooksBtnClick();
    }


    @Then("the user shoulde see the following column names in a borrowing books table:")
    public void the_user_shoulde_see_the_following_column_names_in_a_borrowing_books_table(List<String> expected) {
        waitForElementToBoVisible(booksPage_stu.getBooksBtn());
        System.out.println(expected);
        System.out.println(borrowingBooksPage.borrowingBooksTabletInfo());
        Assert.assertEquals(borrowingBooksPage.borrowingBooksTabletInfo(),expected);

    }

    @Given("the student on the homepage")
    public void theStudentOnTheHomepage() {
        logInPage.studentLogIn();
    }
}
