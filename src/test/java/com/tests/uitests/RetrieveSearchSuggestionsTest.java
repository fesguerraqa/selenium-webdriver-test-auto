package com.tests.uitests;

import com.testauto.commoncode.HelperTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RetrieveSearchSuggestionsTest extends BaseTestClass{

    /**
     * This test verifies that a user can put a search string in google and a target string will be displayed
     * on the Recommended Searches.
     *  - The test verifies that a user can input some keys to google's input box. The test verifies for a successful
     *  input.
     *  - The test captures all the Recommended Searches. Test then goes through the results and verifies a target
     *  string that is expected to be Recommended Searches by google.
     */
    @Test
    void retrieveAjaxSearchSuggestions() throws InterruptedException {

        /*
         * In my imagination, maybe Panarai wants google to suggest "Luminor" when a user searches for Panerai.
         **/
        String expectedStrSearch = "Panerai";
        String expectedSugggestedString = "Luminor";

        driver.get("https://www.google.com");

        WebElement googleInputBox = driver.findElement(By.xpath(HelperTools.googleInputBoxXPathStr));
        googleInputBox.sendKeys(expectedStrSearch);

        HelperTools.my3SecSleep("Searched for " + expectedStrSearch);

        String actualSearchString = googleInputBox.getAttribute("value");
        Assert.assertEquals(actualSearchString, expectedStrSearch);

        HelperTools.waitForPresence(driver, 10, By.xpath(HelperTools.googleRecommendedSearchesXPathStr));

        WebElement recommendedSearches = driver.findElement(By.xpath(HelperTools.googleRecommendedSearchesXPathStr));
        List<WebElement> searchRows = recommendedSearches.findElements(By.tagName("li"));

        boolean containsLuminor = false;

        for (WebElement we : searchRows) {

            HelperTools.mySleep(3,"Retrieved: " + we.getText());

            if (we.getText().contains(expectedSugggestedString)){
                containsLuminor = true;
                break;
            }
        }

        Assert.assertTrue(containsLuminor, "Did not find expected suggestion of string: "
                + expectedSugggestedString + ".");

        HelperTools.mySleep(10,"End of the test");
    }
}
