@login-user
Feature: Login User

    @login-positive
	Scenario Outline: Login user with positive test case

		Given I am on home page
		And I click on Signin
		And I see Signin form displayed
		When I enter username "<email>"
		And I enter password "<password>"
		And I click on Signin button
		Then I should see "<title>" in browser title

		Examples:
          |email            |password |title                |
          |peter@gmail.com  |test@123 |My account - My Store|
