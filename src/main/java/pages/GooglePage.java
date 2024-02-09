package pages;

import helper.HelperTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    private final WebDriver driver;
    private static final String googleUrl = "https://www.google.com";

    /**
     * Putting the google input box here since I foresee there will be a lot of text examples
     * that would want to use the google search engine.
     */
    private static final String inputTxtBoxXpath = "//textarea[@id='APjFqb']";

    /**
     * XPath string for the list of Recommended Searches when a user inputs a string into
     * the google input box.
     */
    private static final String recommendedSearchListXpath = "//*[@id='Alh6id']//ul[@role='listbox']";

    private GooglePage(WebDriver driver){

        this.driver = driver;
    }

    public static GooglePage getGooglePage(WebDriver driver){

        return new GooglePage(driver);
    }

    public void goToGoogle(){
        this.driver.get(googleUrl);
    }

    public WebElement getInputBox(){
        return driver.findElement(By.xpath(inputTxtBoxXpath));
    }

    public List<WebElement> getRecommendedSearchStrings(){
        waitForRecommendedSearchList();
        WebElement recommendedSearches = driver.findElement(By.xpath(recommendedSearchListXpath));
        return recommendedSearches.findElements(By.tagName("li"));
    }

    private void waitForRecommendedSearchList(){

        try {
            HelperTools.waitForPresence(driver, 10, By.xpath(recommendedSearchListXpath));
        }
        catch (Exception ex) {
            System.out.println("Did not see Recommended Search Strings: " + ex);

        }
    }
}
