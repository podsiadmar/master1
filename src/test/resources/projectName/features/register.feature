#Feature: Register feature
#
#  Background: Init Rest Assured
#    Given Setup base request specification
#    And Set user credentials for Admin
#
#  @devReqres
#    Scenario: TC01 Register new user
#      When Send POST request to register new User
#      Then Response status should be 200