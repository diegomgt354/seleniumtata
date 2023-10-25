@ErrorValidations
Feature: Validations messages error

  Background:
    Given I am on the Login page

  @LoginError
  Scenario Outline: Validation login error
    When enter the <name> and the <password> and click button Login
    Then go to confirmation message "Incorrect email or password."
    And close the browser

    Examples:
      | name               | password           |
      | diego123@gmail.com | passIncorrecto123! |

  @RegisterError
  Scenario Outline: Validation register error
    When go to the registration screen
    And enter the <name> and the <password> enter the other values and click button Register
    Then go to confirmation message "User already exisits with this Email Id!"
    And close the browser

    Examples:
      | name               | password  |
      | diego000@gmail.com | Admin123! |