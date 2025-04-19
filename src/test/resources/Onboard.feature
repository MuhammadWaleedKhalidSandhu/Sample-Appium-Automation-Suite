Feature: Onboard App Initial Flow

  Scenario: Launch app and complete initial onboarding
    Given the app is launched
    When I tap on "Continue"
    And I select "United Arab Emirates"
    And I select "Saudi Arabia"
    And I tap on "Continue"
    And I tap on "Skip"
    And I allow the permissions
    Then the app onboarding is completed