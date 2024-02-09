package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelperTools {

    /**
     * This is a convenience method to aid visually inspecting how the test is proceeding.
     * WARNING: Excessive usage can slow down a test's runtime.
     * @param sleepTimeInSecs Time to sleep in seconds.
     * @param text Target string to be printed in the console.
     * @throws InterruptedException Interrupted Exception
     */
    public static void mySleep(int sleepTimeInSecs, String text) throws InterruptedException {

        System.out.println("\n\n" + text);

        for (int x = sleepTimeInSecs; x != 0; x--){
            System.out.println("Slept " +  x + " out of:" + sleepTimeInSecs);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    /**
     * Calls mySleep and uses 3 seconds as sleep time.
     * @param text Target string to be printed
     * @throws InterruptedException Interrupted Exception
     */
    public static void my3SecSleep(String text) throws InterruptedException {
        mySleep(3, text);
    }

    /**
     * Waits in seconds for target element to be present.
     * @param myDriver WebDriver under test
     * @param seconds amount of wait time in seconds
     * @param by By object.
     */
    public static void waitForPresence(WebDriver myDriver, int seconds, By by){
        WebDriverWait wait = new WebDriverWait(myDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Quick command to print text on console.
     * @param s string to be printed on console.
     */
    public static void quickPrint(String s) {
        System.out.println(s);
    }

    /**
     * UNDER CONSTRUCTION!
     * @param we WebElement Under Test
     * @param je JavascriptExecutor Under Test
     * @throws InterruptedException Exception
     */
    public static void slowScroll(WebElement we, JavascriptExecutor je) throws InterruptedException {
        while (true){
            je.executeScript("window.scrollBy(0,550)", we);

            if (we.isEnabled()){

                mySleep(30, "Found it!");
                break;
            }

        }
    }
}