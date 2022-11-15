package test.csp3230.WebautomationSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    String userId;
    WebDriver driver;
    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        userId = "24680";
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {

        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
        for(int i = 0; i<4; i++){
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.id("UserId")).sendKeys(userId);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);




    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        Assertions.assertEquals("https://www.marketalertum.com/Alerts/List", driver.getCurrentUrl());
        driver.quit();
    }
}
