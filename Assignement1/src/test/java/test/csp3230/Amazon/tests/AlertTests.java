package test.csp3230.Amazon.tests;

import edu.um.cps3230.Alert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertTests {
    Alert alert;

    @BeforeEach
    public void setup(){
        alert = new Alert("object", "dummy object", "www.url", "image.png", "100");
    }

    @AfterEach
    public void teardown(){
        alert = null;
    }

    @Test
    public void testConstructor(){
        Assertions.assertFalse(alert == null);
    }

    @Test
    public void testGetTitle(){
        Assertions.assertEquals("object", alert.getTitle());
    }
    @Test
    public void testGetDescription(){
        Assertions.assertEquals("dummy object", alert.getDescripion());
    }
    @Test
    public void testGetUrl(){
        Assertions.assertEquals("www.url", alert.getUrl());
    }
    @Test
    public void testGetImage(){
        Assertions.assertEquals("image.png", alert.getImageUrl());
    }
    @Test
    public void testGetPrice(){
        String temp = alert.getPrice();
        Assertions.assertEquals("100", temp);
    }

}
