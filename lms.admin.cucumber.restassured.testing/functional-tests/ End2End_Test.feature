Feature: End to End Tests for Lms admin rest service API

Scenario: Authorized User is able to view all program list
	When load all the programs
	Then all programs are displayed
	
Scenario: Authorized User is able to add program
	When Authorized User add program
	Then program is added

Scenario: Authorized User is able to view program
	When Authorized User view program
	Then program is displayed

Scenario: Authorized User is able to update program
	When Authorized User update program
	Then program is updated

Scenario: Authorized User is able to delete program
	When Authorized User delete program
	Then program is deleted



	


