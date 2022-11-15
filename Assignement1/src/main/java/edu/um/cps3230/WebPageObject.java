package edu.um.cps3230;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebPageObject {
    WebDriver driver;

    public WebPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void pressButton(String buttonName){

        String name = null;

        switch (buttonName){

            case "searchButton" : name = "nav-search-submit-button";
                break;

        }

        if (name != null){
            driver.findElement(By.id(name)).submit();
        }
    }
    public void inputSearchText(String inputText, String buttonName){
        String name = null;

        switch (buttonName){
            case "searchTextBox" : name = "field-keywords";
                break;
        }

        if (name != null){
            driver.findElement(By.name(name)).sendKeys(inputText);
        }

    }

    public List<WebElement> scrapeProductInformations(String productName){

        String name = null;

        switch (productName){
            case "title" : name = ".a-size-medium.a-color-base.a-text-normal";
                break;
            //case "description" : "";
            //break;
            case "image" : name = ".s-image";
                break;
            case "url" : name = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";
                break;
            case "price" : name = ".a-offscreen";
                break;
        }
        List<WebElement> elements = driver.findElements(By.cssSelector(name));
        return elements;
    }





}
