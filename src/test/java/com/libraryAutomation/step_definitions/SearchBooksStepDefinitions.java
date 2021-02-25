package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.student.BooksPage_stu;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.libraryAutomation.utilities.BrowserUtils.waitForPageToLoad;


public class SearchBooksStepDefinitions {

    LogInPage login = new LogInPage();
    BooksPage_stu booksPage = new BooksPage_stu();
    Select selectedIndex;



    @Given("User is on Book page")
    public void userIsOnBookPage() {
        login.studentLogIn();
    }

    @And("Student click on different categories")
    public void studentClickOnDifferentCategories() {
        BrowserUtils.wait(2);
        booksPage.bookCategories.click();
    }

    @Then("It should display all categories")
    public void it_should_display_all_categories() {
        selectedIndex = new Select(booksPage.bookCategories);

    }


    @Then("Student able to select any categories and search Books")
    public void student_able_to_select_any_categories_and_search_books(List<String> listOfCategories) {
       for( int i = 1; i < listOfCategories.size(); i++){
           selectedIndex.selectByIndex(i);
           BrowserUtils.wait(1);
           Assert.assertEquals(listOfCategories.get(i), booksPage.currentBookCategory.getText());

       }
    }


}
