package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Case9_Seatch_Product_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @And("I should  navigate to all products page successfully")
    public void i_should_navigate_to_all_products_page_successfully() {
      driver.get("https://www.automationexercise.com/products");
    }
    @And("I enter product name {string} in search input and click search button")
    public void i_enter_product_name_in_search_input_and_click_search_button(String productName) {
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(productName);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
    }
    @And("I should see title {string} is visible")
    public void i_should_see_tag_searched_product_is_visible(String title) {
       String tag = driver.findElement(By.xpath("//h2[.='Searched Products']")).getText();
        Assert.assertEquals(tag,title);
    }
    @Then("I should see all the products related to search are visible")
    public void i_should_see_all_the_products_related_to_search_are_visible() {
      boolean display =  driver.findElement(By.xpath("//div[@class='productinfo text-center']")).isDisplayed();
      if (! display){
          throw  new RuntimeException("Product not available");
      }
    }

}
