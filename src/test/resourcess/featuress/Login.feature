Feature: Login functionality

Scenario: :Login with valid credentails
Given User has navigates to login page
When User has enteres valid email address "shivaprasadsh1998@gmail.com" into the email field
And User has enteres valid password "12345" into the passowrd field
And User clicks on login button
Then User should get successfully logged in

Scenario: Login with invalid credentails
Given User has navigates to login page
When User enters invalid email address "abc@gmail.com" into the email field
And User enteres invalid passowrd "22323" into the password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login with valid email and invalid password
Given User has navigates to login page
When User has enteres valid email address "shivaprasadsh1998@gmail.com" into the email field
And User enteres invalid passowrd "22323" into the password field
And User clicks on login button 
Then User should get a proper warning message about credentails mismatch

Scenario: Login with invalid email and valid password
Given User has navigates to login page
When User enters invalid email address "abc@gmail.com" into the email field
And User has enteres valid password "12345" into the passowrd field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login without providing any credentails
Given User has navigates to login page
When User dont enter email into the email field
And User dont enter passowrd into passowrd field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch


