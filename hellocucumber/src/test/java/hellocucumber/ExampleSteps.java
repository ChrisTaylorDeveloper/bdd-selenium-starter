package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;
import java.time.Duration;
import java.net.URL;

public class ExampleSteps {

    ChromeOptions chromeOptions = new ChromeOptions();
    // e.g. chromeOptions.setCapability("browserVersion", "67");
    // e.g. chromeOptions.setCapability("platformName", "Windows XP");
    WebDriver driver = new RemoteWebDriver(new URL("http://chrome:4444/wd/hub"), chromeOptions);

    public ExampleSteps() throws MalformedURLException {
    }

    @Given("I am on the Google search page")
    public void I_visit_google() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(query);
        element.submit(); // WebDriver will find form from element.
   }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        Duration tenSecTimeout = Duration.ofSeconds(10);
        new WebDriverWait(driver, tenSecTimeout).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
           }
       });
   }

   @After()
   public void closeBrowser() {
       driver.quit();
   }
}
