package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;



public class LoginUser_Steps extends Base_PO {
    private WebDriver driver= getDriver();

    @And("I enter correct email address {string} and password {}")
    // You need to Signup again if any problem occurs as account might be deleted (username and password)
    public void i_enter_correct_email_address_and_password(String email, String password) throws InterruptedException {
        Thread.sleep(3000);
    driver.findElement(By.xpath("//form[@action='/login']/input[@name='email']")).sendKeys(email);
        Thread.sleep(1000);
     driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

    }
    @And("I click on Delete account buttonlogin")
    public void i_click_on_delete_account_buttonlogin() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
    }
    @And("I click on login button")
    public void i_click_on_login_button() {
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

    }

    @Then("I should be presented with an account deleted is visible")
    public void i_should_be_presented_with_an_account_deleted_is_visible() {
        driver.get("https://automationexercise.com/delete_account");
    }

    @And("I enter incorrect email address {string} and password {}")
    public void i_enter_incorrect_email_address_and_password(String email, String password) throws InterruptedException {

        driver.findElement(By.xpath("//form[@action='/login']/input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

    }

    @Then("I should be presented with error {string}")
    public void i_should_be_presented_with_error(String error) {
        WebElement unsuccessful_login_error_message = driver.findElement(By.cssSelector("[action] p"));
        Assert.assertEquals(unsuccessful_login_error_message.getText(), error);
    }
}
