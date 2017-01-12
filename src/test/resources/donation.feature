Feature: Making Donation
  As a user
  I can choose a charity
  So I can make a donation
Background: user is logged in and user is on a specific event page
Scenario: make a donation
	Given user enter donation amount and has sufficient fund
	When user click donate
	Then donation amount will be subtracted from user account and added into organization account

  