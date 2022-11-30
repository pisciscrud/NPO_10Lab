package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.math.BigInteger;
import java.time.Duration;
import java.util.List;

//import static com.codeborne.selenide.Selenide.open;
public class ComicsKramaPageTest {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserStart() {
        driver = new ChromeDriver();
    }

    @Test
    public void ResultOfEmtySearch() {
           driver.get("https://www.comicskrama.by/");
           WebElement element = waitWebElementLocatedBy(driver,By.xpath("//button[@class='search-widget-button button is-widget-submit']"));
           element.click();
        WebElement element1 = waitWebElementLocatedBy(driver,By.xpath("//div[@class='products-list row']"));
        Assert.assertTrue(element1.findElements(By.xpath("//div[@class='product-card-wrapper']")).size() == 0);
    }
    public static WebElement waitWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }
}
