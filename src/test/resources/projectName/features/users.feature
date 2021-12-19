Feature: Users feature

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin
#
#  @reqres
#  Scenario: TC01 Send Get request to Users
#    When Send Get request to users
#    Then Response status should be 200
#
#  @reqres
#  Scenario: TC02 Send Post request to Users
#    When Send Post request to users
#    Then Response status should be 201
#    And  Response should be non-empty
#
  @reqres
  Scenario: TC03 Send Get request to Users with parameters
    When Send Get request to users
    Then Response status should be 200
      And User response should have at least one result like
        | ID | EMAIL                  | FIRST_NAME | LAST_NAME | AVATAR                                  |
        | 2  | janet.weaver@reqres.in | Janet      | Weaver    | https://reqres.in/img/faces/2-image.jpg |







