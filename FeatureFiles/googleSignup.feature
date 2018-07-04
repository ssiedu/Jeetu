@google

Feature: create google account

  Background: 
    Given user should be on google home page

  Scenario: verify the elemenets on create event page
    When user enter email id as "manjeetlms@gmail.com"
    And click on the first next button 
    Then verify it is showing the next page with password field
    When usre enter password as "1234@lms"
    And click on the second next button
    Then verify that user is on home page

  