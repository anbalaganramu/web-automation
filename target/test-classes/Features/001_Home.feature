#Author: Anbalagan R
#Email: anbalagan.ramu@mindsprint.org
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Olam Agri Website Automation

@Home
Scenario: Validation for Olam Agri Home page
Given Launch the Olam Agri Home page URL 
And Mouse over Menu1 and print menu title and take a screenshot
And Mouse over Menu2 and print menu title and take a screenshot
When User click on the Wood Product menu under Menu2 should display sub pages of the Wood Product menus
And Mouse over Menu3 and print menu title and take a screenshot
And Mouse over Menu4 and print menu title and take a screenshot
And Mouse over Menu5 and print menu title and take a screenshot
And Scroll to metrics component section and print the title and take a screenshot
And Scroll to text and asset component section1 and print the title and take a screenshot
And Scroll to product carousel component section and print the title and take a screenshot
And Mouse over each product and print the title and take a screenshot



