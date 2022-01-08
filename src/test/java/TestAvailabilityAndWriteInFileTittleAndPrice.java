import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestAvailabilityAndWriteInFileTittleAndPrice {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() throws IOException {
        WebElement inputSearch = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearch.sendKeys("Mac");
        WebElement searchBtn = driver.findElement(By.xpath("//button[text() = ' Найти ']"));
        searchBtn.click();

        WebElement titleOfFirstItem = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//a[@class='goods-tile__heading ng-star-inserted']")));
        titleOfFirstItem.click();

        WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
        String productPageTitleText = productPageTitle.getAttribute("innerText");

        WebElement productPagePrice = driver.findElement(By.xpath("//p[@class='product-prices__big']"));
        String productPagePriceText = productPagePrice.getText();

        WebElement availabilityOfProduct = driver.findElement(By.xpath("//p[@class='status-label status-label--green ng-star-inserted']"));
        String availabilityOfProductColor = availabilityOfProduct.getCssValue("color");

        if (availabilityOfProduct.isDisplayed() && availabilityOfProductColor.equals("rgba(0, 160, 70, 1)")) {
            FileWriter fileWriter = new FileWriter("test.txt");
            fileWriter.write(productPageTitleText + " - " + productPagePriceText);
            fileWriter.close();
        }
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
