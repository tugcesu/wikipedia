@search-wikipedia
Feature: Search in process

	Background:
		Given I click to "Search in" on the search page
		Then  I should see search in container


	@test2
	Scenario: Check 'search in' works properly
		When  I click to "General Help" checkbox on the search in option
		When  I enter "Dog" on the search blank
		When  I click to search button
		Then  I should see "(Article)" as a first filter of Search in preview
		Then  I should see "Wikipedia" as a second filter of Search in preview
		Then  I should see search results for the chosen filters
		Then  I should see There is a page named "Dog" on Wikipedia on the search result page
		Then  I should see results from sister projects
		Then  I should see pager bottom under the search result page
		Then  I should see the word "Dog" for all responded results








