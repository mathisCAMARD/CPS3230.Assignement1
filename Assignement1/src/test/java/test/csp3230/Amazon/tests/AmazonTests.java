package test.csp3230.Amazon.tests;

import edu.um.cps3230.WebPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonTests {
    WebDriver driver;
    WebPageObject amaz;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        amaz = new WebPageObject(driver);
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void typeInTheSearchBar(){
        amaz.inputSearchText("ds lite", "searchTextBox");
    }

    @Test
    public void clickToSearchPoduct(){
        amaz.inputSearchText("ds lite", "searchTextBox");
        amaz.pressButton("searchButton");
    }

    @Test
    public void scrapeMyProductTitle(){
        amaz.inputSearchText("ds lite", "searchTextBox");
        amaz.pressButton("searchButton");
        List<WebElement> title = amaz.scrapeProductInformations("title");
        Assertions.assertFalse(title.isEmpty());

    }

    @Test
    public void scrapeMyProductImage(){
        amaz.inputSearchText("ds lite", "searchTextBox");
        amaz.pressButton("searchButton");
        List<WebElement> image = amaz.scrapeProductInformations("image");
        Assertions.assertFalse(image.isEmpty());

    }

    @Test
    public void scrapeMyProductPrice(){
        amaz.inputSearchText("ds lite", "searchTextBox");
        amaz.pressButton("searchButton");
        List<WebElement> price = amaz.scrapeProductInformations("price");
        Assertions.assertFalse(price.isEmpty());


    }

    @Test
    public void scrapeMyProductUrl(){
        amaz.inputSearchText("ds lite", "searchTextBox");
        amaz.pressButton("searchButton");
        List<WebElement> url = amaz.scrapeProductInformations("url");
        Assertions.assertFalse(url.isEmpty());

    }
}
