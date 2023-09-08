package step_definitions.search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import object_abstractions.search.CategoryPage;
import org.openqa.selenium.By;
import step_definitions.base.BaseSteps;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SearchViaCategorySteps extends BaseSteps {
    BaseSteps base = new BaseSteps();
    CategoryPage element = new CategoryPage();

    // run this method to set up browser driver before start the test
    @Given("user open the browser")
    public void setDriver(){
        base.setDriver();
    }

    // open homepage
    @When("user open ebay homepage")
    public void openHomepage() {
        base.openURL("https://www.ebay.com/");
    }

    // verify user is on homepage
    @And("user is on homepage")
    public void verifyOnHomepage() {
        // check if home menu is active
        String menu = driver.findElement(By.xpath(element.XPATH_HOME_MENU)).getText();
        assertEquals("home", menu.toLowerCase());
    }

    // user click dropdown shop by category and click category
    @When("user navigate to search by category {string}")
    public void navigateToSearchCategory(String category){
        driver.findElement(By.id(element.ID_SHOP_BY_CATEGORY_DROPDOWN)).click();
        driver.findElement(By.xpath("//*[contains(@class, 'scnd') and text() = '"+category+"']")).click();
    }

    // verify is redirected to right category
    @Then("user redirect to category {string} page")
    public void verifyOnCategoryPage(String category){
        // verify category selected is displayed
        String sub_cat = driver.findElements(By.xpath(element.XPATH_SUB_CATEGORY_ACCESSORIES)).get(2).getText();
        assertEquals(category.toLowerCase(), sub_cat.toLowerCase());
    }

    // user click subcategory
    @Then("user click section {string}")
    public void clickSectionSubCategory(String sub_category){
       driver.findElement(By.xpath(element.XPATH_SUB_CATEGORY_SMARTPHONE)).click();
    }

    // verify user redirected to search listing page
    @Then("user redirect to search listing product {string}")
    public void verifyOnListProductPage(String sub_category){
        // verify the subcategory selected is displayed
        String sub_cat = driver.findElements(By.xpath(element.XPATH_SUB_CATEGORY_ACCESSORIES)).get(3).getText();
        assertEquals(sub_category.toLowerCase(), sub_cat.toLowerCase());
        // verify section brand &product, storage and list products is displayed
        driver.findElement(By.xpath(element.XPATH_SECTION_BRAND)).isDisplayed();
        driver.findElements(By.className(element.XPATH_IMAGE_PRODUCTS)).get(0).isDisplayed();
        driver.findElement(By.xpath(element.XPATH_SECTION_STORAGE)).isDisplayed();
        // scroll down to see the section list products
        base.scrollDown(500);
        driver.findElements(By.className(element.CLASS_LIST_PRODUCTS)).get(0).isDisplayed();
    }

    @When("user click all filters")
    public void userApplyMultipleFilter() {
        driver.findElement(By.className(element.CLASS_ALL_FILTER_BUTTON)).click();
    }

    @Then("user verify filter pop up window is displayed")
    public void VerifyFilterPopUpWindowIsDisplayed() {
        driver.findElement(By.className(element.CLASS_FILTER_WINDOW)).isDisplayed();
    }

    @And("user apply filter {string} {string} {string}")
    public void userApplyFilter(String condition, String price, String location) {
        // click filter condition and select new
        driver.findElement(By.xpath(element.XPATH_CONDITION_FILTER)).click();
        driver.findElement(By.xpath(element.XPATH_CONDITION_NEW)).click();
        // click filter price and fill from IDR 5000000
        driver.findElement(By.xpath(element.XPATH_PRICE_FILTER)).click();
        driver.findElement(By.className(element.CLASS_PRICE_FROM)).sendKeys(price);
        // click filter location and select Asia
        driver.findElement(By.xpath(element.XPATH_LOCATION_FILTER)).click();
        driver.findElement(By.xpath(element.XPATH_LOCATION_ASIA)).click();

        // click apply button
        driver.findElement(By.xpath(element.XPATH_APPLY_BUTTON)).click();
    }

    @Then("user see product listing and filter {string} {string} {string} applied")
    public void verifyFilterApplied(String condition, String price, String location) {
        // check string 3 filters applied is displayed
        String str_filter_result = driver.findElement(By.xpath(element.XPATH_STR_FILTER_APPLIED)).getText();
        assertEquals("3 filters applied", str_filter_result);

        // click dropdown and verify the filter inputted by user is same with the result
        driver.findElement(By.xpath(element.XPATH_BTN_FILTER_APPLIED)).click();
        String condition_result = driver.findElements(By.className(element.CLASS_RESULT_FILTER)).get(0).getText();
        String price_result = driver.findElements(By.className(element.CLASS_RESULT_FILTER)).get(1).getText();
        String location_result = driver.findElements(By.className(element.CLASS_RESULT_FILTER)).get(2).getText();
        assertTrue(condition_result.toLowerCase().contains(condition.toLowerCase()));
        assertTrue(price_result.contains(price));
        assertTrue(location_result.toLowerCase().contains(location.toLowerCase()));
    }

    // run this method to close browser after finish run the test
    @And("user close the browser")
    public void closeBrowser(){
        base.closeBrowser();
    }
}
