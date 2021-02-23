package com.libraryAutomation.pages.librarian;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookPage_lib extends BasePage {

  //  Faker faker = new Faker();
    @FindBy(xpath = "//input[@placeholder='Book Name']")
    private WebElement bookName;
    @FindBy(xpath = "//*[text()='The book has been updated.']")
    private WebElement verMsg;
    @FindBy(xpath = "//button[@class='btn btn-primary' and text()='Save changes']")
    private WebElement saveChanges;
    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    private WebElement addBook;
    @FindBy(xpath = "//input[@placeholder='Author']")
    private WebElement author;
    @FindBy(xpath = "//input[@placeholder='ISBN']")
    private WebElement ISBN;
    @FindBy(xpath = "//input[@placeholder='Year]")
    private WebElement year;
    @FindBy(id = "description")
    private WebElement description;



    public void editBook(String index){
        String xpath = "(//tr//td[1])["+index+"]";
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        editButton.click();
        bookName.clear();
        bookName.sendKeys(faker.book().title());
        saveChanges.click();
        if(verMsg.isDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Text Failed");
        }

    }

    public void addBook(String category){

        Date date=faker.date().birthday();
        SimpleDateFormat form=new SimpleDateFormat("YYYY");
        String dateF =form.format(date);
        addBook.click();
        bookName.sendKeys(faker.harryPotter().book());
        author.sendKeys(faker.book().author());
        ISBN.sendKeys(faker.number().digits(6));
        year.sendKeys(dateF);
        description.sendKeys(faker.harryPotter().quote());
        Select select = new Select(Driver.getDriver().findElement(By.id("book_group_id")));
        select.selectByVisibleText(category);

        saveChanges.click();

    }



}
