Feature: Free CRM application Test

Scenario: Validate FreeCRM Home page Test

Given user opens the browser
When user enter the url
Then user is on login page
Then user enters username and password
Then user clicks on login button
Then homepage is displayed 
Then validate homepage title
Then validate logged in username