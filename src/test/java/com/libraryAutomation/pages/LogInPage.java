package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(id = "inputEmail")
    private WebElement emailInput;
    @FindBy(id = "inputPassword")
    private WebElement passwordInput;
    @FindBy(xpath ="//button[@class='btn btn-lg btn-primary btn-block']" )
    private WebElement singInButton;
    @FindBy(id = "inputEmail-error")
    private WebElement warningMsg;


    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public WebElement getWarningMsg() {
        return warningMsg;
    }
    public void studentLogIn(){
        emailInput.sendKeys(ConfigurationReader.getProperty("student"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("passwordStudent"),Keys.ENTER);
    }
    public void librarianLogin(){
        emailInput.sendKeys(ConfigurationReader.getProperty("librarian"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("passwordLibrarian"),Keys.ENTER);

    }
    public String checkTitle() {
        return Driver.getDriver().getTitle();
    }
    public String checkUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

    public void login(String username , String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);

    }



}
