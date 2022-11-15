package edu.um.cps3230;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EcommerceWebPage {

    WebDriver driver;
    WebPageObject amaz;

    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        amaz = new WebPageObject(driver);
    }

    public void teardown(){
        driver.quit();
    }

    public void typeInTheSearchBar(){
        amaz.inputSearchText("ds lite", "searchTextBox");
    }

    public void clickToSearchPoduct(){
        amaz.pressButton("searchButton");
    }

    public List<WebElement> scrapeMyProductTitle(){
        List<WebElement> title = amaz.scrapeProductInformations("title");
        return title;
    }

    public List<WebElement> scrapeMyProductImage(){
        List<WebElement> image = amaz.scrapeProductInformations("image");
        return image;
    }

    public List<WebElement> scrapeMyProductPrice(){
        List<WebElement> price = amaz.scrapeProductInformations("price");
        return price;
    }

    public List<WebElement> scrapeMyProductUrl(){
        List<WebElement> url = amaz.scrapeProductInformations("url");
        return url;
    }
}
