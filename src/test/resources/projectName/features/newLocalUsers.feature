Feature: Local Server Users Feature
    Post data:
    | email                  | first_name     | last_name | job      |
    | mark.november@mail.com | Norbert        | Kolski    | Waiter   |

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

    @local
    Scenario: TC01 - create user, get data, change data, delete data
        #POST
        When Send POST request to Local Server
        Then Response status should be 201
            And Save ID from Post to TestContext
        #GET
        When Users defines request with query param ID from previous response
            And Send GET request to Local Server
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
            And Response status should be 200
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
            And Response should be empty






