Feature: Amazon Add to Cart Functionality
  As a registered Amazon user
  I want to add a product to my cart
  And verify it in the cart
  And be able to delete it

  Scenario: Add a product to cart, go to cart, and delete it
    Given User opens Amazon website to addto
    When User logs in with email "bharadwaj333.achimsetty@gmail.com" and password "Bharadwaj333@"
    And User searches for product "Honeywell New Launched Moxie V20 Bluetooth v5.4 On-Ear Headphones with Mic, ENC, 25H Playback, Deep Bass, IPX4, Aux, Stereo Sound, 40ms Low Latency Gaming Mode, Padded Cushion"
    And User adds the first product to cart
    And User goes to the cart
    Then User deletes the item from the cart
    Then Close the browser
