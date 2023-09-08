Feature: Access Product via Search Page

  Scenario: Access product via search page
    Given user open the browser
    When user open ebay homepage
    And user is on homepage
    When user search "macbook" in search bar
    Then user redirect to search page
    When user select category "Computers/Tablets & Networking" on dropdown
    Then user verify page is loaded
    And verify the product with keyword "macbook" is displayed
    And user close the browser