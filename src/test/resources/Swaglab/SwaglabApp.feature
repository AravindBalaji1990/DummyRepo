Feature: To test the swag lab app login

  Background:
    Given User open Android device

    Scenario: Test the valid user login
      When User enter the user name
      And User enter the password
      And User clicks on the login
      Then User is able to see the dashboard

