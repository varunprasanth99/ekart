Feature: Application Login

Scenario: Login with valid credentials
Given Open any browser
When User enters username as "test@abc.com" and password as "test@123"
And User clicks on login button
Then User is able to login successfully

