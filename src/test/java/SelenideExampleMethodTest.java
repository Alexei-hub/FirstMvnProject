import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideExampleMethodTest {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {
        SelenideElement findBtn = $(By.xpath("//button[text() = ' Найти ']"));
        String textFromFindBtn = findBtn.text();
        System.out.println(textFromFindBtn);

        String attributeLocalNameFromFindBtn = findBtn.attr("localName");
        System.out.println(attributeLocalNameFromFindBtn);

        String colorOfFindBtn = findBtn.getCssValue("background-color");
        System.out.println(colorOfFindBtn);
    }
}
