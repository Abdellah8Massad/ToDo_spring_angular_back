Feature: Hear shout

  Scenario: Listener is within range
    Given chambreA Lucy is located 15 metres from Sean
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean’s message

  Scenario: Listener is within range
      Given ChambreB Lucy is located 15 metre from Sean
      When Sean shouts "free bagels at Sean's"
      Then Lucy hears Sean’s message

  Scenario: Listener is within range
      Given chambreA Lucy is position 15 metres from Sean
      When Sean shouts "free bagels at Sean's"
      Then Lucy hears Sean’s message