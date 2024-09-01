Feature: Test Men's Page Scenarios

  Scenario : Go to mens cloth page
    Given the user is on Test Store Home Page
    When the user navigates to Clothes Page
    And click on Men link
    Then mens cloth page should be displayed
    Then the user logs out of the system

