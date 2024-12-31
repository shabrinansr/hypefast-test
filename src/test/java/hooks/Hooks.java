package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;

public class Hooks {
    public static WebDriver driver;
    public static ChromeOptions GenerateDriverChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox",
                "--ignore-ssl-errors=yes",
                "--ignore-certificate-errors",
                "--start-maximized",
                "--disable-gpu",
                "--no-sandbox",
                "--remote-allow-origins=*"
                //"--headless"//
        );
        return options;
    }

    @Before
    public void openBrowser() {
        //Installation library selenium
        driver = new ChromeDriver(GenerateDriverChrome());

        String appUrl = "https://dashboard.melaka.app/register";
        driver.get(appUrl); // for open html link
        driver.manage().window().maximize();//for maximize browser

        System.out.println("---- Start of Scenario ----");

    }

    @After
    public void quit(Scenario scenario) {
        driver.close();
        driver.quit();
    }
}
