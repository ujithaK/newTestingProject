Feature: Practice Test Automation login

  Scenario: Successful login with valid credentials
    Given I open the practice login page
    When I login with username "student" and password "Password123"
    Then the logged in page URL should contain "practicetestautomation.com/logged-in-successfully/"
    And the logged in page should show a success message
    And the logout button should be displayed

  Scenario: Validate the login page UI text
    Given I open the practice login page
    Then the page heading should be "Test login"
    And the page description should contain "simple Login page"
    And the submit button should be labeled "Submit"
