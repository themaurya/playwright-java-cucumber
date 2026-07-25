Feature: Verify SCRUM-1 two wheeler insurance quote flow

  @smoke
  Scenario: Verify user can start a two wheeler insurance quote
    Given user navigates to "https://www.icicilombard.com/"
    When user enters "MH04GJ788" vehicle number in Two Wheeler Insurance Quote page
    And user enters "9930991616" mobile number in Two Wheeler Insurance Quote page
    Then verify Get Quote button is enabled in Two Wheeler Insurance Quote page
    When user clicks Get Quote button in Two Wheeler Insurance Quote page
    Then verify quote details page or OTP verification step is displayed in Two Wheeler Insurance Quote page
