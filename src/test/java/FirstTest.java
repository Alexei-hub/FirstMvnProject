import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com.ua");

        WebElement searchInput = driver.findElement(By.cssSelector(".search-form__input[_ngcontent-rz-client-c7]"));

        driver.close();
    }
}