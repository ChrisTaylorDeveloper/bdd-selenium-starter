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
import org.junit.Assert;

public class ExampleSteps {

    ChromeOptions chromeOptions = new ChromeOptions();
    // e.g. chromeOptions.setCapability("browserVersion", "67");
    // e.g. chromeOptions.setCapability("platformName", "Windows XP");
    WebDriver driver = new RemoteWebDriver(new URL("http://chrome:4444/wd/hub"), chromeOptions);

    public ExampleSteps() throws MalformedURLException {
    }

    @Given("I am on our application Home Page")
    public void I_visit_homepage() {
        driver.get("http://flask");
    }

    @When("I press the {string} button")
    public void press_button(String button_id) {
        WebElement element = driver.findElement(By.id(button_id));
        element.click();
    }

    @Then("I sould see colours list {string}")
    public void assert_colours_list(String colours_list) {
        Assert.assertSame(
            true,
            driver.findElement(By.id("colours-list")).getText().equalsIgnoreCase(colours_list)
        );
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
