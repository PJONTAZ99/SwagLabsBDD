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

import java.time.Duration;

public class StepsFinish {
    WebDriver webDriver;
    WebDriverWait wait;


    @Given("I am logged in as {string} in shop")
    public void iAmLoggedInAsInShop(String username) {
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


    @And("I have all products in card")
    public void iHaveAllProductsInCard() {
        WebElement[] produkty = new WebElement[6];
        produkty[0]= webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        produkty[1] = webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        produkty[2] = webDriver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        produkty[3] = webDriver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        produkty[4] = webDriver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        produkty[5] = webDriver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        for (int i = 0; i < 6; i++) {
            produkty[i].click();}
            WebElement element = webDriver.findElement(By.className("shopping_cart_link"));
            element.click();

    }

    @When("Process order")
    public void processOrder() {{
        WebElement element = webDriver.findElement(By.id("checkout"));
        element.click();
        WebElement element1 = webDriver.findElement(By.id("first-name"));
        element1.sendKeys("First");
        WebElement element2 = webDriver.findElement(By.id("last-name"));
        element2.sendKeys("Last");
        WebElement element3 = webDriver.findElement(By.id("postal-code"));
        element3.sendKeys("00-000");
        WebElement element4 = webDriver.findElement(By.id("continue"));
        element4.click();
        WebElement element5 = webDriver.findElement(By.id("finish"));
        element5.click();


    }
    }

    @Then("Finish order")
    public void finishOrder() {
        String correct= "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String real= webDriver.findElement(By.className("complete-text")).getText();
        if (real.equals(correct)){
            webDriver.quit();
        }
        Assertions.assertTrue(correct.contains(real));
    }


}
