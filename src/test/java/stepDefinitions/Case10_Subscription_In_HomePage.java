package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Case10_Subscription_In_HomePage extends Base_PO {
    private WebDriver driver = getDriver();

    @When("I scroll down to footer and see text {string}")
    public void i_scroll_down_to_footer_and_see_text(String text) {
     boolean subscription = driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed();
     if(! subscription){
         throw new RuntimeException("Element not found");
     }
    }
    @And("enter email address {string} in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button(String email) {
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();
    }
    @Then("should be presented with message {string}")
    public void should_be_presented_with_message(String text) {
      String message =  driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText();
        Assert.assertEquals(message,text);
    }

}
