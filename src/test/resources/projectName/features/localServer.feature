Feature: Local Server Users Feature

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

#  @local
#  Scenario: TC01 Get users from Local Server
#    When Send GET request to Local Server
#    Then Response status should be 200

  @local
  Scenario: TC02 Create new user on local Server
    #POST
    When Send POST request to Local Server
    Then Response should be non-empty
    And Response status should be 201
    And Response body should contain email with mark.november@mail.com value
    And Response body should contain first name with Norbert value
    And Response body should contain last name with Kolski value
    And Response body should contain job with Waiter value
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    Then Response body should contain email with mark.november@mail.com value
    And Response body should contain first name with Norbert value
    And Response body should contain last name with Kolski value
    And Response body should contain job with Waiter value
    #PUT
    When LocalUser updates request with job and Mechanic value
    And LocalUser updates request with first_name and Antoni value
    And Send PUT request to LocalUsers
    Then Response should be non-empty
    And Response status should be 200
    Then Response body should contain email with mark.november@mail.com value
    And Response body should contain first name with Antoni value
    And Response body should contain last name with Kolski value
    And Response body should contain job with Mechanic value






#    And LocalUsers response should have at least one result like
#      | email                  | first_name | last_name | job    |id|
#      | mark.november@mail.com | Norbert    | Kolski    | Waiter |4 |
#
#    And User defines request with query parameter 'id' from response body
#    And Send GET request to Local Server
#    Then Response status should be 200





