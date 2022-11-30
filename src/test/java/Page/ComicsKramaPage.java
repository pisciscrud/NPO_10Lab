package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

//import static com.codeborne.selenide.Selenide.open;
public class ComicsKramaPage {


    public ComicsKramaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;
    @FindBy(xpath = "//button[@class='search-widget-button button is-widget-submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-card-wrapper']")
    WebElement searchResultItem;
    @FindBy(xpath="//a[@class='main-menu-link menu-link level-1']")
    WebElement menu;
    @FindBy(xpath="//div[@class='editor']")
    WebElement editor;
   public ComicsKramaPage open() {
        driver.get("https://www.comicskrama.by/");
        return this;
    }


    public ComicsKramaPage ResultOfEmtySearch() {
        Actions builder = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        return this;
    }
    public int ResultOfSearch() {
        WebElement searchresult = waitWebElementLocatedBy(driver, By.xpath("//div[@class='products-list row']"));
       return searchresult.findElements(By.xpath("//div[@class='product-card-wrapper']")).size();
    }
    public int openHistory() {
        Actions builder = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(menu));
         menu.click();
        return editor.findElements(By.xpath("//div[@class='editor']")).size();
    }
    public static WebElement waitWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
