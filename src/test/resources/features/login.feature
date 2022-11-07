@SYMU-1653
Feature: Symund app login feature

  User Story:
  As a user, I should be able to login.

  Account are: Employee131

  Background: For the scenarios in the feature file,
  user is expected to be on login page
    Given user is on the Symund login page

  @SYMU-1628
  Scenario: Login with valid credentials
    When user enters valid username
    And user enters valid password
    And user clicks to login button
    Then user should see the dashboard

  @SYMU-1664
  Scenario Outline: cannot login with invalid credentials
    When user enters invalid username "<InvalidUsername>"
    And user enters invalid password "<InvalidPassword>"
    And user clicks to login button
    Then user should see the message "<WarningMessage>"
    Examples:
      | InvalidUsername | InvalidPassword | WarningMessage              |
      | Employee666     | 123456          | Wrong username or password. |
      | Employee609     | 123456fff       | Wrong username or password. |
      | Employee999     | 12345622        | Wrong username or password. |

  @SYMU-1665
    Scenario: can not enter without any credentials
      When user clicks to login button
      Then Please fill out this field (usernameField) message should be displayed

  @SYMU-1666
  Scenario: User can see the password in form of dots by default
    When user enters valid username
    And user enters valid password
    Then password must be seen as dots

   @SYMU-1701
Scenario: User can see the password explicitly if needed
    When user enters valid password
    And clicks eye-button
    Then user should see password explicitly

  @SYMU-1703
Scenario:User can see the "Forgot password?" link on the login page
  and can see the "Reset password" button on the next page after
  clicking on forget password link
When User can see the Forgot password? link
    And User can click Forgot password button
    Then User can see Reset password button

  @SYMU-1707
  Scenario: User can see valid placeholders on Username and Password fields
    When user can see valid placeholder on Username field
    Then user can see valid placeholder on Password field


