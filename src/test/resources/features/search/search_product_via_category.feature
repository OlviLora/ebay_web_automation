Feature: Access Product via Category Page

  Scenario: Access product after apply multiple filters
    Given user open the browser
    When user open ebay homepage
    And user is on homepage
    When user navigate to search by category "Cell phones & accessories"
    Then user redirect to category "Cell phones & accessories" page
    When user click section "Cell Phones & Smartphones"
    Then user redirect to search listing product "Cell Phones & Smartphones"
    # When user apply filter
    # Then user see product listing related to the filter applied
    And user close the browser