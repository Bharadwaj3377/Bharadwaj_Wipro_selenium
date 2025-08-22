Feature: Search Product
  As a user
  I want to search multiple items on Amazon
  So that I can compare and choose

  Scenario Outline: Search multiple items
    Given User is logged into Amazon for search
    When User searches for "<item>"
    Then Search results for "<item>" should be displayed

    Examples:
      | item       |
      | headphones |
      | mobiles    |
      | books      |
