Feature: Tracking an order using Order Number and Phone Number

Scenario Outline: Track an Order
Given open url in broser
When Click on Track Order
Then Enter order number <orderNo> and phone number <phoneNo>
And Close the window

Examples:
|orderNo	|phoneNo		|
|1234		|9944758326		|
|5678		|9944758326		|