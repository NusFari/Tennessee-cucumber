@LoginTest
Feature:Test login functionalities

  @positive_test
  Scenario:Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "standard_user" and password "secret_sauce"
    And click on login button
    Then user is navigated to home page

    @dataDriven_test
    Scenario Outline:Check login is successful with valid credentials for multiple users
     Given a user is on the login page
     When  user enters username "<username>" and password "<password>"
     And click on login button
     Then user is navigated to home page
     Examples:
      |username       |password    |
      |standard_user  |secret_sauce|
      |visual_user    |secret_sauce|
      |problem_user   |secret_sauce|

      @datatable_test
      Scenario:Check login is successful using data table
        Given a user is on the login page
        When user click on login button upon entering credentials
         |username       |password    |
         |standard_user  |secret_sauce |

        Then user is navigated to home page

        @negative_test
        Scenario: Check login is unsuccessful with invalid credentials
          Given a user is on the login page
          When user enters username "standard_user" and password "abc1234"
          And click on login button
          Then user is failed to login

