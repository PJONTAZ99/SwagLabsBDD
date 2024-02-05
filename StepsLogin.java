
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class StepLogin {
    WebDriver webDriver;
    WebDriverWait wait;






    @Given("I go to login page")
    public void iGoToLoginPage() {

            System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
            webDriver = new ChromeDriver();
            wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));


        webDriver.get("https://www.saucedemo.com");
    }

    @When("I type {string} as Username and {string} as Password")
    public void iTypeAsUsernameAndAsPassword(String username, String password) {
        WebElement element = webDriver.findElement(By.id("user-name"));
        element.sendKeys(username);
        WebElement element1 = webDriver.findElement(By.id("password"));
        element1.sendKeys(password);
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        WebElement element = webDriver.findElement(By.id("login-button"));
        element.click();
    }

    @Then("I logged in")
    public void iLoggedIn() {
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        String zalogowano = "https://www.saucedemo.com/inventory.html";
        if ((webDriver.getCurrentUrl()).equals(zalogowano)){
            webDriver.quit();//przeglądarka ma się zamknąć jeśli udało się zalogować aby ułatwić
            // znalezienie złego loginu
        }
    }
}
