Feature: Browse Amazon Today's Deals
  As a registered Amazon shopper
  I want to view Today's Deals
  So that I can explore discounted products

  Scenario: Shopper navigates to Today's Deals section
    Given Shopper visits Amazon site to explore deals
    When Shopper logs in with credentials "bharadwaj333.achimsetty@gmail.com" and "Bharadwaj333@"
    And Shopper opens Today's Deals page
    Then Shopper should be able to see the deals section
