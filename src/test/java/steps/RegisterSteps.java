package steps;
import hooks.Hooks;
import io.cucumber.java.en.*;
import org.hypefast.PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterSteps {
    private final WebDriver driver = Hooks.driver;
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("User open register page")
    public void openRegisterUrl(){}

    @When("Input valid password")
    public void inputValidPassword(){
        registerPage.inputPassword();
    }

    @And("Input invalid confirm password")
    public void inputInvalidConPass(){
        registerPage.inputConfirmPassword();
    }

    @And("User click TnC check box")
    public void clickTnC(){
        registerPage.clickTnC();
    }

    @Then("Show error message Belum sesuai dengan kata sandi.")
    public void assertConPassError(){
        registerPage.assertConfirmPassError();
    }

    @When("Input name less than 5 characters")
    public void inputInvalidName(){
        registerPage.inputInvalidName();
    }

    @Then("Warning message Wajib diisi, min. 5 karakter. turn to red color")
    public void assertInvalidName(){
        registerPage.assertInvalidName();
        registerPage.assertColorInvalidName();
    }
    @When("Input phone number less than 10 numbers")
    public void inputInvalidPhone(){
        registerPage.inputPhoneNumber();
    }
    @Then("Warning message Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. turn to red color")
    public void assertInvalidPhone(){
        registerPage.assertInvalidPhone();
        registerPage.assertColorInvalidPhone();
    }
}
