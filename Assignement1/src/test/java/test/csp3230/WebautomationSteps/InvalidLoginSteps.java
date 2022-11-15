package test.csp3230.WebautomationSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginSteps {

    String userId;
    WebDriver driver;

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {
        userId = "0000";
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
        for(int i = 0; i<4; i++){
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.id("UserId")).sendKeys(userId);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        Assertions.assertEquals("https://www.marketalertum.com/Alerts/Login", driver.getCurrentUrl());
        driver.quit();
    }
}
