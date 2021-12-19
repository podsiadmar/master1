#Feature: Example feature
#
#  Background: Init Rest Assured
#    Given Setup base request specification
#  @dev
#  Scenario: TC01 Send GET request with title Cat should return Cat facts
#    When Set user credentials for Admin
#      And User defines request with query parameter 'title' and value 'Cat'
#      And Send GET request to entries
#    Then Response status should be 200
#      And Entries response should have at least one result like
#        | api       | description     | auth | https | cors | link                                       | category |
#        | Cat Facts | Daily cat facts |      | true  | no   | https://alexwohlbruck.github.io/cat-facts/ | Animals  |