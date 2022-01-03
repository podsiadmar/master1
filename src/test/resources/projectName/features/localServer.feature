Feature: Local Server Users Feature

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

  @local
  Scenario: TC01 Get users from Local Server
    When Send GET request to Local Server
    Then Response status should be 200

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
    And Send PUT request to LocalUsers with Id from response
    Then Response should be non-empty
    And Response status should be 200
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    And Response body should contain email with mark.november@mail.com value
    And Response body should contain first name with Antoni value
    And Response body should contain last name with Kolski value
    And Response body should contain job with Mechanic value
    #Delete
    When Send DELETE request to Localusers to remove user id from response
    Then Response status should be 200


  @local
  Scenario: TC03 Create new user on local Server - different way
    #POST
    When Send POST request to Local Server
    Then Response should be non-empty
    And Response status should be 201
    And Save results to datavault
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    And LocalUsers response should have at least one result like
      | email                  | first_name     | last_name | job      | id |
      | mark.november@mail.com | Norbert        | Kolski    | Waiter   | DYNAMIC |
    #PUT
    When LocalUser updates request with job and Butcher value
    And LocalUser updates request with first_name and Filip value
    And LocalUser updates request with last_name and Bernatek value
    And LocalUser updates request with email and filip_bernatek@mail.com value
    And Send PUT request to LocalUsers with Id from response
    Then Response should be non-empty
    And Response status should be 200
    And Save results to datavault
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    And LocalUsers response should have at least one result like
      | email                   | first_name   | last_name   | job       | id |
      | filip_bernatek@mail.com | Filip        | Bernatek    | Butcher   | DYNAMIC |
    #DELETE
    When Send DELETE request to Localusers to remove user id from response
    Then Response status should be 200

  @local
  Scenario: TC04 Create new user on local Server - different way (again)
    #POST
    When Send POST request to Local Server
    Then Response should be non-empty
    And Response status should be 201
    And Save results to datavault
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    And Verify that response contains the same data as stored in DataVault
    #PUT
    When LocalUser updates request with job and Butcher value
    And LocalUser updates request with first_name and Filip value
    And LocalUser updates request with last_name and Bernatek value
    And LocalUser updates request with email and filip_bernatek@mail.com value
    And Send PUT request to LocalUsers with Id from response
    Then Response should be non-empty
    And Response status should be 200
    And Save results to datavault
    #GET
    When Users defines request with query param ID from previous response
    And Send GET request to Local Server
    Then Response should be non-empty
    And Response status should be 200
    And Verify that response contains the same data as stored in DataVault
    #DELETE
    When Send DELETE request to Localusers to remove user id from response
    Then Response status should be 200




