package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.librarian.DashboardPage;
import com.libraryAutomation.pages.librarian.UsersPage;
import com.libraryAutomation.pages.student.BooksPage_stu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.management.InstanceNotFoundException;
import java.util.List;
import static com.libraryAutomation.utilities.BrowserUtils.*;
public class LibrarianBooksRecors {

    LogInPage logInPage=new LogInPage();
    DashboardPage dashboardPage=new DashboardPage();
    UsersPage usersPage=new UsersPage();

    @When("I click on \"Users\"link")
    public void i_click_on_users_link() {
        logInPage.librarianLogin();
        waitForElementToBoVisible(dashboardPage.getDashboardButton());
        dashboardPage.setUsersButtonClick();
    }




    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        waitForElementToBeClickable(usersPage.getAddUser());
        Assert.assertEquals(usersPage.recordsDefaultValue(),int1);
    }



    @And("show records should have following options:")
    public void showRecordsShouldHaveFollowingOptions(List<String > expected) {
        Assert.assertEquals(usersPage.showRecordsValue(),expected);
    }
}
