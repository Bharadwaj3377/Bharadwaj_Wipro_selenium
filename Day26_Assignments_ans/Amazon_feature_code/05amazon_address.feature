Feature: Change Amazon Account Address
  As a registered Amazon user
  I want to update my delivery address
  So that my orders are shipped to the correct location

  Scenario: User updates account address successfully
    Given User opens Amazon account address page
    When User logs in using email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And User modifies the address with Pincode "500081", Address "123 New Street", Area "MG Road", City "Hyderabad", State "Telangana"
    Then Account address should be updated successfully
