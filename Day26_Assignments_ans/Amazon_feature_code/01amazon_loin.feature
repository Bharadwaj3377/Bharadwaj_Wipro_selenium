Feature: Amazon Login
  As a user
  I want to login to Amazon
  So that I can access my account

  Scenario: Valid Login
    Given User is on Amazon login page
    When User enters email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And User clicks on login button
    Then User should be logged in successfully
