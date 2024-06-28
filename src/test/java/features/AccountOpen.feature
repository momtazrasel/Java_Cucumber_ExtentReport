Feature: Test login functionality

  @Demo
  Scenario: Login with valid username and password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter valid username and password in login form
    And Clicks on Log in button

  @Demo
  Scenario: Login with Valid username and invalid password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter valid username and invalid password in login form
    And Clicks on Log in button
    Then Verify that the username or password is invalid

  @Demo
  Scenario: Login with invalid username and valid password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter invalid username and valid password in login form
    And Clicks on Log in button
    Then Verify that the username or password is invalid

  @Demo
  Scenario: New Account successfully created
    When Click on the My Account Button
    And Click on the Register option
    And Click on the First Name text field and Insert the First Name
    And Click on the Last Name text field and Insert the Last Name
    And Click on the Email text field and Insert the Email
    And Click on the Telephone text field and Insert the Telephone Number
    And Click on the Password text field and Insert the Password
    And Click on the Confirm Password text field and Insert the Confirm Password
    And Click on the Privacy Checkbox
    And Click on the Continue Button
    Then Verify that the New Account Successfully Created

