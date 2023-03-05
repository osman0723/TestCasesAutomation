@login @regression

Feature: Login User

  Background:
    Given I access the automationexercise web page
    When I click on signup login button
    And I should be presented with login page

  Scenario: Login User with correct email and password
    And I enter correct email address "osman@mail.com" and password 123
    And I click on login button
    And I should see Logged in as username is visible
    And I click on Delete account buttonlogin
    Then I should be presented with an account deleted is visible

    @smoke
  Scenario: Login User with incorrect email and password
    And I enter incorrect email address "ali@mail.com" and password 321
    And I click on login button
    Then  I should be presented with error "Your email or password is incorrect!"

