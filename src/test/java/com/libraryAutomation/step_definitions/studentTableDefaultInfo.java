package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.student.BooksPage_stu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import static com.libraryAutomation.utilities.BrowserUtils.*;

import java.util.List;

public class studentTableDefaultInfo {

    BooksPage_stu booksPage_stu=new BooksPage_stu();

    LogInPage logInPage=new LogInPage();
    @Given("the user on the homepage")
    public void the_user_on_the_homepage() {
        logInPage.studentLogIn();
    }




    @Then("the user shoulde see the following column names:")
    public void the_user_shoulde_see_the_following_column_names(List<String> expected)throws InterruptedException {
          waitForElementToBeClickable(booksPage_stu.getBooksBtn());
        Assert.assertEquals(booksPage_stu.getDefaultInfo(),expected);

    }


}
