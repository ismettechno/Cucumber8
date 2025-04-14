Feature:  Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip

  Scenario Outline: Create a Citizenship with parameter
    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Success message should be displayed

    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Already exist message should be displayed

    When user delete name as "<name>"
    Then Success message should be displayed

    Examples:
      | name       | shortName |
      | ismet1CS11 | ics1kod11 |
      | ismet1CS12 | ics1kod12 |
      | ismet1CS13 | ics1kod13 |
      | ismet1CS14 | ics1kod14 |
      | ismet1CS15 | ics1kod15 |

         #  dataProvider (TestNG için), Senaryo Outline (cucumber)
         #  görevi verilen her değer için, tüm senayo çalışır