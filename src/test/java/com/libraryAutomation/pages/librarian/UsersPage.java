package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static com.libraryAutomation.utilities.BrowserUtils.*;

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
    private WebElement verMsg;

    @FindBy(id = "start_date")
    private WebElement startDate;

    @FindBy(xpath = "(//tr//th[.='Today'])[1]")
    private WebElement today;

    @FindBy(xpath = "//tbody//tr[4]//td[7]")
    private WebElement endDateCalendar;

    @FindBy(id = "end_date")
    private WebElement endDate;

    @FindBy(xpath = "//*[@id=\"user_status\"]")
    private WebElement statusDropDown;

    public WebElement getAddUser() {
        return addUser;
    }

    public void editUser(String index,String user,String status){
        String xpath = "(//tr//td[1])["+index+"]";
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        editButton.click();

        fullName.clear();
        fullName.sendKeys(faker.name().fullName());

        password.clear();
        password.sendKeys(faker.internet().password());

        email.clear();
        email.sendKeys(faker.internet().emailAddress());

        saveChanges.click();

        BrowserUtils.hover(verMsg);

        Assert.assertTrue(verMsg.isDisplayed());



    }

    public void addUser(String user , String status){
        addUser.click();

        fullName.clear();
        fullName.sendKeys(faker.name().fullName());

        password.clear();
        password.sendKeys(faker.internet().password());

        email.clear();
        email.sendKeys(faker.internet().emailAddress());

        Select select = new Select(Driver.getDriver().findElement(By.id("user_group_id")));
        select.selectByVisibleText(user);

        Select select1 = new Select(Driver.getDriver().findElement(By.id("status")));
        select1.selectByVisibleText(status);

        startDate.click();
        today.click();

        endDate.click();
        endDateCalendar.click();


        address.sendKeys(faker.address().fullAddress());

        saveChanges.click();


    }

    public Integer recordsDefaultValue(){
        Select showRecords=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='tbl_users_length']")));
        String defaultValue=showRecords.getFirstSelectedOption().getText();
        Integer intDeaulValue=Integer.parseInt(defaultValue);
        return intDeaulValue;
    }

    public List<String> showRecordsValue(){
        Select showRecords=new Select(Driver.getDriver().findElement(By.xpath("//select[@name=\"tbl_users_length\"]")));

        List<String> actualList=new ArrayList<>();
        for(WebElement each:showRecords.getOptions()){
            actualList.add(each.getText());
        }
        return getElementsText(showRecords.getOptions());
    }

    public void statusClick(){
        statusDropDown.click();
    }

      public List<String> statusInfo(){
      Select selectStatus=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='user_status']")));
       List<WebElement> statusWebElements=selectStatus.getOptions();
       return BrowserUtils.getElementsText(statusWebElements);
}



}
