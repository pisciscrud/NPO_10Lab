package Test;
import Page.ComicsKramaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Page.ComicsKramaPage.waitWebElementLocatedBy;

public class KramaTest {
    private WebDriver driver;


    @Test
    public void ResultOfEmtySearch() {
        driver = new ChromeDriver();
       var komicsKramaPage = new ComicsKramaPage(driver);
        komicsKramaPage.open();
      var res= komicsKramaPage.ResultOfEmtySearch().ResultOfSearch();
        Assert.assertEquals( res,0);
    }
    @Test
    public void openHistory() {
        driver = new ChromeDriver();
        var komicsKramaPage = new ComicsKramaPage(driver);
        komicsKramaPage.open();
        var res= komicsKramaPage.openHistory();
        Assert.assertEquals( res,1);
    }
    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}
