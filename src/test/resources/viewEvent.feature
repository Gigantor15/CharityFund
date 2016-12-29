Feature: Check on event
  As a charity manager
  I can view running events
  So that I can view their progress

  Scenario Outline: 
    Given I have an event
    And I check on the event <goal>
    When I see how much has been <donated>
    Then I can view how much is <remaining> until the goal

    Examples: 
      | goal | donated | remaining |
      | 5000 |    2500 |      2500 |
      | 1000 |     700 |       300 |

  Scenario Outline: 
    Given I have an event
    And I check on the event <goal>
    When I see how much has been <donated>
    Then I see the goal has nothing <remaining>

    Examples: 
      | goal  | donated | remaining |
      |  7000 |    7000 |         0 |
      |   300 |     300 |         0 |
      | 10000 |   10000 |         0 |

  Scenario Outline: 
    Given I have an event
    And I check on the event <goal>
    When I see how much has been <donated>
    Then I see the goal has been <exceeded>

    Examples: 
      | goal  | donated | exceeded |
      |  4000 |    5500 |     1500 |
      |   200 |     800 |      600 |
      | 17000 |   20000 |     3000 |
