@place-order
Feature: Place a order

	Background: User login

		Given I am on home page
		And I click on Signin
		And I see Signin form displayed
		When I enter username "peter@gmail.com"
		And I enter password "test@123"
		And I click on Signin button

    @place-order-positive
	Scenario Outline: Place order with positive test case

		Given I am on home page to place a order
		And I add "<items>" to cart
		And I check if summary has "<items>" items
		And I verify "<country>" in address details
		And I agree terms of service for shipping
        When I make and verify "<bank>" payment
        And I confirm order
        Then I see "<confirmation>" for placed order

		Examples:
          |items|country        |bank               |confirmation                       |
          |2    |United States  |BANK-WIRE PAYMENT. |Your order on My Store is complete.|
