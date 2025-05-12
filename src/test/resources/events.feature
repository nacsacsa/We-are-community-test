Feature: Upcoming Events counter on Events page
  Scenario: Upcoming Events counter should display correct information
    Given the user is on the main page
    When The Events button is clicked
    And The More Filters button is clicked
    And The Date From filter is applied
    And The Date Till filter is applied
    Then The Upcoming Events counter should be accurate