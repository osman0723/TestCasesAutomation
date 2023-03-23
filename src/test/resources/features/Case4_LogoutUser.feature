@logout @regression

  Feature: Automation exercise - User Logout

    Scenario: Logging out user successfully
      Given I access the automationexercise web page
      When I click on signup login button
      And I should be presented with login to user account page
      And I enter correct email address "sarah@mail.com" and password 123
      And I click on login button
      And I should be logged in as username
      And I click on logout button
      Then I should be navigated login page
