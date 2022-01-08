import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class FirstSelenideTest {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {
        $(".search-form__input[_ngcontent-rz-client-c15]").setValue("Mac");
        $(By.xpath("//button[text() = ' Найти ']"))
                .waitUntil(Condition.text(""), 7000)
                        .click();
        sleep(5000);
    }
}
