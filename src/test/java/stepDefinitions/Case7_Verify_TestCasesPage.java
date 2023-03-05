package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;

public class Case7_Verify_TestCasesPage extends Base_PO {
    WebDriver driver= getDriver();

    @When("I click on test cases button")
    public void i_click_on_test_cases_button() {
      driver.findElement(By.cssSelector(".navbar-nav [href='\\/test_cases']")).click();
    }
    @Then("I should be access the test cases page successfully")
    public void i_should_be_access_the_test_cases_page_successfully() {
        driver.get("https://www.automationexercise.com/test_cases");
    }
}
