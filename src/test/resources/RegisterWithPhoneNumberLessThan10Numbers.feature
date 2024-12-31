Feature: Register Account

  Scenario: Register with phone number less than 10 numbers
    Given User open register page
    When Input phone number less than 10 numbers
    And User click TnC check box
    Then Warning message Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. turn to red color