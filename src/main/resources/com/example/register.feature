Feature: Interested new SEED candidate visits site
  Scenario: SEED candidate registers with SEED hub
    Given I am a SEED candidate
    And I am not a registered user
    When The SEED candidate visits SEED hub
    Then The SEED candidate registers with his/her eid
    And Is directed to the applicant home page