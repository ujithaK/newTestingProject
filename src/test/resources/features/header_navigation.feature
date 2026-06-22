Feature: Header navigation

  Scenario Outline: Navigate through website headers and validate destination pages
    Given I open the Practice Test Automation home page
    When I click the "<header>" header
    Then I should be on the "<page>" page

    Examples:
      | header   | page     |
      | Home     | home     |
      | Practice | practice |
      | Courses  | courses  |
      | Blog     | blog     |
      | Contact  | contact  |
