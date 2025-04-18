Feature: To test the swag lab app login

  Background:
    Given User open Android device

  Scenario: Test the valid user login
    When User enter the user name standard_user
    And User enter the password secret_sauce
    And User clicks on the login
    Then User is able to see the dashboard

  Scenario: Test the valid user login pass multiple items at step level
    When enter the user name for different user
      | user            |
      | standard_user   |
      | locked_out_user |
    And User enter the password secret_sauce
    And User clicks on the login
    Then User is able to see the dashboard

    @TestRun1
  Scenario Outline: Test the valid user login pass multiple items at scenario level - same scenario but different sets of data
    When enter the user name for different user at scenairo level <userdata>
    And User enter the password secret_sauce
    And User clicks on the login
    Then User is able to see the dashboard

    Examples:
      | userdata        |
      | standard_user   |
      | locked_out_user |