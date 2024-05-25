/** */
package ctd.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class HomePage {

    /** */
    static final int FIVE_SECONDS = 5;

    /** */
    private final WebDriver driver;

    /** */
    private final String titleStart = "bdd";

    /** */
    private final By headerBy = By.tagName("h1");

    /** */
    private final By showButtonBy = By.id("show");

    /** */
    private final By colourListBy = By.id("colours-list");

    /** @param d */
    public HomePage(final WebDriver d) {
        this.driver = d;
        Duration fiveSecs = Duration.ofSeconds(FIVE_SECONDS);

        new WebDriverWait(d, fiveSecs).until(
            new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(titleStart);
                }
            }
        );
    }

    /** @return tbc */
    public WebElement getShowButton() {
        return driver.findElement(showButtonBy);
    }

    /** @return tbc */
    public String getHeaderMessage() {
        List<WebElement> headers = driver.findElements(headerBy);
        Assert.assertEquals("Headers", 1, headers.size());
        return headers.get(0).getText();
    }

    /** @return tbc */
    public String getColoursList() {
        return driver.findElement(colourListBy).getText();
    }
}
