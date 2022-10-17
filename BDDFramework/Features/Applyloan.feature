@complete

Feature: Apply for a Loan


#Background is used when different scenario having same Precondtions so grouping them in a background

  Background: 
    Given User should launch chrome browser
    When User should navigate to URL "https://uibank.uipath.com/"
    And User should enter UserName as "nithish81" and Password as "77087708"
    And Click submit button
    Then Verify User should landed on a HomePage "https://uibank.uipath.com/accounts"

  # DATA HANDLING 
  
  #LIST :
  
  @smoke
  Scenario: User should apply for a loan
    When User should click Apply for a loan link
    And Click Apply for a Loan
    Then Verify user landed on a Apply Loan page "https://uibank.uipath.com/loans/apply"
    And User should enter Email Id
    And User should Enter AMOUNT REQUIRED and Select LOAN TERM option and enter their INCOME and AGE
      | 2000 | 1 | 20000 | 21 |
    #| 35000 | 3 | 35000 | 12 |
    And Click submit Loan Application
    Then Verify the Loan status
    And close browser
    
    
@regression
  Scenario: Apply for a Loan by another way
    When Click dropdown and click loan option
  
    Then Verify user landed on a Apply Loan page "https://uibank.uipath.com/loans/apply"
    And User should enter Email Id
    And User should Enter AMOUNT REQUIRED and Select LOAN TERM option and enter their INCOME and AGE
      | 35000 | 3 | 35000 | 19 |
    And Click submit Loan Application
    Then Verify the Loan status
    And close browser
