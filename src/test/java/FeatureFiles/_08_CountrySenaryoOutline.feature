# Country menusu create,delete olarak,
# Senaryo outline şeklinde 5 kez çalıştırınız

Feature:  Country Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario Outline: Country with Parameter
    When Create a country name as "<name>" code as "<kod>"
    Then Success message should be displayed
    When Create a country name as "<name>" code as "<kod>"
    Then Already exist message should be displayed
    When user delete name as "<name>"
    Then Success message should be displayed

    Examples:
      | name       | kod     |
      | ismUlk122 | ismKod122 |
#      | ismUlkesi2 | ismKod2 |
#      | ismUlkesi3 | ismKod3 |
#      | ismUlkesi4 | ismKod4 |
#      | ismUlkesi5 | ismKod5 |

