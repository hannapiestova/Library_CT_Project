package com.libraryAutomation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class Driver {

    private final static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    //threadLocal class in java that creates a cope of an instance of thread
    //creates a copy of web driver object

    /**
     * to make parallel testing possible , driver must be capable to handle multiple threads.
     * If driver just singelton, it cannot be in 3 places at the same time.
     * To resolve this issue we made a webdriver object threadlocal
     * It allows to create a cope of the object at the run time of every thread.
     * Also we need to make webdriver synchronized to prevent crash. so , 2 or more threads won't conflict
     */

    private Driver(){

    }

    public synchronized static WebDriver getDriver(){
        if(driverPool.get() ==null){
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                   // chromeOptions allows us to modify browser(run incognito mode, change settings etc.)
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless"://headless-->browser with no interface. so browser is running in the background
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    //if browser type, stop test and throw exception
                    throw new RuntimeException("Wrong browser type");

            }
        }
        return driverPool.get();
    }

    public static void close(){
        //if driver still exists
        if(driverPool!=null){
            //close all browsers
            driverPool.get().quit();
            //destroy driver object , ready fo garbage collection
            driverPool.remove();
        }
    }
}
