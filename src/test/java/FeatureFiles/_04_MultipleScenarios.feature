Feature: Multi Scenario

  Background: #before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a Country
    And Navigate to country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a CitizenShip
    And Navigate to CitizenShip
    When Create a CitizenShip
    Then Success message should be displayed
