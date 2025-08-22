Feature: Update Amazon Display Language
  As a registered Amazon shopper
  I want to change the display language
  So that I can browse Amazon in my preferred language

  Scenario: Shopper updates language to Hindi
    Given Shopper visits Amazon site for language update
    When Shopper provides login with email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And Shopper updates the display language
    Then Amazon should show the site in the updated language
