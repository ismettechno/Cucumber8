Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country Functionality

    And Click on the Element LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | ismetUlk1911 |
      | codeInput | isKod11      |

    And Click on the Element Dialog
      | saveButton |


  Scenario: Create Nationality Functionality

    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | ismetNat1911 |

    And Click on the Element Dialog
      | saveButton |