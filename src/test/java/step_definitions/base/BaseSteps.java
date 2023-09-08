package step_definitions.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static WebDriver driver;

    public void setDriver() {
        // set up chromedriver locally
        System.setProperty("web-driver.chrome.driver", "/Users/olvilora/Documents/Automation/chromedriver/chromedriver_mac_arm64/chromedriver");

        //Initiating the chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("test-type");
        options.addArguments("enable-strict-powerful-feature-restrictions");
        options.addArguments("disable-geolocation");
        driver = new ChromeDriver(options);
        // wait 30 seconds for page to load at first to prevent flaky
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openURL(String URL){
        driver.get(URL);
    }

    public void scrollDown(int index){
        // scrolling down on web page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+index+")", "");
    }

    public void selectOptionElement(WebElement element, String text){
        // select option in list of options
         Select el = new Select(element);
         el.selectByVisibleText(text);
    }

    public String waitPageLoaded(){
        // wait 20 seconds page to load completely
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // verify the page is loaded completely by check the return is complete
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object result = js.executeScript("return document.readyState", "");
        return result.toString();
    }

    public void closeBrowser(){
        // quit browser
        driver.quit();
    }
}
