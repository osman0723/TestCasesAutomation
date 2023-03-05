@contactus

  Feature: Contact Us Form

    Scenario: Submin an contact us form successfully
      Given I access the automationexercise web page
      When I click on contact us button
      And I should see get in touch page is visible
      And I enter name "ahmet" email "ahmet@mail.com" subject "an complaint" and message "I didnt like the dress"
      And I upload file
      And I click on submit button
      And I click Ok button
      And I should see message "Success! Your details have been submitted successfully."
      Then I click home button and navigate to home page successfully



