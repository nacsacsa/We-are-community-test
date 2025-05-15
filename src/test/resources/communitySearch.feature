Feature: Communities search functionality
  Scenario: Searching for tester should show matching communities
    Given the user is on the main page
    When The Communities button is clicked
    And The 'tester' is typed in to the Search bar
    Then The search results should contain communities