Feature: Making Donation
  As a user
  I can choose a charity
  So I can make a donation
Background: user is logged in and user is on a specific event page
Scenario: make donation
	Given user enter the amount of money to donate
	And user have enough money in my bank to donate
	When user click donate
	Then users bank amount will be subtracted by donated amount
	And events organization bank amount will be added by the donated amount

  