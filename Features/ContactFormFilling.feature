Feature: ContactFormFilling

  Background:
    Given User should be on MagazinePage

  Scenario Outline: Fill the contact form
    When user click on contact link and navigate to contact form
    Then current tab should appear as "https://magazine.trivago.com.au/contact/"
    When user enter value in message text box as "<Message>"
    When user enter value in full name text box as "<FullName>"
    When user enter value in email text box as "<Email>"
    When user check the checkbox for contact form
    When user click on submit button
    Then user should get message as "<VerificationMessage>"
    Examples:
      | Message              | FullName       | Email            | VerificationMessage        |
      | interview  Test data | Interview Triv | intTest@test.com | Message Sent Successfully! |