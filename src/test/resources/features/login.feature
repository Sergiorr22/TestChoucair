@Login @E2E
Feature: Login

  Scenario: successful login
    Given entry into the environment
    When the user enters username "Admin" and password "admin123"
    Then Log in correctly
