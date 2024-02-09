package base;

import static factory.DriverFactory.getChromeDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestClass {

    protected static WebDriver driver;

    @BeforeTest()
    public void setup(){
        driver = getChromeDriver();
    }



    @AfterTest()
    public void cleanup(){
        driver.close();
    }

}
