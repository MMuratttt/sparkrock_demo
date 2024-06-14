Feature: Login functionality

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the dashboard
    And Logout

    Examples:
    |username   |password         |
    |validUser1 |valid_password_1 |


  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should see an error and should not be redirected to the dashboard

    Examples:
      |username   |password           |
      |validUser1 |invalid_password_1 |
      |validUser2 |invalid_password_2 |
      |validUser3 |invalid_password_3 |


  Scenario: Password recovery using registered email
    Given the user is on the login page
    When the user clicks on the forgot password link
    And enters a registered email address "validUser1"
    Then password recovery email should be sent
    When the user enters an invalid OTP code
    Then an error message should be displayed
    When the user enters the valid OTP code
    Then the user should be able to login