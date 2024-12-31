Feature: Register Account

  Scenario: Register with invalid confirm password
    Given User open register page
    When Input valid password
    And Input invalid confirm password
    And User click TnC check box
    Then Show error message Belum sesuai dengan kata sandi.