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

@login

Feature: User Login

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