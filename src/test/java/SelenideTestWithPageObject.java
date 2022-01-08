import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithPageObject {
    private final MainPageLogic mainPageLogic = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {
        String firstCategoryName = mainPageLogic.categoryName(0);
        mainPageLogic.checkCategoryQuantity(19).clickOnCategory(mainPageLogic.compAndLaptopCategory)
                .clickOnCategory(new CategoryPageElements().laptopCategory)
                .checkProductQuantity(60);
    }
}
