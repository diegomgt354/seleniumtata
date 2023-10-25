@ProductOrder
Feature: We order products on the page

  Background:
    Given I am on the Login page

  @Register
  Scenario Outline: Registering an account
    When go to the registration screen
    And enter the <name> and the <password> enter the other values and click button Register
    Then go to the registration confirmation screen with the message "Account Created Successfully"
    And close the browser

    Examples:
      | name               | password  |
      | diego000@gmail.com | Admin123! |

  @Login
  Scenario Outline: Login an account
    When enter the <name> and the <password> and click button Login
    Then go to the login confirmation
    And close the browser

    Examples:
      | name              | password |
      | diego01@gmail.com | Admin123! |

  @RegisterAndLogin
  Scenario Outline: Register and Login an account
    And go to the registration screen
    When enter the <name> and the <password> enter the other values and click button Register
    And go to the registration confirmation screen with the message "Account Created Successfully"
    And go to the login screen
    And enter the <name> and the <password> and click button Login
    Then go to the login confirmation
    And close the browser

    Examples:
      | name              | password  |
      | diego02@gmail.com | Admin123! |

  @ProductOrderList
  Scenario Outline: Orders Products List
    And go to the registration screen
    When enter the <name> and the <password> enter the other values and click button Register
    And go to the registration confirmation screen with the message "Account Created Successfully"
    And go to the login screen
    And enter the <name> and the <password> and click button Login
    And go to the login confirmation
    And <product> add to cart
    And go to cart page
    And validate <product> in cart
    And go to Payment Method
    And we enter the heats of payment with the <country> and place order
    And we copy the order id generated in the purchase
    And we go to the order page
    Then the product is registered by order id
    And validate product by <name>
    And close the browser

    Examples:

      | name              | password  | product     | country |
      | diego03@gmail.com | Admin123! | ZARA COAT 3 | India   |


