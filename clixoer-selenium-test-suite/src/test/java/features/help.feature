Feature: Navigate to Help Page

Scenario: Home Page Loading
Given user is on landing page
When user checks for navigation pane and clicks on help
Then help page opens
Scenario: Help Page Validation
Given user is on help page
When user clicks English tab
Then english help opens
Scenario: Help Page Validation
Given user is on help page
When user clicks Maths tab
Then maths help opens
Scenario: Help Page Validation
Given user is on help page
When user clicks Science tab
Then science help opens