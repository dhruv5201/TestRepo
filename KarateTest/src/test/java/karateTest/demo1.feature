
Feature: Testing User Details


  
  
  Scenario: Validate user name
    Given url 'https://jsonplaceholder.typicode.com/users'
    When method GET
    Then status 200
    And match response[0].username == 'Bret'
    And match response[0].address.city == 'Gwenborough'
    And match response[0].address.geo.lng == '81.1496'
   