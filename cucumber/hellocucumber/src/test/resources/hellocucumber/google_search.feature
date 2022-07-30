Feature: List colours

Scenario: Show a short list of colours
  Given I am on our application Home Page
  Then the page title should start with "bdd"
  When I press the "show" button
  Then I sould see colours list "Red, Blue, Yellow, White."
