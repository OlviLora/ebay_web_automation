Feature: Access Product via Category Page

  Scenario: Access product after apply multiple filters
    Given user open the browser
    When user open ebay homepage
    And user is on homepage
    When user navigate to search by category "Cell phones & accessories"
    Then user redirect to category "Cell phones & accessories" page
    When user click section "Cell Phones & Smartphones"
    Then user redirect to search listing product "Cell Phones & Smartphones"
    When user click all filters
    Then user verify filter pop up window is displayed
    And user apply filter "New" "5000000" "Asia"
    Then user see product listing and filter "New" "5,000,000" "Asia" applied
    And user close the browser