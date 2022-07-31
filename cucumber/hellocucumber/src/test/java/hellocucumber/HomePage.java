package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class HomePage {

    protected WebDriver driver;

    private String titleStart = "bdd";
    private By headerBy = By.tagName("h1");
    private By showButtonBy = By.id("show");
    private By colourListBy = By.id("colours-list");

    public HomePage(WebDriver driver){

        this.driver = driver;
        Duration fiveSecs = Duration.ofSeconds(5);

        new WebDriverWait(driver, fiveSecs).until(
            new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(titleStart);
                }
            }
        );
    }

    public WebElement getShowButton() {
        return driver.findElement(showButtonBy);
    }

    public String getHeaderMessage() {
        return driver.findElement(headerBy).getText();
    }

    public String getColoursList() {
        return driver.findElement(colourListBy).getText();
    }
}
