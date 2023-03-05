@verifyProducts

  Feature: Verify All Products and product detail page
    Scenario: Verify products and details successfully
      Given I access the automationexercise web page
      When I click on products button
      And I should see all products page and product list is visible
      And I click on view product of first product
      And I should landed to product detail page
      Then I should be presented with details product name, category, price, availability, condition, brand are visible
