package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3SchoolsPage {

    private final WebDriver driver;
    private final String W3SCHOOLS_HtmlDragAndDrop_URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop";

    private final String w3schoolsLogoXpath = "//*[@id='drag1']";

    private final String w3SchoolsTargetXpath = "//*[@id='div1']";

    private final String pageIframe = "//*[@id='iframeResult']";

    public W3SchoolsPage(WebDriver driver){

        this.driver = driver;
    }

    public static W3SchoolsPage getW3SchoolsPage(WebDriver driver){

        return new W3SchoolsPage(driver);
    }

    public void goToW3SchoolsHtmlDragAndDrop(){

        this.driver.get(W3SCHOOLS_HtmlDragAndDrop_URL);
    }

    /***
     * Returns the WebElement Logo that we use to drag and drop to.
     * @return
     */
    public WebElement getW3SchoolsLogo(){

        return driver.findElement(By.xpath(w3schoolsLogoXpath));
    }

    /**
     * Returns the rectangular area where the logo is dropped in.
     * @return
     */
    public WebElement getW3SchoolsTarget(){

        return driver.findElement(By.xpath(w3SchoolsTargetXpath));
    }

    /**
     * Put the iFrame to focus so that we can identify the source( getW3SchoolsLogo() )
     * and target( getW3SchoolsTarget() ) WebElements
     */
    public void focusOnIframe() {
        WebElement iframe = driver.findElement(By.xpath(pageIframe));
        driver.switchTo().frame(iframe);
    }
}
