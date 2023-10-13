Feature: Reqistration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to register account page
When User enters the below fields
|FirstName|Shivaprasad  |
|LastName |s            |
|Telephone|8618383695   |
|Password |12345678     |
And User selects privacy policy
And User clicks on continue button
Then User account should get created

Scenario: User creates an account with all fields
Given User navigates to register account page
When User enters the below fields
|FirstName|Shivaprasad   |
|LastName |s             |
|Telephone|8618383695    |
|Password |12345678      |
And User selects Yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created

Scenario: User creates a duplicate account
Given User navigates to register account page
When User enters the details into the below details with duplicate email
|FirstName|Shivaprasad                |
|LastName |s                          |
|Email    |shivaprasadsh1998@gmail.com|
|Telephone|8618383695                 |
|Password |12345678                   |
And User selects Yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning for duplicate email

Scenario: User creates an account without filling any details
Given User navigates to register account page
When User donot enters any details into fields
And User clicks on continue button
Then User should get proper warning message for every mandatory fields
