Feature: Amazon Functionalities

  Scenario: Verify the title of the Amazon page
    Given I launch the Amazon website
    Then The title should contain "Amazon"

  Scenario: Verify product ID search
    Given I launch the Amazon website
    When I search for "Samsung Galaxy S24"
    Then Product results should be displayed

  Scenario: Category search using search bar
    Given I launch the Amazon website
    When I search for "Books"
    Then Search results should belong to the Books category

  Scenario: Verify scrolling functionality
    Given I launch the Amazon website
    When I scroll down the page
    Then The page should scroll successfully
