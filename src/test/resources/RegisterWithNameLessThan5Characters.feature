Feature: Register Account

  Scenario: Register with name less than 5 characters
    Given User open register page
    When Input name less than 5 characters
    And User click TnC check box
    Then Warning message Wajib diisi, min. 5 karakter. turn to red color