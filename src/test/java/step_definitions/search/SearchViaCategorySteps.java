package step_definitions.search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import object_abstractions.search.CategoryPage;
import org.openqa.selenium.By;
import step_definitions.base.BaseSteps;

import static org.testng.AssertJUnit.assertEquals;

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

    // run this method to close browser after finish run the test
    @And("user close the browser")
    public void closeBrowser(){
        base.closeBrowser();
    }
}
