package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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


    public void editUser(String index,String user,String status){
        String xpath = "(//tr//td[1])["+index+"]";
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        editButton.click();

        Select select = new Select(Driver.getDriver().findElement(By.id("user_group_id")));
        select.selectByVisibleText(user);

        Select select1 = new Select(Driver.getDriver().findElement(By.id("status")));
        select1.selectByVisibleText(status);

        address.clear();
        address.sendKeys(faker.address().fullAddress());



    }





}
