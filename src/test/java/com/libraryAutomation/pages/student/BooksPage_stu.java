package com.libraryAutomation.pages.student;

import static com.libraryAutomation.utilities.BrowserUtils.*;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BooksPage_stu extends BasePage {

    public BooksPage_stu(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[@class='nav-item'][1]")
    private WebElement booksBtn;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    private WebElement records;

    public WebElement getBooksBtn() {
        return booksBtn;
    }

    public List<String> getModules(){
        List<WebElement> getTabs =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//li[@class='nav-item']")));
        return  getElementsText(getTabs);

    }

    public List<String> getDefaultInfo(){
        List<WebElement> defaultInfo =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//thead/tr")));
        return  getElementsText(defaultInfo);

    }

    public List<String> getCategories(){
        Select showCategories=new Select(Driver.getDriver().findElement(By.xpath("//select[@id=‘book_categories’]")));
        List<WebElement> getCategories =  new ArrayList<>(showCategories.getOptions());
        return  getElementsText(getCategories);

    }

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
