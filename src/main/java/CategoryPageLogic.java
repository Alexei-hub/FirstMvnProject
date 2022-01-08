import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElements{

    public SearchPageLogic clickOnCategory(SelenideElement category) {
        category.shouldBe(Condition.visible).click();
        return page(SearchPageLogic.class);
    }


}
