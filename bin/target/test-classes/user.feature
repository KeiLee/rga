Feature: login
 
  	Scenario: valid creditial
     Given I pass email "k" password "000"
     When I click login
     Then the creditials should be matched and login successfully
     
	Scenario: valid creditial
     Given I pass email "k" password "123"
     When I click login
     Then the creditials should be invalid and display error
  
     
     
