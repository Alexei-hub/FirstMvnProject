import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRozetkaCheckSaleProduct {
    WebDriver driver;
    WebDriverWait wait;
    private final String MAIN_URL = "https://rozetka.com.ua";

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(MAIN_URL);
    }

    @Test
    public void firstTest() throws InterruptedException {
        List<WebElement> saleBlockGoods = driver.findElements(By.xpath("//h2[contains(text(), ' Акционные предложения ')]/../ul/li"));
        int saleBlockGoodsCount = saleBlockGoods.size();
        Assert.assertEquals(saleBlockGoodsCount, 6);

        WebElement priceOfFirstGoodInSaleBlock = driver.findElement(By.xpath("//h2[contains(text(), ' Акционные предложения ')]/../ul/li//span[@class='tile__price-value']"));
        String priceOfFirstGoodInSaleBlockText = priceOfFirstGoodInSaleBlock.getText().trim();

        saleBlockGoods.get(0).click();

        WebElement priceOfGoodOnProductPage = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']"));
        String priceOfGoodOnProductPageText = priceOfGoodOnProductPage.getText().trim();
        priceOfGoodOnProductPageText = priceOfFirstGoodInSaleBlockText.substring(0, priceOfGoodOnProductPageText.length() - 1);

        Assert.assertEquals(priceOfFirstGoodInSaleBlockText, priceOfGoodOnProductPageText);

        driver.navigate().back();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, MAIN_URL);

        Assert.assertEquals(saleBlockGoodsCount, 6);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
