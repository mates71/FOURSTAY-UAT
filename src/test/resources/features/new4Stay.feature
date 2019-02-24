@Smoke
Feature: new 4Stay Login

Background: 
	Given I am on the fourstay login dialog 
	
Scenario Outline: Verify host user information 
	And I enter email "<email>" 
	And I enter password "<password>" 
	When I click on the login button 
	Then the user name should be "<name>" 

Examples: 
		|name      		|  email                   		|  password        |
		|Amy Fowler		| testafowler@test.mail.com		|    password      | 
		|Sheldon Cooper |testscooper@test.mail.com  	|     password     |   		
		|Orlando Wolf   |	OrlandoWolf@test.mail.com	|Orlandob74cf      |