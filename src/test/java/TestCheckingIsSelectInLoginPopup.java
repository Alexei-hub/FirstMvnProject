import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCheckingIsSelectInLoginPopup {
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
    public void firstTest() throws InterruptedException {
        WebElement loginBtnInHeader = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginBtnInHeader.click();

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//label[@for='remember_me']"));
        WebElement rememberMeCheckboxInput = driver.findElement(By.id("remember_me"));

        System.out.println(rememberMeCheckboxInput.isSelected());

        rememberMeCheckbox.click();

        System.out.println(rememberMeCheckboxInput.isSelected());
    }


    @AfterMethod
    public void after() {
        driver.quit();
    }
}
