Feature: Update Amazon Shopping Country
  As a registered Amazon shopper
  I want to change my shopping country
  So that I can view products available in that region

  Scenario: Shopper updates country to United States
    Given Shopper navigates to Amazon site for country change
    When Shopper signs in using email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And Shopper updates the shopping country
    Then Amazon should display items from the selected country
