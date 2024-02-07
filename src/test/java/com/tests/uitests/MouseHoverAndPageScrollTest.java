package com.tests.uitests;

import com.testauto.commoncode.HelperTools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MouseHoverAndPageScrollTest extends BaseTestClass{


    /**
     * This test verifies that hovering over a menu displays a new popup with other links. This also verifies that
     * the user can scroll down to the webpage to find the target WebElement under test.
     * - Test hovers over Solutions and verifies the page displays two more links.
     * - Test scrolls down to "About Us" then clicks and navigates to "About Us" Page.
     * - Test verifies the presence of "Meet our Leadership" section and scrolls down to it.
     * @throws InterruptedException Exception
     */
    @Test
    void mouseHoverOverTest() throws InterruptedException {

        String testUrl = "https://fidelissecurity.com/";
        String solutionsMenu = "Solutions";
        String halo = "Fidelis Halo";
        String elevate = "Fidelis Elevate";
        int sleepTime = 3;

        driver.get(testUrl);
        HelperTools.waitForPresence(driver, 10, By.linkText(solutionsMenu));

        WebElement solutions = driver.findElement(By.linkText(solutionsMenu));
        Actions hover = new Actions(driver);
        hover.moveToElement(solutions).perform();

        HelperTools.mySleep(sleepTime,"Hover Over Solutions");

        String solXPath = "//*[@id='menu-item-1599']/ul";
        WebElement solSubMenu = driver.findElement(By.xpath(solXPath));
        List<WebElement> subMenu = solSubMenu.findElements(By.tagName("li"));

        // Verify that both sub menus were present.
        Assert.assertTrue(solSubMenu.getText().contains(halo), "Expecting Visible Link: " + halo + ".");
        Assert.assertTrue(solSubMenu.getText().contains(elevate), "Expecting Visible Link: " + elevate + ".");

        WebElement aboutUs = driver.findElement(By.linkText("About Us"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView();", aboutUs);
        HelperTools.mySleep(sleepTime,"About Us Should be in view Now");
        aboutUs.click();

        HelperTools.mySleep(sleepTime,"Clicked About Us");

        // FIXME: Try to improve the locator used here.
        String leadershipXPATH = "//*[@id='content']/div/div[1]/div[6]/div/div/div[2]/div/h2";
        try {
            WebElement meetLeadership = driver.findElement(By.xpath(leadershipXPATH));
            je.executeScript("arguments[0].scrollIntoView();", meetLeadership);
        }
        catch (Exception ex){
            Assert.fail("Meet Our Leadership Panel not Available", ex);
        }

        HelperTools.mySleep(sleepTime, "Leadership now displayed");
    }
}
