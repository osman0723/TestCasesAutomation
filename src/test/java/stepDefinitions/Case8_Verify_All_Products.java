package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;

public class Case8_Verify_All_Products extends Base_PO {
    private WebDriver driver = getDriver();

    @When("I click on products button")
    public void i_click_on_products_button() {
     driver.findElement(By.xpath("//a[@href='/products']")).click();
    }
    @And("I should see all products page and product list is visible")
    public void i_should_see_all_products_page_and_product_list_is_visible() {
       driver.get("https://www.automationexercise.com/products");
    }
    @And("I click on view product of first product")
    public void i_click_on_view_product_of_first_product() {
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
    }
    @And("I should landed to product detail page")
    public void i_should_landed_to_product_detail_page() {
        driver.get("https://www.automationexercise.com/product_details/1");
    }
    @Then("I should be presented with details product name, category, price, availability, condition, brand are visible")
    public void i_should_be_presented_with_details_product_name_category_price_availability_condition_brand_are_visible() {
       String productname = driver.findElement(By.xpath("//h2[.='Blue Top']")).getText();
       if(productname.trim().isEmpty()) {
           throw new RuntimeException("productname is empty");
       }
        String category = driver.findElement(By.xpath("//p[.='Category: Women > Tops']")).getText();
        if(category.trim().isEmpty()) {
            throw new RuntimeException("category is empty");
        }
        String price = driver.findElement(By.xpath("//span[.='Rs. 500']")).getText();
        if(price.trim().isEmpty()) {
            throw new RuntimeException("price is empty");
        }
        String availability = driver.findElement(By.xpath("//b[.='Availability:']")).getText();
        if(availability.trim().isEmpty()) {
            throw new RuntimeException("availability is empty");
        }
        String brand = driver.findElement(By.xpath("//b[.='Availability:']")).getText();
        if(brand.trim().isEmpty()) {
            throw new RuntimeException("brand is empty");
        }

    }

}
