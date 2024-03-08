package com.tests.uitests;

import base.BaseTestClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.W3SchoolsPage;

public class DragAndDropTest extends BaseTestClass {

    /***
     * NOT an actual test but a good exercise in doing a drag and drop via Selenium.
     * @throws InterruptedException
     */
    @Test
    void dragAndDropTest() throws InterruptedException {

        W3SchoolsPage dragAndDrop =  new W3SchoolsPage(driver);

        // TODO: Noticed that the page looks like is successfully loaded but it is really not done yet. The test seems
        //  to pause in this part of the code. Maybe as an improvement to have a timeout to continue after 5-7 seconds
        //  of waiting.
        dragAndDrop.goToW3SchoolsHtmlDragAndDrop();;

        dragAndDrop.focusOnIframe();

        WebElement target = dragAndDrop.getW3SchoolsTarget();
        WebElement source = dragAndDrop.getW3SchoolsLogo();

        Actions action = new Actions(driver);
        action.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
    }
}