Feature: To test the swag lab app login

  Background:
    Given User open Android device
    When User lauch the app Swag lab

    Scenario: Test the valid user login
      When User enter the user name
      And User entet the password
      Then User clicks on the login
