package com.libraryAutomation.pages.student;


import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.libraryAutomation.utilities.BrowserUtils.*;
import java.util.ArrayList;
import java.util.List;


public class BorrowingBooksPage {

    public List<String> getBorrowingBooks(){
        List<WebElement> borrowingBooks =  new ArrayList<>(Driver.getDriver().findElements(By.xpath("//*[@id='borrowed_list']/thead/tr")));
        return  BrowserUtils.getElementsText(borrowingBooks);

    }

    public List<String> borrowingBooksTabletInfo(){
        List<WebElement> tableElements=Driver.getDriver().findElements(By.xpath("//thead/tr/th"));
        return BrowserUtils.getElementsText(tableElements);
    }


}
