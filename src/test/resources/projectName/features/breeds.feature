Feature: Example feature
  
    Background: Init Rest Assured
      Given Setup base request specification
        And Set user credentials for Admin
        And Attach header to request specification with key 'x-api-key' and value '30c33a38-18e0-4a91-98fa-e542e6c1978d'

#      @theDogApi
#      Scenario: TEST
#        When User send GET request to Breeds endpoint to return breed list
#        Then Response status should be 200
        
      @theDogApi  
      Scenario: Send post to favourites
        When  User defines body parameter image_id with value 9ccXTANkb
          And User defines body parameter sub_id with value mojeKonto1
          And User sends POST request to Favourites endpoint to save image as favourite
        Then Response status should be 200