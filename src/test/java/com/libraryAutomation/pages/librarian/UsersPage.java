package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.pages.BasePage;
import static com.libraryAutomation.utilities.BrowserUtils.*;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage {


    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    private WebElement addUser;

    @FindBy(xpath = "//input[@placeholder='Full Name']")
    private WebElement fullName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement email;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement saveChanges;

    @FindBy(xpath = "//*[text()='The user updated']")
    private WebElement verMsgEdit;

    @FindBy(xpath = "//*[text()='The user has been created.']")
    private WebElement verMsgAddUser;

    @FindBy(id = "start_date")
    private WebElement startDate;

    @FindBy(xpath = "(//tr//th[.='Today'])[1]")
    private WebElement today;

    @FindBy(xpath = "//tbody//tr[4]//td[7]")
    private WebElement endDateCalendar;

    @FindBy(id = "end_date")
    private WebElement endDate;

    @FindBy(xpath = "//h3")
    private WebElement userManagementButton;

    @FindBy(id = "user_group_id")
    private WebElement selectUser;

    @FindBy(xpath = "//select[@id='status']")
    private WebElement selectStatus;

    @FindBy(xpath = "//select[@id='user_groups']")
    private WebElement userGroups;



    public WebElement getUserManagementButton() {
        return userManagementButton;
    }

    public WebElement getAddUser() {
        return addUser;
    }

    public WebElement getVerMsgEdit() {
        return verMsgEdit;
    }

    public WebElement getVerMsgAddUser() {
        return verMsgAddUser;
    }

    public WebElement getSelectUser() {
        return selectUser;
    }

    public WebElement getSelectStatus() {
        return selectStatus;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getSaveChanges() {
        return saveChanges;
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getToday() {
        return today;
    }

    public WebElement getEndDateCalendar() {
        return endDateCalendar;
    }

    public WebElement getEndDate() {
        return endDate;
    }

    public WebElement getUserGroups() {
        return userGroups;
    }


    public List<String> user_groups(){
        Select groups = new Select(userGroups);
        List<WebElement>getGroups = new ArrayList<>(groups.getOptions());
        return getElementsText(getGroups);
    }

    public void editUser(String index){
        String xpath = "(//tr//td[1])["+index+"]";
        waitForElementToBeClickable(userManagementButton);
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        editButton.click();

        waitForElementToBoVisible(fullName).clear();
        fullName.sendKeys(faker.name().fullName());

        waitForElementToBoVisible(password).clear();
        password.sendKeys(faker.internet().password());

        waitForElementToBoVisible(email).clear();
        email.sendKeys(faker.internet().emailAddress());

        waitForElementToBoVisible(saveChanges).click();

    }

    public void addUser(String user , String status){

        waitForElementToBeClickable(fullName);
        fullName.sendKeys(faker.name().fullName());


        waitForElementToBeClickable(password).sendKeys(faker.internet().password());



        waitForElementToBeClickable(email);
        email.sendKeys(faker.internet().emailAddress());

        Select select = new Select(selectUser);
        select.selectByVisibleText(user);


        Select select1 = new Select(selectStatus);
        select1.selectByVisibleText(status);

        waitForElementToBeClickable(startDate);
        startDate.click();

        waitForElementToBeClickable(today);
        today.click();

        waitForElementToBeClickable(endDate);
        endDate.click();

        waitForElementToBeClickable(endDateCalendar);
        endDateCalendar.click();


        waitForElementToBeClickable(address);
        address.sendKeys(faker.address().fullAddress());

        waitForElementToBeClickable(saveChanges);
        saveChanges.click();


    }

    public String checkUrl() {
        BrowserUtils.waitForPageToLoad(5);
        return Driver.getDriver().getCurrentUrl();
    }






}
