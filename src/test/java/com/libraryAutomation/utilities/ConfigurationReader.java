package com.libraryAutomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //in this class we will implement the repeated steps pf reading from
    //configuration.properties file
    private static Properties properties = new Properties();
    //the reason we use static block
    //because we want the code that's inside to be executed before anything else
    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/proeprties/configuration.properties");
            properties.load(file);
            //closing the file in JVM memory
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}
