Feature: Local Server Users Feature

  Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

  @local
  Scenario: TC01 Get users from Local Server
    When Send GET request to Local Server
    Then Response status should be 200