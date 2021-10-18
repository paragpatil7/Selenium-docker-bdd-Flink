Feature: Weather Shopper

  Scenario Outline: I want to do Weather Shopping 
    Given I am on the website Weather Shopper
    And   I Select shopping type for Moisturizers or Sunscreens depends on Current temperature 
    And   I Select least expensive two Product and add it to the cart
    And 	I verify that the added product are correct
    And   I fill out payment details "<email>","<Card Number>","<Expiry>","<CVV>" and submit the form
   Then   I verify that the Payment is Successfull
   

  Examples:
   | email  					   | Card Number       | Expiry   | CVV   |
   | Test@Test.com       | 4000000000000077   | 1123    | 123   |
   