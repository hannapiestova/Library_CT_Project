package com.libraryAutomation.pages;

import com.github.javafaker.Faker;
import static com.libraryAutomation.utilities.BrowserUtils.*;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public Faker faker = new Faker();

    @FindBy(id = "navbarDropdown")
    private WebElement userButton;

    @FindBy(className = "dropdown-item")
    private WebElement logOutButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;

    @FindBy(xpath = "//h3")
    private WebElement bookManagement;




    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public WebElement getBookManagement() {
        return bookManagement;
    }

    public void selectBookCategories(String genre){
        Select categories = new Select(Driver.getDriver().findElement(By.id("book_categories")));
        categories.selectByVisibleText(genre);
    }

    public void  selectRecords(String amount){
        Select record = new Select(Driver.getDriver().findElement(By.name("tbl_books_length")));
        record.selectByValue(amount);
    }

    public void navigateTo(String tab){
        String locatorTab= "//span[@class='title' and text()='"+tab+"']";
        BrowserUtils.wait(3);
        WebElement tabElement = Driver.getDriver().findElement(By.xpath(locatorTab));
        BrowserUtils.wait(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

    }

    public void logout(String username){
        if(username.equalsIgnoreCase("student")){
            waitForElementToBeClickable(userButton).click();

            waitForElementToBeClickable(logOutButton);
            logOutButton.click();
        }else if(username.equalsIgnoreCase("librarian")){
           waitForElementToBeClickable(userButton).click();

           waitForElementToBeClickable(logOutButton).click();

        }

    }

    public void logout(){
        BrowserUtils.waitForElementToBeClickable(userButton).click();

        BrowserUtils.waitForElementToBeClickable(logOutButton).click();

    }

    public void searchInput(String txt){
        search.sendKeys(txt, Keys.ENTER);
    }
}
