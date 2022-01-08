import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class FirstTestFromMvn {
    @Test
    public void test() {
        open("https://www.google.com.ua/");
        System.out.println("Test Run From Maven");
    }
}
