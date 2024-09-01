Feature: Test Store Search Page Scenarios

  Scenario Outline: Search using search text
    Given the user is on Test Store Home Page
    When the user searches for an item with data from "<testDataPath>"
    Then the search results should be displayed
    Then the user logs out of the system

    Examples:
    | testDataPath          |
    | test-data/tc001.json  |
