package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LibraryPage_lib extends BookPage_lib {

    public List<String> getTabs(){

        List<WebElement> getTabs =  new ArrayList<>(Driver.getDriver().findElements(By.id("navbarCollapse")));
        return  BrowserUtils.getElementsText(getTabs);

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
}
