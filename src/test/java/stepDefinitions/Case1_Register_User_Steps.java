package stepDefinitions;


import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;


public class Case1_Register_User_Steps extends Base_PO {
    WebDriver driver = DriverFactory.getDriver();

    @And("I should be presented with login page")
    public void i_should_be_presented_with_login_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://www.automationexercise.com/login");
    }
    @Given("I access the automationexercise web page")
    public void i_access_the_automationexercise_web_page() {
        driver.get("https://www.automationexercise.com/");

    }
    @When("I click on signup login button")
    public void i_click_on_signup_login_button() {
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[@href='/login']")).click();

    }
    @Then("I should be presented with New User Signup form")
    public void i_should_be_presented_with_new_user_signup_form() {
        driver.get("https://www.automationexercise.com/login");
    }
    @When("I enter name {} and a unique email-adress {}")
    public void i_enter_name_and_a_unique_email_adress(String name,String uniqueEmail) {
        driver.findElement(By.xpath("//form[@action='/signup']/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//form[@action='/signup']/input[@name='email']")).sendKeys(uniqueEmail);
    }
    @And("I click on Signup button")
    public void i_click_on_signup_button() {
        driver.findElement(By.xpath("//form[@action='/signup']/button[@type='submit']")).click();
    }

    @When("I fill details title name email password birthday")
    public void i_fill_details_title_name_email_password_birthday() throws InterruptedException {

        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("123");
        driver.findElement(By.xpath("//select[@id=\"days\"]/option[@value=\"1\"]")).click();
        driver.findElement(By.xpath("//select[@id=\"months\"]/option[@value=\"2\"]")).click();
        driver.findElement(By.xpath("//select[@id=\"years\"]/option[@value=\"2000\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("osman");
        driver.findElement(By.xpath("//input[@id=\"last_name\"]")).sendKeys("avcu");
        driver.findElement(By.xpath("//input[@id=\"company\"]")).sendKeys("easoft");
        driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("antalya");
        driver.findElement(By.xpath("//select[@id=\"country\"]/option[@value=\"Canada\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"state\"]")).sendKeys("Toronto");
        driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Toronto");
        driver.findElement(By.xpath("//input[@id=\"zipcode\"]")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id=\"mobile_number\"]")).sendKeys("123");

    Thread.sleep(3000);
    }
    @And("I select checkbox sign up for our newsletter")
    public void i_select_checkbox_sign_up_for_our_newsletter() {
        driver.findElement(By.xpath("/html//input[@id='newsletter']")).click();
    }
    @And("I click on create account button")
    public void i_click_on_create_account_button() throws InterruptedException {

       driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();
    }

    @Then("I should be presented message  account created")
    public void i_should_be_presented_message_account_created() {

    }
    @When("I click on continue button")
    public void i_click_on_continue_button() {
        driver.get("https://www.automationexercise.com/account_created");
           driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click();
    }
    @Then("I should see Logged in as username is visible")
    public void i_should_see_logged_in_as_username_is_visible() throws InterruptedException {
        driver.get("https://www.automationexercise.com/");
    }
    @When("I click on Delete account button")
    public void i_click_on_delete_account_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[href='\\/delete_account']")).click();
    }
    @Then("I should be presented with an account deleted message and  click continue button")
    public void i_should_be_presented_with_an_account_deleted_message_and_click_continue_button() throws InterruptedException {

       driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click();

    }


}
