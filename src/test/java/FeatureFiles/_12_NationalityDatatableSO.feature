# Nationality fonksiyonlarını 5 farklı değer için çalıştırıp test ediniz

Feature: Nationality Functionality Datatable - Senaryo Outline

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Nationality Create and Delete

    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And User sending the Enter keys in Dialog

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | <name> |

    Examples:
      | name |
      | ismetNat5411 |
      | ismetNat5412 |
      | ismetNat5413 |
      | ismetNat5414 |
      | ismetNat5415 |