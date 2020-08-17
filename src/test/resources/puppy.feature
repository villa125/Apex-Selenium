Feature: Puppy adoption testing

  Background:
    Given A web page "http://puppies.herokuapp.com/"

  Scenario: Adopt one puppy
    Given I look for details for dog 1
    And adopt the pet
    When shopping cart appear complete te adoption
    And complete the adoption form with following data
      | name        | Juan Carlos   |
      | address     | test address  |
      | mail        | test@test.com |
      | paymentType | Credit card   |
    Then I verify the adoption on home page


  Scenario: Adopt two puppies
    Given I look for details for dog 1
    And adopt the pet
    And I want to add one more puppy
    Then I look for details for dog 2
    And adopt the pet
    When shopping cart appear complete te adoption
    And complete the adoption form with following data
      | name        | Juan Carlos   |
      | address     | test address  |
      | mail        | test@test.com |
      | paymentType | Credit card   |
    Then I verify the adoption on home page
