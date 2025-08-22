Feature: Change Amazon Account Name
  As a registered Amazon user
  I want to update my account name
  So that my profile shows the new name

  Scenario: User updates account name successfully
    Given User navigates to Amazon account settings
    When User signs in with credentials "bharadwaj333.achimsetty@gmail.com" and "Bharadwaj333@"
    And User updates the account name to "Bharadwaj Achimsetty"
    Then Account name should be updated successfully
