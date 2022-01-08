import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelectOption {


    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.autodoc.de");
    }

    @Test
    public void firstTest() throws InterruptedException {

        selectOption(driver, "121");

        TimeUnit.SECONDS.sleep(5);
    }

    public void selectOption(WebDriver driver, String option) {
        WebElement makerList = driver.findElement(By.id("form_maker_id"));
        makerList.click();
        String makerListOption = String.format("//select[@id='form_maker_id']/optgroup[1]/option[@value='%s']", option);
        driver.findElement(By.xpath(makerListOption));
    }


    @AfterMethod
    public void after() {
        driver.quit();
    }
}
