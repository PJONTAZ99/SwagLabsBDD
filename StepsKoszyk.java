import dev.failsafe.internal.util.Assert;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Stepskoszyk {

    WebDriver webDriver;
    WebDriverWait wait;




    @Given("I am logged in as {string}")
    public void iAmLoggedInAs(String username) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.get("https://www.saucedemo.com");
        WebElement element = webDriver.findElement(By.id("user-name"));
        element.sendKeys(username);
        WebElement element1 = webDriver.findElement(By.id("password"));
        element1.sendKeys("secret_sauce");
        WebElement element3 = webDriver.findElement(By.id("login-button"));
        element3.click();
    }

    @When("I add all products")
    public void iAddAllProducts() {
        WebElement[] produkty = new WebElement[6];
        produkty[0]= webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        produkty[1] = webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        produkty[2] = webDriver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
       produkty[3] = webDriver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        produkty[4] = webDriver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        produkty[5] = webDriver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        for (int i = 0; i < 6; i++) {
            produkty[i].click();
        }

    }

    @Then("I check out cart")
    public void iCheckOutCart() {
        WebElement element = webDriver.findElement(By.className("shopping_cart_link"));
        element.click();
    }

    @And("I check {string} items")
    public void iCheckItems(String ilosc) {
        WebElement element5 = webDriver.findElement(By.className("shopping_cart_badge"));
        String rzeczcywistaIlossc =element5.getText();

        if (rzeczcywistaIlossc.equals(ilosc)){
            webDriver.quit();
        }
        Assertions.assertTrue(rzeczcywistaIlossc.contains(ilosc));
    }
}
