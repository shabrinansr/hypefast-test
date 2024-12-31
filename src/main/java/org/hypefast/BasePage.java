package org.hypefast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int WAIT = 50;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize page elements
    }

    // Click on an element
    public void click(WebElement element) {
        waitForElementVisible(element);
        waitForElementClickable(element);
        element.click();
    }
    // Type text into an element
    public void type(WebElement element, String text) {
        waitForElementVisible(element);
        waitForElementClickable(element);
        element.sendKeys(text);
    }
    public void assertElementDisplayed(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
        assert e.isDisplayed();
    }
    public String getElementText(WebElement element) {
        return element.isDisplayed() ? element.getText() : "";
    }
    public void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
    // Wait for element to be visible
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    // Wait for element to be clickable
    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void assertElementColor(WebElement element, String expectedColor) {
        // Get color
        String actualColor = element.getCssValue("color");

        // Compare actual and expected result
        if (!actualColor.equals(expectedColor)) {
            throw new AssertionError("Expected color: " + expectedColor + " but found: " + actualColor);
        }
    }
}
