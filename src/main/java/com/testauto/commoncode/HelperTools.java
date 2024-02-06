package com.testauto.commoncode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelperTools {

    /**
     * Putting the google input box here since I foresee there will be a lot of text examples
     * that would want to use the google search engine.
     */
    public static final String googleInputBoxXPathStr = "//textarea[@id='APjFqb']";
    /**
     * XPath string for the list of Recommended Searches when a user inputs a string into
     * the google input box.
     */
    public static final String googleRecommendedSearchesXPathStr = "//*[@id='Alh6id']//ul[@role='listbox']";

    /**
     * This is a convenience method to aid visually inspecting how the test is proceeding.
     * WARNING: Excessive usage can slow down a test's runtime.
     */
    public static void mySleep(int sleepTimeInSecs, String text) throws InterruptedException {

        System.out.println("\n\n" + text);

        for (int x = sleepTimeInSecs; x != 0; x--){
            System.out.println("Slept " +  x + " out of:" + sleepTimeInSecs);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    /**
    * Calls mySleep and uses 3 seconds as sleeptime.
    * */
    public static void my3SecSleep(String text) throws InterruptedException {
        mySleep(3, text);
    }

    /**
     * Waits in seconds for target element to be present.
     */
    public static void waitForPresence(WebDriver myDriver, int seconds, By by){
        WebDriverWait wait = new WebDriverWait(myDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}