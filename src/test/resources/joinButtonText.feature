Feature: Community card button text
  Scenario: Community card buttons should display "Connect"
    Given the user is on the main page
    When The Communities button is clicked
    Then each Community card should have a button labeled 'Connect'