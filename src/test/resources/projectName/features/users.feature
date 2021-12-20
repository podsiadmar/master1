Feature: Users feature

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

  @reqres
  Scenario: TC01 Send Get request to Users
    When Send GET request to users
    Then Response status should be 200

  @reqres
  Scenario: TC02 Send Post request to Users
    When Send POST request to users
    Then Response status should be 201
    And  Response should be non-empty

  @reqres
  Scenario: TC03 Send Get request to Users with parameters
    When User defines request with query parameter 'id' and value '2'
      And Send GET request to users
    Then Response status should be 200
      And Users response should have at least one result like
        | id | email                  | first_name | last_name | avatar                                  |
        | 2  | janet.weaver@reqres.in | Janet      | Weaver    | https://reqres.in/img/faces/2-image.jpg |

  @reqres
  Scenario: TC04 Send put request to Users with updated data
    When User defines request with query parameter 'id' and value '2'
    And User updates request with job and manager value
    And Send PUT request to users
    Then Response status should be 200







