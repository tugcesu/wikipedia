package page;/*
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

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaSearchObj{
    ChromeDriver driver;
    WebDriverWait wait;

    @FindBy(id = "#content")
    private WebElement wikipediaSearch;

    public WikipediaSearchObj(ChromeDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }

    private WebElement wikipediaSearch() {
        return driver.findElement(By.cssSelector("#content"));
    }

    public void clickForSearchType(String advanceSearch) {
        wikipediaSearch().findElement(By.xpath("//label[contains(text(),'" + advanceSearch + "')]")).click();
    }

    public boolean checkAdvancedSearchContainer() {
        return wikipediaSearch().findElement(By.cssSelector(".mw-advancedSearch-fieldContainer")).isDisplayed();
    }


    public void enterTextToSearch(String textToSearch) throws InterruptedException {
        wikipediaSearch().findElement(By.id("ooui-45")).sendKeys(textToSearch);
        Thread.sleep(300);
    }

    public void clickToChooseFileType() {
        wikipediaSearch().findElement(By.id("ooui-64")).click();
    }

    public void clickFileType(String fileType) {
        By e2= By.xpath("//span[contains(text(),'" + fileType + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(e2));
        wikipediaSearch().findElement(e2).click();
    }

    public void clickToChooseSortingOrder() {
        wikipediaSearch().findElement(By.id("ooui-82")).click();
    }

    public void clickSortingOrder(String creationDate) {
        By e3= By.xpath("//span[contains(text(),'" + creationDate + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(e3));
        wikipediaSearch().findElement(e3).click();
    }

    public void clickToSearchButton() {
        wikipediaSearch().findElement(By.cssSelector(".oo-ui-inputWidget-input.oo-ui-buttonElement-button")).click();
    }

    public String getItemText(String searchText) {
        return wikipediaSearch().findElement(By.xpath("//bdi[contains(text(),'" + searchText + "')]"))
                .getText();
    }

    public String getSortingOrderText(String text) {
        return wikipediaSearch().findElement(By.xpath("//span[contains(text(),'" + text + "')]")).getText();
    }

    public String getFirstFilterOfSearchText() {
        return wikipediaSearch().findElement(By.cssSelector(".mw-advancedSearch-namespacesPreview-previewPill:nth-child(2)"))
                .getText();

    }

    public String getSecondFilterOfSearchText(){
        return wikipediaSearch().findElement(By.cssSelector(".mw-advancedSearch-namespacesPreview-previewPill:nth-child(3)"))
                .getText();
    }

    public boolean verifySearchResults() {
        By e4= By.cssSelector(".mw-search-results:nth-child(2)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(e4));
        return wikipediaSearch().findElement(e4).isDisplayed();
    }


	   public boolean verifySisterProjects(){
		    By e5= By.cssSelector(".mw-search-pager-bottom:nth-child(5)");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(e5));
		    return wikipediaSearch().findElement(e5).isDisplayed();
	   }


	    public boolean verifyPagerButtom(){
		    By e6= By.cssSelector("#mw-interwiki-results");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(e6));
		    return wikipediaSearch().findElement(e6).isDisplayed();

	    }

	    public void enterWordOnTheSearchBlank(String enterWord){
		   WebElement e9= driver.findElementByCssSelector("#ooui-php-1");
		   e9.click();
		   e9.sendKeys(enterWord);

	    }


	    public boolean existSearchContainer(){
    	By e7= By.cssSelector(".mw-advancedSearch-namespacesPreview");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(e7));
		  return wikipediaSearch().findElement(e7).isDisplayed();
	    }

	     public void clickCheckBox(String checkBoxName) {
		   By e8= By.xpath("//span[contains(text(),'" + checkBoxName + "')]");
		   wait.until(ExpectedConditions.visibilityOfElementLocated(e8));
		   wikipediaSearch().findElement(e8).click();
	     }

	     public String verifySearchedWord() {
		   return wikipediaSearch().findElement(By.cssSelector(".mw-search-exists:nth-child(1) b:nth-child(1) > a:nth-child(1)"))
														.getText();

	     }

	     public boolean checkResults(String text) {
		   List<WebElement> resultList = wikipediaSearch().findElements(By.cssSelector("div.searchresult"));
		    Boolean isExist = true;
		     for (WebElement result : resultList)
		    {
			     if(!result.getText().toLowerCase().contains(text.toLowerCase())){
				    isExist = false;
			     }
		    }
		      return isExist;

	      }
}
