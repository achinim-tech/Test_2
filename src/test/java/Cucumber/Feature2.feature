Feature: test Feature

  Background:Navigate Landing Page
    When I navigate to the application

  @Test1
  Scenario Outline: Login3
    When I login with username "<username>" and "<password>"

    Examples:
      |username|password|
      | Achini10 |Swivel@123|


