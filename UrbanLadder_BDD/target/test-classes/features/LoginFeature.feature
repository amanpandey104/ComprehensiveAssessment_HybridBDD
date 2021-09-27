Feature: Login of user

Scenario Outline: Login of a User
Given open urban ladder website
When enter email <email> and password <password> for login
Then Login
And End of Login Test

Examples:
|email							|password		|
|amanpandey1504@gmail.com		|pass#word1		|
|amanpandey1504@gmail.com		|qwerty1234		|