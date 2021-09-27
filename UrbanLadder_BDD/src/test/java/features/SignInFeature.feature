Feature: Sign In of A User

Scenario Outline: User Sign in using Facebook
Given open urban ladder url
When Navigate to Facebook and Sign in
Then enter email <email> and password <password> of facebook
And End of signin Test

Examples:
|email							|password		|
|amanpandey1504@gmail.com		|pass#word1		|
|amanpandey1504@gmail.com		|qwerty1234		|

Scenario Outline: User Sign in using Google
Given open urban ladder url
When Navigate to Google account and Sign in
Then enter email <email> and password <password> of google
And End of signin Test

Examples:
|email							|password		|
|amanpandey1504@gmail.com		|pass#word1		|
|amanpandey1504@gmail.com		|qwerty1234		|