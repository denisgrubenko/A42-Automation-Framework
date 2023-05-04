Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open login page
    When I enter email "denis.grubenko@gmail.com"
    And I enter password "te$t$tuden"
    And I submit
    Then I am logged in