package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.librarian.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibrarianBooksRecors {

    LogInPage logInPage=new LogInPage();
    DashboardPage dashboardPage=new DashboardPage();

    @When("I click on \"Users\"link")
    public void i_click_on_users_link() {
        logInPage.librarianLogin();
        dashboardPage.setUsersButtonClick();
    }




    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {

    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
