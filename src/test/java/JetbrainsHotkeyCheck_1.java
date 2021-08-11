
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class JetbrainsHotkeyCheck_1 {
    @Test

    void hotkeyCheck(){
        // Список горячих клавиш на jetbrains.com
        Configuration.timeout=30000;
        Configuration.pageLoadTimeout =  30;
        Configuration.browser = "firefox";
        open("https://www.jetbrains.com/ru-ru/idea/resources/");

        ElementsCollection hotKeys = $$(".wt-code.wt-code_theme_light");
        ElementsCollection aboutKeys = $$(".wt-text-2.wt-text-2_hardness_average.wt-text-2_theme_light.shortcuts-info__legend");

            hotKeys.get(5).shouldBe(visible).shouldHave(text("Ctrl + Shift + A"));
//            aboutKeys.get(5).shouldBe(visible).shouldHave(text("Поиск любых действий в IDE"));
            hotKeys.get(6).shouldBe(visible).shouldHave(text("Alt + Enter"));
//            aboutKeys.get(6).shouldBe(visible).shouldHave(text("Просмотр intention-действий и быстрых исправлений"));
            hotKeys.get(7).shouldBe(visible).shouldHave(text("Alt + Insert"));
//            aboutKeys.get(7).shouldBe(visible).shouldHave(text("Генерация кода"));
            hotKeys.get(8).shouldBe(visible).shouldHave(text("Alt + F7"));
//            aboutKeys.get(8).shouldBe(visible).shouldHave(text("Поиск использований"));
            hotKeys.get(9).shouldBe(visible).shouldHave(text("Double Shift"));
//            aboutKeys.get(9).shouldBe(visible).shouldHave(text("Поиск везде"));

        System.out.println("---------------------Console output Start--------------------- \n");
        System.out.println("---------------------Console output End--------------------- \n");
    }

}
