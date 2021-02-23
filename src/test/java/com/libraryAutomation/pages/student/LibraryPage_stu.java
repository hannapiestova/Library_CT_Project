package com.libraryAutomation.pages.student;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LibraryPage_stu {

    public List<String> getTabs(){

        List<WebElement> getTabs =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//ul[@id='menu_item']")));
        return  BrowserUtils.getElementsText(getTabs);

    }

    public List<String> getDefaultInfo(){
        List<WebElement> defaultInfo =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//thead/tr")));
        return  BrowserUtils.getElementsText(defaultInfo);

    }

    public List<String> getCategories(){
        Select showCategories=new Select(Driver.getDriver().findElement(By.xpath("//select[@id=‘book_categories’]")));
        List<WebElement> getCategories =  new ArrayList<>(showCategories.getOptions());
        return  BrowserUtils.getElementsText(getCategories);

    }

}
