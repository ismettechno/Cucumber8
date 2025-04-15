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

    Then Success message should be displayed


  Scenario: Create Nationality Functionality

    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | ismetNat12111 |

    And User sending the Enter keys in Dialog

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | ismetNat12111 |