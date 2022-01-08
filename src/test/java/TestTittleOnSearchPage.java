import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestTittleOnSearchPage {
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
    public void firstTest() {
        WebElement inputSearch = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearch.sendKeys("Mac");
        WebElement searchBtn = driver.findElement(By.xpath("//button[text() = ' Найти ']"));
        searchBtn.click();

        WebElement titleOfFirstItem = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//a[@class='goods-tile__heading ng-star-inserted']")));
        String titleOfFirstItemText = titleOfFirstItem.getText().trim();
        String titleOfFirstItemTextExpected = "Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348)";

        assertEquals(titleOfFirstItemTextExpected, titleOfFirstItemText, "Tittle doesn't equals");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
