package com.libraryAutomation.pages.student;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BooksPage_stu extends BasePage {


    @FindBy(xpath = "//select[@name='tbl_users_length']")
    private WebElement records;


    public void borrowBook(String index){
        String xpath = "(//tr//td[1])["+index+"]";
        WebElement borrowBookButton = Driver.getDriver().findElement(By.xpath(xpath));
        if(borrowBookButton.isEnabled()){
            borrowBookButton.click();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
            WebElement borrowedMsg = Driver.getDriver().findElement(By.xpath("//*[text()='The book has been borrowed...']"));
            wait.until(ExpectedConditions.visibilityOf(borrowedMsg));
            if(borrowedMsg.isDisplayed()){
                System.out.println("Test passed");
            }else{
                System.out.println("Button becomes invisible");
            }
           // Assert.assertTrue(borrowedMsg.isDisplayed());
        }else{
            System.out.println("Book is already borrowed");
        }

    }


    public List<String> getRecords(){
        Select showRecords=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='tbl_users_length']")));
        List<WebElement> getRecords =  new ArrayList<>(showRecords.getOptions());
        return  BrowserUtils.getElementsText(getRecords);

    }


}
