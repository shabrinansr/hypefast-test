package org.hypefast.PageObject;
import org.hypefast.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    // Constructor to initialize the page elements
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //Define Data
    private static final String VALID_PASS = "Abcd1234";
    private static final String INVALID_CONPASS = "Dcba4321";
    private static final String INVALID_NAME = "Aca";
    private static final String INVALID_NUMBER = "888123";

    //Define selectors
    @FindBy(id = "input-:Rd6l6:")
    private WebElement passInput;
    @FindBy(id = "input-:Rf6l6:")
    private WebElement confirmPassInput;
    @FindBy(id = "register__checkbox__tnc")
    private WebElement TnC;
    @FindBy(xpath = "(//p[normalize-space()='Belum sesuai dengan kata sandi.'])[1]")
    private WebElement confirmPassError;
    @FindBy(id = "input-:R36l6:")
    private WebElement nameInput;
    @FindBy(xpath = "(//p[normalize-space()='Wajib diisi, min. 5 karakter.'])[1]")
    private WebElement invalidName;
    @FindBy(id = "input-:R156l6:")
    private WebElement phoneInput;
    @FindBy(xpath = "(//p[contains(text(),'Wajib diisi. Nomor telepon tidak boleh kurang dari')])[1]")
    private WebElement invalidPhone;

    //Define Actions
    public void inputPassword(){
        type(passInput, VALID_PASS);
    }
    public void inputConfirmPassword(){
        type(confirmPassInput, INVALID_CONPASS);
    }
    public void clickTnC(){
        click(TnC);
    }
    public void assertConfirmPassError() {
        assertElementDisplayed(confirmPassError);
        String actualMessage = getElementText(confirmPassError);
        String expectedMessage = "Belum sesuai dengan kata sandi.";
        assertTrue("The error message is not as expected: " + actualMessage,
                actualMessage.equals(expectedMessage));
    }
    public void inputInvalidName(){
        type(nameInput, INVALID_NAME);
    }
    public void assertInvalidName(){
        assertElementDisplayed(invalidName);
        String actualMessage = getElementText(invalidName);
        String expectedMessage = "Wajib diisi, min. 5 karakter.";
        assertTrue("The error message is not as expected: " + actualMessage,
                actualMessage.equals(expectedMessage));
    }
    public void assertColorInvalidName() {
        String expectedColor = "rgba(235, 30, 54, 1)"; // Warning message color
        assertElementColor(invalidName, expectedColor);
    }
    public void inputPhoneNumber(){
        type(phoneInput, INVALID_NUMBER);
    }
    public void assertInvalidPhone(){
        assertElementDisplayed(invalidPhone);
        String actualMessage = getElementText(invalidPhone);
        String expectedMessage = "Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter.";
        assertTrue("The error message is not as expected: " + actualMessage,
                actualMessage.equals(expectedMessage));
    }
    public void assertColorInvalidPhone() {
        String expectedColor = "rgba(235, 30, 54, 1)"; // Warning message color
        assertElementColor(invalidPhone, expectedColor);
    }

}
