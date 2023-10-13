Feature: Login functionality

Scenario Outline: Login with valid credentails
Given User has navigates to login page
When User has enteres valid email address <Email> into the email field
And User has enteres valid password <Password> into the passowrd field
And User clicks on login button
Then User should get successfully logged in
Examples:
|Email                      |Password|
|shivaprasadsh1998@gmail.com|123456|
|shivap@gmail.com           |123456|
|shihid@gmail.com           |2223|
|ahsjhj@gmail.com           |333393392|

Scenario: Login with invalid credentails
Given User has navigates to login page
When User enters invalid email address into the email field
And User enteres invalid passowrd "22323" into the password field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login with valid email and invalid password
Given User has navigates to login page
When User has enteres valid email address "shivaprasadsh1998@gmail.com"
And User enteres invalid passowrd "22323" into the password field
And User clicks on login button 
Then User should get a proper warning message about credentails mismatch

Scenario: Login with invalid email and valid password
Given User has navigates to login page
When User enters invalid email address into the email field
And User has enteres valid password "1234232335"
And User clicks on login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login without providing any credentails
Given User has navigates to login page
When User dont enter email into the email field
And User dont enter passowrd into passowrd field
And User clicks on login button
Then User should get a proper warning message about credentails mismatch


