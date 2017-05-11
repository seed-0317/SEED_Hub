Feature: SEED class admin capabilities
  Scenario: New admin or interviewer added to system
    Given I am logged in as an admin
    When I click on add admin/ interviewer
    And I add an interviewer/admin and submit
    Then A new admin/interviewer is created in the system

  Scenario: Admin wants to see a list of all applicants and their statuses
    Given I am logged in as an admin
    When I click on view applicant tab
    Then I see a list of all applicants and their statuses

  Scenario: Admin wants to see a list of all classes
    Given I am logged in as an admin
    And I am logged in
    When I click on add seed class navigation
    Then I see a list of all classes

  Scenario: Setting up a new SEED class
    Given I am an admin
    And I am logged in
    And I click on add seed class navigation
    When I fill in the seed class listing and click submit
    Then A new class is created

  Scenario: Admin wants to close a class after class
    Given I am an admin
    And I am logged in
    And I click on add seed class navigation
    When I click on close a class
    Then Status of class is updated to closed

  Scenario: Admin wants to update a class
    Given I am an admin
    And I am logged in
    And I click on add seed class navigation
    When I change the class information
    Then The class information is updated

  Scenario: Setting up new interview questions
    Given I am an admin
    And I am logged in
    And I click on add build interview navigation
    When I fill in the interview question gui and click submit
    Then A new interview question list is created

  Scenario: Recording interview scores
    Given I am an interviewer or on the SEED program team
    And I am logged in
    And I click on conduct interview navigation
    When I fill in the gui and click submit
    Then A new record of an applicant's performance in the selection process is created

  Scenario: Updating applicant status in selection process
    Given I am an admin on the SEED program team
    And I am logged in
    When I select a status for an applicant
    Then The applicant's status is changed and the applicant can view their new status when they log in

  Scenario: New SEED class announced
    Given I am a SEED admin
    And I am logged in
    When I select and submit the X applicants for the given class being decisioned
    Then The selections are saved