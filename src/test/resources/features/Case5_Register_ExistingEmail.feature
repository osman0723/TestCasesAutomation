@existingEmail

  Feature: Automation exercise - Existing Email Error

    Scenario: Register User with existing email
  Given I access the automationexercise web page
  When I click on signup login button
  Then I should be presented with New User Signup form
  And I enter name "osman" and already registered email address "osman@mail.com"
  And Click on signup button
  Then I should be presented with signup error "Email Address already exist!"
