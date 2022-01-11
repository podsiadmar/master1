Feature: Example feature
  
    Background: Init Rest Assured
    Given Setup base request specification
    And Set user credentials for Admin

      @theDogApi
      Scenario: TEST
        When User defines request with query parameter 'api_key' and value '30c33a38-18e0-4a91-98fa-e542e6c1978d'
          And User send GET request to Breeds endpoint to return breed list
        Then Response status should be 200
          And Breed response should have at least one result like
            | id       | description     | auth | https | cors | link                                       | category |
            | 19 | Daily cat facts |      | true  | no   | https://alexwohlbruck.github.io/cat-facts/ | Animals  |
