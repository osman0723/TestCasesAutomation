@searchProduct @regression

Feature: Search Product

  Scenario: Searching a specific product successfully

    Given I access the automationexercise web page
    When I click on products button
    And I should  navigate to all products page successfully
    And I enter product name "men tshirt" in search input and click search button
    And I should see title "SEARCHED PRODUCTS" is visible
    Then I should see all the products related to search are visible
