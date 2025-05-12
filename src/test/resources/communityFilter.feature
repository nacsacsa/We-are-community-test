Feature: Communities filter functionality
  Scenario: Filtering communities based on language and format
    Given the user is on the main page
    When The Communities button is clicked
    And The Show More button is clicked
    And The Hungarian Language and Online Only Format filters are added
    Then The displayed number of communities should be 4
    When The filters are cleared
    Then The number of cards displayed should still be 4