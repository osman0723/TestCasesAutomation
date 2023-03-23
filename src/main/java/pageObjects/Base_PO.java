package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
        }
        public WebDriver getDriver(){

        return DriverFactory.getDriver();
    }



}
