Feature: Landing

  Scenario: Visual check for landing page

    Given User is navigated to landing page with test cards
    And Test for "Websites" are selected
    Then Check that the estimated time left from eg 120 sec is decreasing for selected test
