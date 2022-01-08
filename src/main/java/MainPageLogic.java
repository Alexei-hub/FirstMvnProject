import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElements {

    public MainPageLogic checkCategoryQuantity(int size) {
        categorySideBar.shouldHaveSize(size);
        return this;
    }

    public String categoryName(int position) {
        return categorySideBar.get(position).getText();
    }

    public CategoryPageLogic clickOnCategory(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(CategoryPageLogic.class);
    }
}
