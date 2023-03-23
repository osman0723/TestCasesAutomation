@register @regression

Feature: Automation exercise - Register User Page

  Scenario: Registering new User Successfully
    Given I access the automationexercise web page
    When I click on signup login button
    Then I should be presented with New User Signup form

    When I enter name osman and a unique email-adress osman@mail.com
    And I click on Signup button
    And I fill details title name email password birthday
    And I select checkbox sign up for our newsletter
    And I click on create account button
    Then  I should be presented message  account created

    When I click on continue button
    Then I should see Logged in as username is visible

    When I click on Delete account button
    Then I should be presented with an account deleted message and  click continue button
