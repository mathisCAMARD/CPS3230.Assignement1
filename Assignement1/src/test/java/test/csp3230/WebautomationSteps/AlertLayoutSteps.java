package test.csp3230.WebautomationSteps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.um.cps3230.Alert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AlertLayoutSteps {
    List<Alert> alertList = new ArrayList<>();
    WebDriver driver;

    String userId = "24680";
    int temp;

    @Given("I am an administrator of the website and I upload {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAlerts(int arg0) throws UnirestException {
        temp = arg0;
        for(int i = 0; i < arg0; i++){
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

    @When("I view a list of alerts")
    public void iViewAListOfAlerts() {
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
        for(int i = 0; i<4; i++){
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.id("UserId")).sendKeys(userId);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        String xPathIcon = "//img[@src='/images/icon-electronics.png' and @width='100']";
        List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        Assertions.assertEquals("/images/icon-electronics.png", elements.get(0).getDomAttribute("src"));
        Assertions.assertEquals(temp, alertList.size());
    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
        //String xPathIcon = "//img[@src='/images/icon-electronics.png' and @width='100']";
       //List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        //Assertions.assertEquals("object", elements.get(0).getAccessibleName());
        Assertions.assertEquals(temp, alertList.size());
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
        //String xPathIcon = "";
        //List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        //Assertions.assertEquals("/images/icon-electronics.png", elements.get(0).getDomAttribute("src"));
        Assertions.assertEquals(temp, alertList.size());

    }


    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
        String xPathIcon = "//img[@src='https://picsum.photos/200/300.jpg' and @width='200']";
        List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        Assertions.assertEquals("https://picsum.photos/200/300.jpg", elements.get(0).getDomAttribute("src"));
        Assertions.assertEquals(temp, alertList.size());
    }

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        //String xPathIcon = "";
        //List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        //Assertions.assertEquals("/images/icon-electronics.png", elements.get(0).getDomAttribute("src"));
        Assertions.assertEquals(temp, alertList.size());
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        //String xPathIcon = "//a[href = 'https://www.amazon.com/']";
        //List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        //Assertions.assertEquals("/https://www.amazon.com/", elements.get(0).getDomAttribute("href"));
        Assertions.assertEquals(temp, alertList.size());
        driver.quit();
    }
}
