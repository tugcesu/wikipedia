package stepDefs;/*
 * (C) Copyright 2020 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import page.WikipediaSearchObj;


public class WikipediaSearchSteps extends BaseConfig {

    protected WikipediaSearchObj wikipediaSearch;

    public WikipediaSearchSteps() {
        wikipediaSearch = new WikipediaSearchObj(driver, wait);
    }

    @Given("I click to {string} on the search page")
    public void clickForSearchType(String advanceSearch) {
        wikipediaSearch.clickForSearchType(advanceSearch);
    }

    @Then("I should see advanced search container")
    public void existAdvancedSearchContainer() {
        assertEquals(wikipediaSearch.checkAdvancedSearchContainer(),true);
    }

    @When("I enter {string} on the text field for One of these words")
    public void enterTextToSearch(String textToSearch) throws InterruptedException {
        wikipediaSearch.enterTextToSearch(textToSearch);
    }

    @When("I click to choose File type")
    public void clickToChooseFileType(){
        wikipediaSearch.clickToChooseFileType();
    }

    @When("I choose {string} as a File type on the dropdown")
    public void clickFileType(String fileType){
        wikipediaSearch.clickFileType(fileType);
    }

    @When("I click to choose Sorting order")
    public void clickToChooseSortingOrder() {
        wikipediaSearch.clickToChooseSortingOrder();
    }

    @When("I choose {string} as a Sorting order on the dropdown")
    public void chooseSortingOrder(String creationDate) {
        wikipediaSearch.clickSortingOrder(creationDate);
    }

    @When("I click to search button")
    public void clickToSearchButton() {
        wikipediaSearch.clickToSearchButton();
    }

    @Then("I should see {string} as a filter of One of these words on the advanced search preview")
    public void verifyOneOfTheseWordsPreview(String oneOfTheseWordsPreview) {
        assertEquals(oneOfTheseWordsPreview, wikipediaSearch.getItemText(oneOfTheseWordsPreview));
    }

    @Then("I should see {string} as a filter of File type on the advanced search preview")
    public void verifyFileTypePreview(String fileTypePreview) {
        assertEquals(fileTypePreview, wikipediaSearch.getItemText(fileTypePreview));
    }

    @Then("I should see {string} as a filter of Sorting order on the advanced search preview")
    public void verifySortingOrder(String sortingOrder) {
        assertEquals(sortingOrder, wikipediaSearch.getSortingOrderText(sortingOrder));
    }

    @Then("I should see {string} as a first filter of Search in preview")
    public void verifyFirstFilterOfSearch(String firstFilterOfSearch) {
        assertEquals(firstFilterOfSearch, wikipediaSearch.getFirstFilterOfSearchText());
    }

    @Then("I should see {string} as a second filter of Search in preview")
    public void verifySecondFilterOfSearch(String SecondFilterOfSearch) {
        assertEquals(SecondFilterOfSearch, wikipediaSearch.getSecondFilterOfSearchText());
    }

    @Then("I should see search results for the chosen filters")
    public void verifySearchResults() {
			assertEquals(wikipediaSearch.verifySearchResults(),true);
		}


	  @Then("I should see results from sister projects")
	  public void verifySisterProjects() {
			assertEquals(wikipediaSearch.verifySisterProjects(),true);

	  }
	  @Then("I should see pager bottom under the search result page")
		public void verifyPagerButtom() {
			assertEquals(wikipediaSearch.verifyPagerButtom(),true);

	  }

	  @When("I enter {string} on the search blank")
	  public void enterWordOnTheSearchBlank(String enterWord){
			wikipediaSearch.enterWordOnTheSearchBlank(enterWord);
	  }

	  @Then("I should see search in container")
	  public void existSearchInContainer() {
			assertEquals(wikipediaSearch.existSearchContainer(),true);

	  }

	  @When("I click to {string} checkbox on the search in option")
	  public void clickCheckBox(String checkBoxName) {
		wikipediaSearch.clickCheckBox(checkBoxName);

	  }

	  @Then("I should see There is a page named {string} on Wikipedia on the search result page")
	  public void verifySearchedWord(String searchedWord) {
		  assertEquals(searchedWord, wikipediaSearch.verifySearchedWord());
	  }

	  @Then("I should see the word {string} for all responded results")
		public void checkSearchResult(String searchText) {
    	assertEquals(true, wikipediaSearch.checkResults(searchText));

	   }



	@After
	public void closeDriver(){
		driver.quit();
	}
}
