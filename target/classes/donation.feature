Feature: Make Donation
  As a donator
  I can choose a charity
  So I can make a donation

  Background: 
    Given I have these bank accounts
      | bankAccount | name           |
      |         555 | Dan Pickles    |
      |         777 | Howard Johnson |
      |         888 | Randolph Scott |

  Scenario Outline: 
    Given I have a bank account
    And I have <balance> dollars
    When I donate <donation> dollars
    Then I have <remaining> dollars left

    Examples: 
      | balance | donation | remaining |
      |    1000 |      200 |       800 |
      |    5000 |     1000 |      4000 |
      |    3000 |     2000 |      1000 |
      |       0 |      500 |      -500 |
      |     600 |      600 |         0 |

  Scenario Outline: 
    Given I have a bank account
    And I have <balance> dollars
    When I try to donate <donation> dollars
    Then I have insufficient <remaining> dollars left

    Examples: 
      | balance | donation | remaining |
      |       0 |      500 |      -500 |

  Scenario Outline: 
    Given I have a bank account
    And I have <balance> dollars
    When I try to donate <donation> dollars
    Then I recieve a warning message of having no <remaining> dollars after donation

    Examples: 
      | balance | donation | remaining |
      |     600 |      600 |         0 |
