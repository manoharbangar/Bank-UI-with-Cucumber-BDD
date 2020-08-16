Feature: To test login functionality of the Guru99 Bank site

  Background: 
    Given user launches URL for Guru Bank login
    And user is on Login Page

  Scenario: To test Invalid credentials for Guru Bank website
    Given login to Guru Bank page is displayed
    When user enters invalid login details as "engr1234" and "pass1234"
    And click on login button
    Then alert message as "User or Password is not valid" is displayed

  Scenario: To test Valid credentials for Guru Bank website
    Given login to Guru Bank page is displayed
    When user enters valid login details as "mngr274020" and "aryvusy"
    And click on login button
    Then home page is displayed for Manager
