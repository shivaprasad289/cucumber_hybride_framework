Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters valid product "HP" into search textfield
And User clicks on search button
Then User should get valid product in search field

Scenario: User searches for an invalid product
Given User opens the application
When User enters invalid product "Honda" into search textfield
And User clicks on search button
Then User should get a no product matching message

Scenario: User searches without any product
Given User opens the application
When User donot enter any product name into search textfield
And User clicks on search button
Then User should get a no product matching message