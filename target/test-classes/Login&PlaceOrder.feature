#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login and Place Order Flow

  Scenario: User logs in with phone and password
    Given the app is launched
    When I tap on "Continue"
    And I tap on "Continue"
    And I tap on "Skip"
    And I allow the permissions
    And I enter phone number "547182996"
    And I tap on "Continue"
    And I tap on "Login with password instead"
    And I enter password "Nizar@123"
    And I tap on "Continue"
    Then I should be logged in successfully

  Scenario: Search for a product and place an order end-to-end
    Given I am on the Home screen
    When I tap on the search bar
    And I search for the product "panadol"
    And I tap on the product image
    And I tap on add to cart 
    And I tap on the Cart icon
    And I tap on the Checkout button
    And I select a delivery day
    And I select a delivery time slot
    And I tap on Confirm
    And I scroll down to the payment section
    And I select cod
    And I tap on Place Order
    Then the order should be placed successfully
