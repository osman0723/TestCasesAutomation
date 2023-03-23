@existingEmail @regression

  Feature: Automation exercise - Existing Email Error

    Scenario: Register User with existing email
  Given I access the automationexercise web page
  When I click on signup login button
  Then I should be presented with New User Signup form
  And I enter name "Joe" and already registered email address "sarah@mail.com"
  And Click on signup button
  Then I should be presented with signup error "Email Address already exist!"
