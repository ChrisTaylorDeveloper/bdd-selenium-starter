Feature: List colours

Scenario: Show a short list of colours
  Given I am on our application Home Page
  When I press the "show" button
  Then I sould see colours list "Red, Blue, Yellow, White."
