# CitizenShip fonksiyonlarını 5 farklı değer için çalıştırınız

Feature: DataTable-Senaryo Outline Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: CitizenShip Functionality

    And Click on the Element LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name>      |
      | shortName | <shortName> |

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | <name> |

    Examples:
      | name        | shortName |
      | ismet21CS11 | ics21kod  |
      | ismet21CS12 | ics22kod  |
      | ismet21CS13 | ics23kod  |
      | ismet21CS14 | ics24kod  |
      | ismet21CS15 | ics25kod  |





















