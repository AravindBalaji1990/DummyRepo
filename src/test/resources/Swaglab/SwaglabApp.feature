Feature: To test the swag lab app login

  Background:
    Given User open Android device

  @datacheckswaglab
  Scenario: Test the valid user login
    When User enter the user name "standard_user"
    And User enter the password "secret_sauce"
    And User clicks on the login
    Then User is able to see the dashboard

  @problemuser
  Scenario: Test the valid user login
    When User enter the user name "locked_out_user"
    And User enter the password "secret_sauce"
    And User clicks on the login
    Then User should not be able to see the dashboard

  @tableformat
  Scenario: Test the valid user login pass multiple items at step level
    When enter the user name for different user
      | user          | password     |
      | standard_user | secret_sauce |
#      | locked_out_user | secret_sauce |
    And User clicks on the login
    Then User is able to see the dashboard

  @Testscenariooutline
  Scenario Outline: Test the valid user login pass multiple items at scenario level - same scenario but different sets of data
    When enter the user name for different user at scenairo level <userdata>
    And User enter the password <password>
    And User clicks on the login
    Then User is able to see the dashboard <error>

    Examples:
      | userdata        | password     | error |
      | standard_user   | secret_sauce | no    |
      | locked_out_user | secret_sauce | yes   |
      | problem_user    | secret_sauce | no    |