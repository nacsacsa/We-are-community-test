Feature: Videos page language change functionality
  Scenario: Changing language to Russian should update text without reloading
    Given the user is on the main page
    When The Videos button is clicked
    And The language is changed to Russian
    Then The page should display the text 'Популярные вещи'