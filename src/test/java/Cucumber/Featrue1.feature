Feature: test Feature

  Background:Navigate Landing Page
    When I navigate to the application

    @Test
    Scenario Outline: Login
      When I login with username "<username>" and "<password>"

      Examples:
      |username|password|
      | Achini10 |Swivel@123|


  @Test1
  Scenario Outline: Login2
    When I login with username "<username>" and "<password>"
    And I navigate to HomePage

    Examples:
      |username|password|
      | Achini10 |Swivel@123|