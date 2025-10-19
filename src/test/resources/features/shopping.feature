Feature: Basic shopping flow on PrestaShop demo

  Background:
    Given user navigates to prestashop

  Scenario: Register, search, add to item cart and verify the addition of the selected item to cart
    When user creates a new account with "First", "Last", "Email@example.com", "test1234AAA****",and "03/21/2000"
    And user searches for "notebook"
    Then user selects the first search result and asserts it has an image
    And user adds the product to the cart
    And user navigates to the cart
    Then Added product is found in cart
