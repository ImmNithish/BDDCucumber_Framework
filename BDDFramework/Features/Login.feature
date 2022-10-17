@complete

Feature: Login

  @smoke
  Scenario: Login with valid credential
    Given User should launch chrome browser
    When User should navigate to URL "https://uibank.uipath.com/"
    And User should enter UserName as "nithish81" and Password as "77087708"
    And Click submit button
    Then Verify User should landed on a HomePage "https://uibank.uipath.com/accounts"
    When User click on Logout button
    Then Verify User should landed on a LoginPage "UiBank"
    And close browser

  @sanity
  Scenario Outline: Login with Data Driven
    Given User should launch chrome browser
    When User should navigate to URL "https://uibank.uipath.com/"
    And User should enter UserName as "<username>" and Password as "<password>"
    And Click submit button
    Then Verify User should landed on a HomePage "https://uibank.uipath.com/accounts"
    When User click on Logout button
    Then Verify User should landed on a LoginPage "UiBank"
    And close browser

    Examples: 
      | username  | password |
      | nithish81 | 77087708 |
      | jerin     |   125454 |
