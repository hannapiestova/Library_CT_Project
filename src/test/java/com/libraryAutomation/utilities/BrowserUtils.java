package com.libraryAutomation.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static String getScreenshot(String name){
        //if you wanna be more specific and avoid name duplication
        // name=name+"_"+ LocalDateTime.now();
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        //it'll create a new folder in your project
        //system.getProperty("user.dir)-->location of your project

        //creating an objet of take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //takes a screenshot and return it as a file object

        File destination = new File(path);//that's where we'll store a screenshot

        try {
            //copy file to a previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return path;

    }

    public static List<String> getElementsText(List<WebElement> webElementList){
        //Placeholder empty list of web element
        List<String> webElementsAsString = new ArrayList<>();
        //Looping through list of web elements and storing text into placeholder list
        for (WebElement each : webElementList) {
            webElementsAsString.add(each.getText());
        }
        //returning final List<String>
        return webElementsAsString;
    }

    public static void titleVerification(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        //return actualTitle.equals(expectedTitle);
    }

    public static void wait(int seconds){
        seconds *=1000;
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds){
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState" ).equals("complete");
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        }catch(Throwable error){
            error.printStackTrace();
        }
    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }



}
