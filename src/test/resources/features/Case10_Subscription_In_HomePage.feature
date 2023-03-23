@subscriptionHomepage @regression

Feature: Verify Subscription in home page

  Scenario: Subscribing successfully
    Given I access the automationexercise web page
    When I scroll down to footer and see text "SUBSCRIPTION"
    And enter email address "robet@mail.com" in input and click arrow button
    Then should be presented with message "You have been successfully subscribed!"


