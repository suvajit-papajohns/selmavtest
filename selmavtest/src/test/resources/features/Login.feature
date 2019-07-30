#Author: suvajitc@gmail.com
@wip
Feature: Verifying Login functionality 
  I want to verify login functionality of Mercury Tours site

	Background: User is in Mercury Tours home page
		Given I am on the "Welcome: Mercury Tours" page of "http://www.newtours.demoaut.com/"
		Then I should see "MercuryTours" image in the page
		And I can see the "User Name:" and "Password:" fields
    
  @wip
  Scenario: Verify Valid Login of Mercury Tours site
    When I enter username as "demo" and password as "demo"
    And I click the "Sign-In" button
    Then I am signed in and view the "Find a Flight" page
    And I see the "Flight Details" form


  @wip
  Scenario Outline: Failed Login using wrong credentials
    When I fill in username with <username>
    And I fill in password as <password>
    And I click the "Sign-In" button 
    Then I am redirected to <pagetitle> page

    Examples: 
      | username  | password | pagetitle  |
      | pqr       | pqr      | Sign-on    |
