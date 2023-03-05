package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Case5_Steps extends Base_PO {
    private WebDriver driver =  getDriver();

    @And("I enter name {string} and already registered email address {string}")
    public void i_enter_name_and_already_registered_email_address(String name, String email) {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[action='\\/signup'] [type='email']")).sendKeys(email);

    }
    @And("Click on signup button")
    public void click_on_signup_button() {
        driver.findElement(By.xpath("//form[@action='/signup']/button[@type='submit']")).click();

    }
    @Then("I should be presented with signup error {string}")
    public void i_should_be_presented_with_signup_error(String error) {
        WebElement unsuccessful_login_error_message = driver.findElement(By.cssSelector("[action] p"));
        Assert.assertEquals(unsuccessful_login_error_message.getText(), error);

    }
}
