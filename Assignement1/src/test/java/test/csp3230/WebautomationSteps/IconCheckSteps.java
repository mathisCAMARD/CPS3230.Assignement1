package test.csp3230.WebautomationSteps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.um.cps3230.Alert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IconCheckSteps {

    WebDriver driver;
    String userId = "24680";

    @Given("I am an administrator of the website and I upload an alert of type {int}")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAnAlertOfTypeAlertType(Integer alertType) throws UnirestException {
        Alert alert = new Alert("object", "dummy object", "https://www.amazon.com/", "https://picsum.photos/200/300.jpg", "100");
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                .header("Content-Type", "application/json")
                .body("{\n\"alertType\": "+alertType.toString()+",\n\"heading\": \""+ alert.getTitle()+"\",\n\"description\": \""+alert.getDescripion()+"\",\n\"url\": \""+alert.getUrl()+"\",\n\"imageUrl\" : \""+alert.getImageUrl()+"\",\n\"postedBy\": \"24680\",\n\"priceInCents\": "+alert.getPrice()+"\n}").asString();

    }

    @And("the icon displayed should be <iconFileName>")
    public void theIconDisplayedShouldBeIconFileName(String iconFileName) {
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
        for(int i = 0; i<4; i++){
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.id("UserId")).sendKeys(userId);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        String xPathIcon = "//img[@src='/images/"+iconFileName+"' and @width='100']";
        List<WebElement> elements = driver.findElements(By.xpath(xPathIcon));
        Assertions.assertEquals("test", elements.get(0).getAttribute("src"));
        driver.quit();
    }

}
