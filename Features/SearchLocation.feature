
Feature: SearchLocation
  Background:
    Given User should be on MagazinePage

  Scenario: Click on Search and Enter Location
    When user click on search icon
    Then user should see the search field
    When user enter value in search box as "Canada" and search
    Then user should see all search result for "Canada"