
@SYMU-1715
Feature: Symund app logout feature

  User Story:
  As a user, I should be able to log out.

  Account are: Employee131

  Background: For the scenarios in the feature file,
  user is expected to be on dashboard page
    Given user is on the Symund dashboard page

  @SYMU-1714
    Scenario: User can log out and ends up in login page
      When user clicks to avatar button
      And user clicks to logout button
      Then user is on the Symund login page

  @SYMU-1736
  Scenario: User cannot go to home page again by clicking step back button after successfully logged out
   When user clicks to avatar button
   And user clicks to logout button
    And user is on the Symund login page
    And user navigates and clicks to Back button
    Then user is on the Symund login page








