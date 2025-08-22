Feature: Shop by Category on Amazon
  As a registered Amazon user
  I want to select the Books category and search for Harry Potter
  So that I can view books related to Harry Potter

  Scenario: Shopper selects Books category and searches for Harry Potter
    Given Shopper opens Amazon site for category shopping
    When Shopper logs in with email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And Shopper selects Books category and searches for Harry Potter
    Then Harry Potter books should be displayed
