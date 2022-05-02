@advanced-search-wikipedia
Feature: Advanced search process

	Background:
		Given I click to "Advanced search" on the search page
		Then  I should see advanced search container


	@test1
	Scenario: Check advanced search works properly
		When  I enter "cat " on the text field for One of these words
		When  I click to choose File type
		When  I choose "png" as a File type on the dropdown
		When  I click to choose Sorting order
		When  I choose "Creation date – current on top" as a Sorting order on the dropdown
		When  I click to search button
		Then  I should see "cat" as a filter of One of these words on the advanced search preview
		Then  I should see "image/png" as a filter of File type on the advanced search preview
		Then  I should see "Sort by creation date" as a filter of Sorting order on the advanced search preview
		Then  I should see "(Article)" as a first filter of Search in preview
		Then  I should see search results for the chosen filters
		Then  I should see results from sister projects
		Then  I should see pager bottom under the search result page
		Then  I should see the word "cat" for all responded results







