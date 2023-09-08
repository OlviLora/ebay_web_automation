package step_definitions.search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object_abstractions.search.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definitions.base.BaseSteps;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SearchProductSteps extends BaseSteps {
    SearchPage element = new SearchPage();
    BaseSteps base = new BaseSteps();

    // user search keyword in search bar and click button search
    @When("user search {string} in search bar")
    public void searchKeyword(String keyword) {
        driver.findElement(By.className(element.CLASS_SEARCH_BAR)).sendKeys(keyword);
        driver.findElement(By.className(element.CLASS_SEARCH_BUTTON)).click();
    }

    // verify user redirected to search page
    @Then("user redirect to search page")
    public void userRedirectToSearchPage() {
        // verify section banner, all listing and product is displayed
        driver.findElement(By.className(element.CLASS_BANNER_SEARCH)).isDisplayed();
        driver.findElement(By.xpath(element.XPATH_LIST_SEARCH)).isDisplayed();
        driver.findElement(By.className(element.CLASS_PRODUCT_SECTION)).isDisplayed();
    }

    // user select category on dropdown and click button search
    @When("user select category {string} on dropdown")
    public void userSelectCategoryOnDropdown(String category) {
        WebElement wb = driver.findElement(By.xpath(element.XPATH_CATEGORY_OPTION));
        base.selectOptionElement(wb, category);
        driver.findElement(By.className(element.CLASS_SEARCH_BUTTON)).click();
    }

    // verify page is loading completely
    @Then("user verify page is loaded")
    public void userVerifyPageIsLoaded() {
        // assert true if the return is complete
        assertEquals("complete", base.waitPageLoaded().toLowerCase());
    }

    // verify product with keyword inputted is displayed
    @And("verify the product with keyword {string} is displayed")
    public void verifyTheProductWithKeywordIsDisplayed(String keyword) {
        String keyword_result = driver.findElements(By.xpath(element.XPATH_FIRST_PRODUCT)).get(0).getText();
        // assert true if first product name contains keyword inputted by user
        assertTrue(keyword_result.toLowerCase().contains(keyword.toLowerCase()));
    }
}
