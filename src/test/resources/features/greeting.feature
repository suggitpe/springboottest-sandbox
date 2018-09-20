Feature: Greeting Service

  Producer responds with greeting

  Scenario: Calling Producer yields greeting
    Given the Greeting Service is running
    When Bob calls the Greeting Service
    Then it says "Hello, Bob"

  Scenario: Calling the Producer anonymously yields greeting to whole world
    Given the Greeting Service is running
    When someone called the Greeting Service anonymously
    Then it says "Hello, World"