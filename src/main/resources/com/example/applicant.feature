Feature: Interested new SEED candidate wants to apply
  Scenario: SEED candidate logs in
    Given I am a SEED candidate
    And I am a registered user
    When I am logged in
    Then I see two options to view resources and to submit an application

  Scenario: SEED candidate applies for a SEED class
    Given I am a SEED candidate
    And I am logged in
    And I have clicked on an application
    And I have completed the application
    And I have clicked submit
    Then The application is created
    And The candidate is directed to a receipt page

  Scenario: SEED candidate starts an application and wants to come back later to finish and submit
    Given I am a SEED candidate
    And I am logged in
    When The SEED candidate enters some data in an application and click save
    Then The data is saved in the db as an application in progress
    And The candidate is notified that it is saved

  Scenario: SEED candidate wants to update his/her application before the deadline
    Given I am a SEED candidate
    And I have saved or submitted an application previously
    And I have already saved a partially completed application
    When I click on application
    Then I can change the fields on my application and resubmit

  Scenario: SEED candidate saved a partially completed application previously and is returning to complete and submit
    Given I am a SEED candidate
    And I am logged in
    And I have already saved a partially completed application
    When The SEED candidate clicks submit
    Then The data is submitted to the program team

  Scenario: SEED candidate chooses a class
    Given I am a SEED candidate
    And I am logged in
    When I click on the seed class drop down
    Then I only see a list of classes that are within app open date and app deadline