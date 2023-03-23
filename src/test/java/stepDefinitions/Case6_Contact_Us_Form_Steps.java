package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.time.Duration;

public class Case6_Contact_Us_Form_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @When("I click on contact us button")
    public void i_click_on_contact_us_button() {
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
    }
    @And("I should see get in touch page is visible")
    public void i_should_see_get_in_touch_page_is_visible() {
       driver.get("https://www.automationexercise.com/contact_us");
    }
    @And("I enter name {string} email {string} subject {string} and message {string}")
    public void i_enter_name_email_subject_and_message(String name, String email, String subject, String message) {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(message);
    }
    @And("I upload file")
    public void i_upload_file() throws InterruptedException {
        WebElement choosefile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        choosefile.sendKeys("C:\\MavenProjects\\TestCasesAutomation\\src\\main\\resources\\dummyFile.txt");

    }
    @And("I click on submit button")
    public void i_click_on_submit_button() {
     driver.findElement(By.xpath("//input[@name='submit']")).click();
    }
    @And("I click Ok button")
    public void i_click_ok_button() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @And("I should see message {string}")
    public void should_see_message(String message) {
    WebElement successful_message = driver.findElement(By.xpath("//div[@class=\"status alert alert-success\"]"));
    Assert.assertEquals(successful_message.getText(),message);
    }
    @Then("I click home button and navigate to home page successfully")
    public void click_home_button_and_navigate_to_home_page_successfully() {
      driver.findElement(By.xpath("//div[@id='form-section']//span")).click();
      driver.get("https://www.automationexercise.com/");
    }
}
