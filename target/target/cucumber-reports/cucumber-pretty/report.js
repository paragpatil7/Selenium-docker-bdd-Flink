$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/WeatherShopper.feature");
formatter.feature({
  "line": 1,
  "name": "Weather Shopper",
  "description": "",
  "id": "weather-shopper",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "I want to do Weather Shopping",
  "description": "",
  "id": "weather-shopper;i-want-to-do-weather-shopping",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "I am on the website Weather Shopper",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I Select shopping type for Moisturizers or Sunscreens depends on Current temperature",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I Select least expensive two Product and add it to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I verify that the added product are correct",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I fill out payment details \"\u003cemail\u003e\",\"\u003cCard Number\u003e\",\"\u003cExpiry\u003e\",\"\u003cCVV\u003e\" and submit the form",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I verify that the Payment is Successfull",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "weather-shopper;i-want-to-do-weather-shopping;",
  "rows": [
    {
      "cells": [
        "email",
        "Card Number",
        "Expiry",
        "CVV"
      ],
      "line": 13,
      "id": "weather-shopper;i-want-to-do-weather-shopping;;1"
    },
    {
      "cells": [
        "Test@Test.com",
        "4000000000000077",
        "1123",
        "123"
      ],
      "line": 14,
      "id": "weather-shopper;i-want-to-do-weather-shopping;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 75940842900,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "I want to do Weather Shopping",
  "description": "",
  "id": "weather-shopper;i-want-to-do-weather-shopping;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "I am on the website Weather Shopper",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I Select shopping type for Moisturizers or Sunscreens depends on Current temperature",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I Select least expensive two Product and add it to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I verify that the added product are correct",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I fill out payment details \"Test@Test.com\",\"4000000000000077\",\"1123\",\"123\" and submit the form",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I verify that the Payment is Successfull",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherShopperSteps.launchSite()"
});
formatter.result({
  "duration": 37263999000,
  "status": "passed"
});
formatter.match({
  "location": "WeatherShopperSteps.navigateToCurrentTemperature()"
});
formatter.result({
  "duration": 19654263600,
  "status": "passed"
});
formatter.match({
  "location": "WeatherShopperSteps.addProducttoCart()"
});
formatter.result({
  "duration": 84894300300,
  "status": "passed"
});
formatter.match({
  "location": "WeatherShopperSteps.verifyCart()"
});
formatter.result({
  "duration": 4551151800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test@Test.com",
      "offset": 28
    },
    {
      "val": "4000000000000077",
      "offset": 44
    },
    {
      "val": "1123",
      "offset": 63
    },
    {
      "val": "123",
      "offset": 70
    }
  ],
  "location": "WeatherShopperSteps.i_fill_out_payment_details_and_submit_the_form(String,String,String,String)"
});
formatter.result({
  "duration": 5029023900,
  "status": "passed"
});
formatter.match({
  "location": "WeatherShopperSteps.i_verify_that_the_Payment_is_Successfull()"
});
formatter.result({
  "duration": 32818780200,
  "status": "passed"
});
formatter.after({
  "duration": 1252568500,
  "status": "passed"
});
});