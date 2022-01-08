import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TestTittleOnProductPageWithoutDOM {
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
        List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='Rozetka Logo']"));

        if (logo.size() > 0) {
            System.out.println("Element presents in DOM");
        } else {
            fail();
        }
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
