import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestWithMethodClear {

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
    public void firstTest() throws IOException, InterruptedException {
        WebElement inputSearch = driver.findElement(By.name("search"));
        inputSearch.sendKeys("bla bla bla");

        TimeUnit.SECONDS.sleep(5);

        inputSearch.clear();

        TimeUnit.SECONDS.sleep(5);
    }


    @AfterMethod
    public void after() {
        driver.quit();
    }

}
