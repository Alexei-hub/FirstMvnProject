import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ElementCollectionTest {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {
        String currentUrl = url();
        System.out.println(currentUrl);

        String source = source();
        System.out.println(source);

    }
}
