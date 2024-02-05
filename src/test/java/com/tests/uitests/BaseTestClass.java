package com.tests.uitests;

import com.testauto.commoncode.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTestClass {

    static WebDriver driver;

    @BeforeTest
    static void setup(){

        driver = DriverFactory.getChromeDriver();
    }



    @AfterTest
    static void cleanup(){
        driver.close();
    }

}
