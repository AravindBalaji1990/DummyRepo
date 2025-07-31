@apidemo
Feature: Api demo app testing

  Scenario: to check the button Graphics is available
    Given User launched the app in android
    When the User lands on the dashboard
    Then the user verifies the Graphics button
    Then User close the app