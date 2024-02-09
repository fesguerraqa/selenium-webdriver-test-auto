package com.tests.uitests;

import base.BaseTestClass;
import helper.HelperTools;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.util.List;

public class RetrieveSearchSuggestionsTest extends BaseTestClass {

    /**
     * This test verifies that a user can put a search string in google and a target string will be displayed
     * on the Recommended Searches.
     *  - The test verifies that a user can input some keys to google's input box. The test verifies for a successful
     *  input.
     *  - The test captures all the Recommended Searches. Test then goes through the results and verifies a target
     *  string that is expected to be Recommended Searches by google.
     * @throws InterruptedException Interrupted Exception
     */
    @Test
    void retrieveAjaxSearchSuggestions() throws InterruptedException {

        /*
         * In my imagination, maybe Panerai wants google to suggest "Luminor" when a user searches for Panerai.
         **/
        String expectedStrSearch = "Panerai";
        String expectedSugggestedString = "Luminor";

        GooglePage googlePage = GooglePage.getGooglePage(driver);
        googlePage.goToGoogle();

        // WebElement is still given to the user to be able to manipulate.
        WebElement inputBox = googlePage.getInputBox();
        inputBox.sendKeys(expectedStrSearch);

        HelperTools.my3SecSleep("Searched for :" + expectedStrSearch);

        String actualSearchString = inputBox.getAttribute("value");
        Assert.assertEquals(actualSearchString, expectedStrSearch);

        List<WebElement> searchRows = googlePage.getRecommendedSearchStrings();

        boolean foundExpectedRecStr = false;

        for (WebElement we : searchRows) {

            HelperTools.mySleep(3,"Retrieved from list: " + we.getText());

            if (we.getText().contains(expectedSugggestedString)){
                foundExpectedRecStr = true;
                HelperTools.quickPrint("Found: " + expectedSugggestedString + " in " + "'" + we.getText() + "'");
                break; // As long as we find a match we don't care for the other captures.
            }
        }

        Assert.assertTrue(foundExpectedRecStr, "Did not find expected suggestion of string: "
                + expectedSugggestedString + ".");

        HelperTools.mySleep(5,"End of the test");
    }
}