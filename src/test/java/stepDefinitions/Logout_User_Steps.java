package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;

public class Logout_User_Steps extends Base_PO {
    private WebDriver driver= getDriver();

    @And("I should be presented with login to user account page")
    public void i_should_be_presented_with_login_to_user_account_page() {
        driver.get("https://www.automationexercise.com/login");
    }

    @And("I should be logged in as username")
    public void i_should_be_logged_in_as_username() {
        driver.get("https://www.automationexercise.com/login");
    }
    @And("I click on logout button")
    public void i_click_on_logout_button() {
       driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }
    @Then("I should be navigated login page")
    public void i_should_be_navigated_login_page() {
        driver.get("https://www.automationexercise.com/login");
    }
}
