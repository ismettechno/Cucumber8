#Senaryo: Nationality menusunde gelen ilk 10 verinin DB deki ile
#DB deki data ile aynı olup olmadığını kontrol ediniz.

Feature:  Testing JDBC Nationality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Nationality testing with JDBC

    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | nationalities |
    Then Send The Query the Database "select ad from nationality limit 10" and control match
