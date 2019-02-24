 @date
Feature: change dates


  Scenario: business calculator application - add
    Given I am on business calculator application
    When I add 1 days to 1/1/2000
    Then the date calculator should calculate the days correctly

  Scenario: business calculator application - subtract
    Given I am on business calculator application
    When I subtract 3 days from 02/02/2020
    Then the date calculator should calculate the days correctly