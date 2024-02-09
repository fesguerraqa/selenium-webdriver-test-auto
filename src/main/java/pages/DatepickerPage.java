package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatepickerPage {

    private final WebDriver driver;
    private static final String datepickerUrl = "https://demo.automationtesting.in/Datepicker.html";

    private static final String dateInputBoxXpath = "//*[@id='datepicker2']";

    private int year;
    private int month;
    private int day;

    private DatepickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public static DatepickerPage getDatepickerPage(WebDriver driver){
        return new DatepickerPage(driver);
    }

    public void goToDatepickerPage(){
        this.driver.get(datepickerUrl);
    }

    public String getPageTitle(){
        return this.driver.getTitle();
    }

    /**
     * Exposes the Calendar Pop-up. Does not input anything at this point.
     */
    public void startDateInput(){
        WebElement dateInputBox = driver.findElement(By.xpath(dateInputBoxXpath));
        dateInputBox.click();
    }

    /**
     * Clicks the Year Dropdown list to expose the available years. Does not input anything at this point.
     */
    private void showYearOptions(){
        WebElement datePopupYearSelection = driver.findElement(By.xpath(
                "//select[@title='Change the year']"));
        datePopupYearSelection.click();
    }

    /**
     * Calls showYearOptions() to expose the list of years in the Dropdown List. Then this picks the target year
     * under test
     * @param testYear year under test
     */
    public void pickYear(int testYear){
        this.year = testYear;

        showYearOptions();

        WebElement year = driver.findElement(By.xpath(
                "//select[@title='Change the year']/option[contains(@value," + testYear + ")]"));
        year.click();
    }

    /**
     * Clicks the Month Dropdown List to expose the Months available. Does not input anything at this point.
     */
    private void showMonthOptions(){

        WebElement datePopupMonths = driver.findElement(By.xpath(
                "//select[@title='Change the month']"));
        datePopupMonths.click();
    }

    /**
     * Calls showMonthOptions() to expose the available Months. Then this selects the target month under test.
     * @param testMonth month under test
     */
    public void pickMonth(int testMonth){
        this.month = testMonth;

        showMonthOptions();

        WebElement datePickMonth = driver.findElement(By.xpath(
                "//select[@title='Change the month']/option[@value='" + this.month + "/"
                        + this.year + "']"));
        datePickMonth.click();
    }

    /**
     * Selects the target date.
     * @param testDay day under test
     */
    public void pickDay(int testDay){

        this.day = testDay;

        String dateString = this.day + ", " + this.year;
        WebElement datePickDay = driver.findElement(By.xpath("//*[contains(@title,'" + dateString
                + "')]"));
        datePickDay.click();
    }

    /**
     * Returns the date on the date input box.
     * @return current date on date input box.
     */
    public String getFinalDate(){
        return this.driver.findElement(By.xpath(dateInputBoxXpath)).getAttribute("value");
    }
}
