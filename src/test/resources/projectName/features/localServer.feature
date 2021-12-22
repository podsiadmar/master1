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
    When Send POST request to Local Server
    Then Response should be non-empty
    And Response status should be 201
    When User defines request with query parameter 'id' from response body
    When Save the response data

