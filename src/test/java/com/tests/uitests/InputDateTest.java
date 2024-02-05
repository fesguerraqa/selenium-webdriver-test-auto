package com.tests.uitests;


import com.testauto.commoncode.HelperTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputDateTest extends BaseTestClass{

    /*
     *  This test verifies that we can select a target date from a calendar.
     *  Verifies:
     *   - Target webpage has correct target Title.
     *   - Target input box will have correct target Date.
     *
     * */
    @Test
    void inputDateTest() throws InterruptedException {

        /*
         * We will use a fixed target test date for simplicity.
         * NEED to change targetDateString if any of the target year, month or day were changed.
         * */
        int targetYear = 2021;
        int targetMonth = 11;
        int targetDay = 18;
        String targetDateString = "Select Thursday, Nov 18, 2021";

        String testUrl = "https://demo.automationtesting.in/Datepicker.html";
        String webpageTitle = "Datepicker";
        int sleepTimeInSecs = 2;

        driver.get(testUrl);

        HelperTools.mySleep(sleepTimeInSecs,"Visual Inspection of Loaded Page.");

        Assert.assertEquals(driver.getTitle(), webpageTitle);

        /*
         * Expose the calendar pop-up
         *
         * */
        WebElement dateInputBox = driver.findElement(By.xpath("//*[@id='datepicker2']"));
        dateInputBox.click();

        HelperTools.mySleep(sleepTimeInSecs,"Exposing Calendar Pop-up");

        /*
         * Expose the list of years that can be selected.
         *
         * */
        WebElement datePopupYearSelection = driver.findElement(By.xpath(
                "//select[@title='Change the year']"));
        datePopupYearSelection.click();

        HelperTools.mySleep(sleepTimeInSecs,"Before Selecting Year: " + targetYear + ".");

        /*
         * Select the target test year.
         * Good example how to use "contains" in an xpath
         * */
        WebElement datePickYear = driver.findElement(By.xpath(
                "//select[@title='Change the year']/option[contains(@value," + targetYear + ")]"));
        datePickYear.click();

        HelperTools.mySleep(sleepTimeInSecs, "Should now have " + targetYear + " selected.");

        /*
         * Expose target test months.
         *
         * */
        WebElement datePopupMonths = driver.findElement(By.xpath(
                "//select[@title='Change the month']"));
        datePopupMonths.click();

        HelperTools.mySleep(sleepTimeInSecs, "Exposing the months selectable");

        /*
         * Select the target test month.
         *
         * */
        WebElement datePickMonth = driver.findElement(By.xpath(
                "//select[@title='Change the month']/option[@value='" + targetMonth + "/"
                        + targetYear + "']"));
        datePickMonth.click();

        HelperTools.mySleep(sleepTimeInSecs, "Should now have " + targetMonth +"/" + targetYear + " selected.");

        /*
         * Select the target test day.
         *
         * */
        WebElement datePickDay = driver.findElement(By.xpath("//a[@title='" + targetDateString + "']"));
        datePickDay.click();

        HelperTools.mySleep(sleepTimeInSecs, "Should now have " + targetDay+ "/" + targetMonth + "/"
                 + targetYear + " selected.");

        String finalDateTest = dateInputBox.getAttribute("value");

        Assert.assertEquals(targetMonth + "/" + targetDay + "/" + targetYear, finalDateTest);
    }
}
