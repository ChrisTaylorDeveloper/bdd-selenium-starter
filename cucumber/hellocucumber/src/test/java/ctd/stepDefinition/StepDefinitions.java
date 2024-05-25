package ctd.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import ctd.pages.HomePage;

public class StepDefinitions {

    /** */
    private HomePage homePage;

    /** */
    public StepDefinitions() throws MalformedURLException { }

    /** */
    private WebDriver driver = new RemoteWebDriver(
        new URL("http://chrome:4444/wd/hub"), new ChromeOptions()
    );

    /** */
    @Given("I am on our application Home Page")
    public void iVisitHomepage() {
        driver.get("http://flask");
        this.homePage = new HomePage(driver);
    }

    /** @param buttonId */
    @When("I press the {string} button")
    public void pressButton(final String buttonId) {
        this.homePage.getShowButton().click();
    }

    /** @param coloursList */
    @Then("I sould see colours list {string}")
    public void assertColoursList(final String coloursList) {
        Assert.assertEquals(coloursList, this.homePage.getColoursList());
    }

    /** */
    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
