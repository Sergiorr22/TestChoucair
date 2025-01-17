@candidates
Feature: Candidates

  Scenario: Candidate registration
    Given entry into the environment
    When the user enters username "Admin" and password "admin123"
    And the user logs in to recruitment, clicks on add and enters his full name, firstname "Sergio" middlename "Steven" and last name "Rodriguez"
    And the user selects the vacancy
    And user enters email "ruizsergio48@gmail.com" and contact number "3133724686"
    And the user uploads his CV
    And user saves the record
    And The user clicks on shortlist and saves
    And The user clicks on schedule and fills out the data "Prueba", "James", "2024-20-07"
    And the user completes the candidate process
    Then the user should see the name "Sergio Steven Rodriguez", vacancy "Senior QA Lead", and status Hired