Feature: SubscribeNewsLetter

  Background:
    Given User should be on MagazinePage

  Scenario Outline: Fill the contact form
    When user scroll down and navigate to news letter section
    Then user should see news letter section
    When user enter random email address
    When user click on Inspire Me button
    Then user should get the "<verificationMessage>"

    Examples:
      | verificationMessage     |
      | You are now checked-in! |