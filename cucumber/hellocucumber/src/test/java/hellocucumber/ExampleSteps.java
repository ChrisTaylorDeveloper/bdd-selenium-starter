package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.Assert;

public class ExampleSteps {

    private HomePage homePage;

    private WebDriver driver = new RemoteWebDriver(
        new URL("http://chrome:4444/wd/hub"), new ChromeOptions()
    );

    public ExampleSteps() throws MalformedURLException { }

    @Given("I am on our application Home Page")
    public void iVisitHomepage() {
        driver.get("http://flask");
        this.homePage = new HomePage(driver);
    }

    @When("I press the {string} button")
    public void pressButton(String buttonId) {
        this.homePage.getShowButton().click();
    }

    @Then("I sould see colours list {string}")
    public void assertColoursList(String coloursList) {
        Assert.assertEquals(coloursList, this.homePage.getColoursList());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
