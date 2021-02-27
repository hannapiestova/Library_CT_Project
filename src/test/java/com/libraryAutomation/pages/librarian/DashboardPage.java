package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.libraryAutomation.utilities.BrowserUtils.getElementsText;

public class DashboardPage extends BookPage_lib {

        List<WebElement> getTabs =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//ul[@id='menu_item']")));
    public WebElement getUsersButton() {
        return usersButton;
    }

    @FindBy(xpath = "//li[@class='nav-item'][1]")
    private WebElement dashboardButton;

    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    private WebElement usersButton;

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public WebElement getDashboardButton() {
        return dashboardButton;
    }

    public void setUsersButtonClick(){
        usersButton.click();
        System.out.println( Driver.getDriver().getClass().getSimpleName());
    }

    public List<String> getModules(){

        List<WebElement> getTabs =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//li[@class='nav-item']")));

        return  getElementsText(getTabs);

    }

    public List<String> getGroups(){
        Select getGroups=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='user_groups']")));
        List<WebElement> allGroups =  new ArrayList<>(getGroups.getOptions());
        return  BrowserUtils.getElementsText(allGroups);

    }

    public List<String> getStatus(){
        Select getStatus=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='user_status]")));
        List<WebElement> allStatus =  new ArrayList<>(getStatus.getOptions());
        return  BrowserUtils.getElementsText(allStatus);

    }


    public List<String> getTableRows(){

        List<WebElement> getRows =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("(//tr[@role='row'])[1]")));
        return  BrowserUtils.getElementsText(getRows);
    }

    public void usersBtnClick(){
        usersButton.click();
    }
}
