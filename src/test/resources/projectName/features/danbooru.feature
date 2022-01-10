Feature: Danbooru

  Background: Init Rest Assured
    Given Setup base request specification

    @danbooru
    Scenario: TEST
      When User defines request with query parameter 'login' and value 'mpodsiadly'
        And User defines request with query parameter 'api_key' and value 'tV9EwCupMvEDsT7u568Wcejv'
        And User sends GET request to Danbooru to retrieve post with 6 ID
