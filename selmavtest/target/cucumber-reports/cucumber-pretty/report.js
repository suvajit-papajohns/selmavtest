$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: suvajitc@gmail.com"
    }
  ],
  "line": 3,
  "name": "Verifying Login functionality",
  "description": "I want to verify login functionality of Mercury Tours site",
  "id": "verifying-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@wip"
    }
  ]
});
formatter.background({
  "line": 6,
  "name": "User is in Mercury Tours home page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on the \"Welcome: Mercury Tours\" page of \"http://www.newtours.demoaut.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should see \"MercuryTours\" image in the page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I can see the \"User Name:\" and \"Password:\" fields",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Welcome: Mercury Tours",
      "offset": 13
    },
    {
      "val": "http://www.newtours.demoaut.com/",
      "offset": 46
    }
  ],
  "location": "LoginStepDefs.i_am_on_the_homepage_of_url(String,String)"
});
formatter.result({
  "duration": 6357473153,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MercuryTours",
      "offset": 14
    }
  ],
  "location": "LoginStepDefs.i_should_see_image_in_the_page(String)"
});
formatter.result({
  "duration": 2335349607,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User Name:",
      "offset": 15
    },
    {
      "val": "Password:",
      "offset": 32
    }
  ],
  "location": "LoginStepDefs.i_can_see_the_and_fields(String,String)"
});
formatter.result({
  "duration": 5562710687,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify Valid Login of Mercury Tours site",
  "description": "",
  "id": "verifying-login-functionality;verify-valid-login-of-mercury-tours-site",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@wip"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I enter username as \"demo\" and password as \"demo\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I click the \"Sign-In\" button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I am signed in and view the \"Find a Flight\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I see the \"Flight Details\" form",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "demo",
      "offset": 21
    },
    {
      "val": "demo",
      "offset": 44
    }
  ],
  "location": "LoginStepDefs.i_enter_username_as_and_password_as(String,String)"
});
formatter.result({
  "duration": 8043930921,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign-In",
      "offset": 13
    }
  ],
  "location": "LoginStepDefs.i_click_the_button(String)"
});
formatter.result({
  "duration": 8550504239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Find a Flight",
      "offset": 29
    }
  ],
  "location": "LoginStepDefs.i_am_signed_in_and_view_the_page(String)"
});
formatter.result({
  "duration": 209980077,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Flight Details",
      "offset": 11
    }
  ],
  "location": "LoginStepDefs.i_see_the_form(String)"
});
formatter.result({
  "duration": 820997495,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 20,
  "name": "Failed Login using wrong credentials",
  "description": "",
  "id": "verifying-login-functionality;failed-login-using-wrong-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@wip"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I fill in username with \u003cusername\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I fill in password as \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click the \"Sign-In\" button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I am redirected to \u003cpagetitle\u003e page",
  "keyword": "Then "
});
formatter.examples({
  "line": 26,
  "name": "",
  "description": "",
  "id": "verifying-login-functionality;failed-login-using-wrong-credentials;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "pagetitle"
      ],
      "line": 27,
      "id": "verifying-login-functionality;failed-login-using-wrong-credentials;;1"
    },
    {
      "cells": [
        "pqr",
        "pqr",
        "Sign-on"
      ],
      "line": 28,
      "id": "verifying-login-functionality;failed-login-using-wrong-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 6,
  "name": "User is in Mercury Tours home page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on the \"Welcome: Mercury Tours\" page of \"http://www.newtours.demoaut.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should see \"MercuryTours\" image in the page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I can see the \"User Name:\" and \"Password:\" fields",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Welcome: Mercury Tours",
      "offset": 13
    },
    {
      "val": "http://www.newtours.demoaut.com/",
      "offset": 46
    }
  ],
  "location": "LoginStepDefs.i_am_on_the_homepage_of_url(String,String)"
});
formatter.result({
  "duration": 5767210277,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MercuryTours",
      "offset": 14
    }
  ],
  "location": "LoginStepDefs.i_should_see_image_in_the_page(String)"
});
formatter.result({
  "duration": 1766520337,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User Name:",
      "offset": 15
    },
    {
      "val": "Password:",
      "offset": 32
    }
  ],
  "location": "LoginStepDefs.i_can_see_the_and_fields(String,String)"
});
formatter.result({
  "duration": 3020511977,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Failed Login using wrong credentials",
  "description": "",
  "id": "verifying-login-functionality;failed-login-using-wrong-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@wip"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I fill in username with pqr",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I fill in password as pqr",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click the \"Sign-In\" button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I am redirected to Sign-on page",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.i_fill_in_username_with_pqr()"
});
formatter.result({
  "duration": 3616120293,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.i_fill_in_password_as_pqr()"
});
formatter.result({
  "duration": 5402969561,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign-In",
      "offset": 13
    }
  ],
  "location": "LoginStepDefs.i_click_the_button(String)"
});
formatter.result({
  "duration": 5746912067,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.i_am_redirected_to_Sign_on_page()"
});
formatter.result({
  "duration": 241078612,
  "status": "passed"
});
});;