package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import utils.Base;
import java.util.List;

public class AmazonSteps extends Base {
    JavascriptExecutor js;

    @Given("I launch the Amazon website")
    public void launch_amazon() {
        launchBrowser("https://www.amazon.in");
    }

    @Then("The title should contain {string}")
    public void title_should_contain(String expected) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Then("Product results should be displayed")
    public void product_results_should_be_displayed() {
        List<WebElement> results = driver.findElements(By.cssSelector(".s-title-instructions-style"));
        Assert.assertTrue(results.size() > 0);
    }

    @Then("Search results should belong to the Books category")
    public void books_category_should_be_displayed() {
        String resultText = driver.findElement(By.cssSelector("span.a-color-state")).getText();
        Assert.assertTrue(resultText.toLowerCase().contains("books"));
    }

    @When("I scroll down the page")
    public void i_scroll_down_the_page() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Then("The page should scroll successfully")
    public void the_page_should_scroll_successfully() {
        Long scrolledY = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(scrolledY > 0);
    }
}
