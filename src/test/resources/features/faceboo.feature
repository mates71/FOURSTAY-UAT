@facebook
Feature: -Scenario outline


Scenario Outline: − Login functionality for a social networking site.

Given user navigates to Facebook
When I enter Username as "<email>" and Password as "<psw>"
Then login should be unsuccessful

Examples:

| email		  | psw | 
| username1@gmail.com | password1 | 
| username2gmail.com  | password2 |
| username3gmail.com  | password3 | 
| username4gmail.com  | password4 |