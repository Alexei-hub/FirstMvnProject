import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPageElements {

    ElementsCollection tittles = $$(By.xpath("//span[@class='goods-tile__title']"));
}
