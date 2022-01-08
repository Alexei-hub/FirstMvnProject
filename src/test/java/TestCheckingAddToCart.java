import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCheckingAddToCart {

    WebDriver driver;
    WebDriverWait wait;

    By compAndLaptopCategory = By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]");
    By laptopCategory = By.xpath("//a[@title='Ноутбуки']");
    By firstProductTittleOnSearchPage = By.xpath("//span[@class='goods-tile__title']");
    By firstProductPriceOnSearchPage = By.xpath("//span[@class='goods-tile__price-value']");
    By addToCartBtn = By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']");
    By cartCounter = By.xpath("//span[@class='counter counter--green ng-star-inserted']");
    By tittleOfProductInCart = By.xpath("//a[@class='cart-product__title']");
    By priceOfProductInCart = By.xpath("//p[@class='cart-product__price cart-product__price--red']");
    By counterInCartPopupLocator = By.xpath("//input[@class='cart-counter__input ng-untouched ng-pristine ng-valid']");


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
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(compAndLaptopCategory);
        clickOnElement(laptopCategory);
        clickOnElement(addToCartBtn);


        String tittleOfFirstProductOnSearchPage = getTextFromElement(firstProductTittleOnSearchPage).trim();
        String priceOfFirstProductOnSearchPage = getTextFromElement(firstProductPriceOnSearchPage);


        String countOfCart = getTextFromElement(cartCounter).trim();
        softAssert.assertEquals("1", countOfCart, "Counter doesn't work");

        clickOnElement(cartCounter);

        String tittleOfFirstProductFromCart = getTextFromElement(tittleOfProductInCart).trim();
        String priceOfFirstProductFromCart = getTextFromElement(priceOfProductInCart);
        priceOfFirstProductFromCart = priceOfFirstProductFromCart.substring(0, priceOfFirstProductFromCart.length() - 1).trim();
        String counterInCartPopup = getAttributeFromElement(counterInCartPopupLocator, "value").trim();

        softAssert.assertEquals(tittleOfFirstProductOnSearchPage, tittleOfFirstProductFromCart);
        softAssert.assertEquals(priceOfFirstProductOnSearchPage, priceOfFirstProductFromCart);
        softAssert.assertEquals(countOfCart, counterInCartPopup);
        softAssert.assertAll();
    }

    public void clickOnElement(By xpath) {
        WebElement webElement = driver.findElement(xpath);
        webElement.click();
    }

    public void clickOnElementWithWait(By xpath) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        webElement.click();
    }

    public String getTextFromElement(By xpath) {
        WebElement webElement = driver.findElement(xpath);
        return webElement.getText().trim();
    }

    public String getAttributeFromElement(By xpath, String attribute) {
        WebElement webElement = driver.findElement(xpath);
        return webElement.getAttribute(attribute).trim();
    }


    @AfterMethod
    public void after() {
        driver.quit();
    }
}
