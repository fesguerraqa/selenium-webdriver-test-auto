package com.tests.uitests;

import base.BaseTestClass;
import helper.HelperTools;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DatepickerPage;

public class InputDateTest extends BaseTestClass {

    /*
     *  This test verifies that we can select a target date from a calendar.
     *  Verifies:
     *   - Target webpage has correct target Title.
     *   - User be able to navigate on a Calendar Pop-up
     *   - Target input box will have correct target Date.
     * */
    @Test
    void inputDateTest() throws InterruptedException {

        int targetYear = 2026;
        int targetMonth = 11;
        int targetDay = 28;

        String webpageTitle = "Datepicker";
        int sleepTimeInSecs = 2;

        DatepickerPage datepicker = DatepickerPage.getDatepickerPage(driver);
        datepicker.goToDatepickerPage();

        HelperTools.mySleep(sleepTimeInSecs,"Visual Inspection of Loaded Page.");

        // Verify here that page title is expected.
        Assert.assertEquals(datepicker.getPageTitle(), webpageTitle);

        datepicker.startDateInput();
        HelperTools.mySleep(sleepTimeInSecs,"Exposing Calendar Pop-up");

        // NOTE: There is some dependency with the sequence of picking the year, month and day in sequence.
        // Maybe its more ideal to have all three values be fed in one method.
        datepicker.pickYear(targetYear);
        HelperTools.mySleep(sleepTimeInSecs,"Selecting Year: " + targetYear + ".");

        datepicker.pickMonth(targetMonth);
        HelperTools.mySleep(sleepTimeInSecs, "Should now have " + targetMonth +"/" + targetYear + " selected.");

        datepicker.pickDay(targetDay);
        HelperTools.mySleep(sleepTimeInSecs, "Should now have " + targetMonth+ "/" + targetDay + "/"
                 + targetYear + " selected.");

        String finalDateTest = datepicker.getFinalDate();

        // Verify that the correct target date is displayed.
        Assert.assertEquals(finalDateTest, formatDate(targetYear, targetMonth, targetDay));
    }

    /**
     * Simple method to address verification of "09" vs "9". The Webpage displays single digit numbers with a "0"
     * in front.
     * @param year
     * @param month
     * @param day
     * @return
     */
    private String formatDate(int year, int month, int day){

        String finalMonth = String.valueOf(month);
        String finalDay = String.valueOf(day);

        if (month < 10){
            finalMonth = "0"+month;
        }
        if (day < 10){
            finalDay = "0"+day;
        }

        return finalMonth + "/" + finalDay +"/" + year;
    }
}