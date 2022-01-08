import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class TestCheckingAddToCartOnSelenide {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {

        SelenideElement compAndLaptopCategory = $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        compAndLaptopCategory.click();

        SelenideElement laptopCategory = $(By.xpath("//a[@title='Ноутбуки']"));
        laptopCategory.click();

        SelenideElement firstProductTittleOnSearchPage = $(By.xpath("//span[@class='goods-tile__title']"));
        String firstProductTittleOnSearchPageText = firstProductTittleOnSearchPage.text();

        SelenideElement addToCartBtn = $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        addToCartBtn.click();

        SelenideElement cartCounter = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        String counterInCartPopup = cartCounter.innerText().trim();
        Assert.assertEquals(counterInCartPopup, "1");

        cartCounter.click();

        SelenideElement tittleOfProductInCart = $(By.xpath("//a[@class='cart-product__title']"));
        String tittleOfProductInCartText = tittleOfProductInCart.text();

        Assert.assertEquals(firstProductTittleOnSearchPageText, tittleOfProductInCartText);
    }
}
