Feature: Sconto Login Feature
  In order to see the user area
  I log in to the website

  Scenario: Our Goal is Successful Login
    Given I am on the homepage
    When I click on the Login icon
    Then I see login page

    When I insert valid user credentials
    And I click on Login button
    Then I should see MyAccount icon

    When I click on MyAccount icon
    Then I should see my name
