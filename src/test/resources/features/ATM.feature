@money
Feature: WithDraw money from ATM

Scenario: A user witdraw money from ATM
	Given Jack has valid credit or debit card
	And His accound balance is $500
	When He insert his card
	And witdraw $150
	Then ATM should return $150
	And Now his balance is $350

