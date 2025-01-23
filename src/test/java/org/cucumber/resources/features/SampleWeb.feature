@ExecuteAll_Web
  Feature: Verify validation messages from login web page

    @BDDTest_Scenario
    Scenario Outline: Verify login errors messages are displayed
      Given launch application singup page
      And enter username "<userName>"
      And enter password "<password>"
      When I click submit button
      Then error message "<errorMsg>" should be displayed

      Examples:
        | userName | password    | errorMsg                  |
        | Peter    | Password123 | Your username is invalid! |
        | student  | Password456 | Your password is invalid! |

