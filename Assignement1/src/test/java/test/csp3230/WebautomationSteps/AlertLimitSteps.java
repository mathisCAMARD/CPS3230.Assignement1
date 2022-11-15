package test.csp3230.WebautomationSteps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.um.cps3230.Alert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AlertLimitSteps {

    List<Alert> alertList = new ArrayList<>();
    WebDriver driver;

    String userId = "24680";
    @Given("I am an administrator of the website and I upload more than {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadMoreThanAlerts(int arg0) throws UnirestException {
        for(int i = 0; i <= arg0; i++){
            Alert alert = new Alert("object", "dummy object", "https://www.amazon.com/", "https://picsum.photos/200/300.jpg", "100");
            alertList.add(alert);
        }

        for(int i = 0; i< alertList.size(); i++) {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                    .header("Content-Type", "application/json")
                    .body("{\n\"alertType\": 6,\n\"heading\": \""+ alertList.get(i).getTitle()+"\",\n\"description\": \""+alertList.get(i).getDescripion()+"\",\n\"url\": \""+alertList.get(i).getUrl()+"\",\n\"imageUrl\" : \""+alertList.get(i).getImageUrl()+"\",\n\"postedBy\": \"24680\",\n\"priceInCents\": "+alertList.get(i).getPrice()+"\n}").asString();

        }
    }


    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
        for(int i = 0; i<4; i++){
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.id("UserId")).sendKeys(userId);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        String xPathIcon = "//img[@src='/images/icon-electronics.png' and @width='100']";
        List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        Assertions.assertEquals(5, elements.size());

    }
}
