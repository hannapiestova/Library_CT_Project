package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.librarian.UsersPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class UserManagColumnsNameStepDefinitions {

    UsersPage usersPage = new UsersPage();
    @Then("librarian should see following column names")
    public void librarian_should_see_following_column_names(List<String> table) {
        Assert.assertEquals(table,usersPage.getTableInfo());
    }
}
