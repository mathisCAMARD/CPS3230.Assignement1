Feature: Icon Check

  Scenario Outline: Icon Check
    Given I am an administrator of the website and I upload an alert of type <alertType>
    Given I am a user of marketalertum
    When I view a list of alerts
    Then I should see 1 alerts
    And the icon displayed should be <iconFileName>

    Examples:

    |alertType|iconFileName|
    |1         |icon-car.png|
    |2         |icon-boat.png|
    |3         |icon-property-rent.png|
    |4         |icon-property-sale.png|
    |5         |icon-toys.png|
    |6         |icon-electronics.png|