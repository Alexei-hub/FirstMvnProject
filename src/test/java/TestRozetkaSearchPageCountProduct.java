import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestRozetkaSearchPageCountProduct {
    WebDriver driver;
    WebDriverWait wait;
    FileWriter fileWriter;

    @BeforeMethod
    public void before() throws IOException {
        fileWriter = new FileWriter("test.txt");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void test() throws IOException {
        WebElement laptopAndCompCategory = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopAndCompCategory.click();
        WebElement laptopCategory = driver.findElement(By.xpath("//a[@title='Ноутбуки']"));
        laptopCategory.click();

        List<WebElement> tittleOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        int countOfGoods = tittleOfGoods.size();
        assertEquals(60, countOfGoods);

        List<WebElement> priceOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        HashMap<String, String> tittleAndPrice = new HashMap<>();

        for (int i = 0; i < countOfGoods; i++) {
            String tittle = tittleOfGoods.get(i).getText();
            String price = priceOfGoods.get(i).getText();
            tittleAndPrice.put(tittle, price);
        }

        for(Map.Entry<String, String> iterator: tittleAndPrice.entrySet()){
            fileWriter.write(iterator.getKey() + " - " + iterator.getValue() + "\n");
        }

    }

    @AfterMethod
    public void after() throws IOException {
        fileWriter.close();
        driver.quit();
    }
}
