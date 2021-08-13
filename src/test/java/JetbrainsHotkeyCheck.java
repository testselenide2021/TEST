import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class JetbrainsHotkeyCheck {
    @Test

    void hotkeyCheck(){
        // Список горячих клавиш на jetbrains.com
        Configuration.timeout=20000;
        open("https://www.jetbrains.com/ru-ru/idea/resources/");

        ElementsCollection hotKeys = $$(".wt-code.wt-code_theme_light");
        ElementsCollection aboutKeys = $$(".wt-text-2.wt-text-2_hardness_average.wt-text-2_theme_light.shortcuts-info__legend");

            hotKeys.get(5).shouldBe(visible).shouldHave(text("Ctrl + Shift + A"));
            hotKeys.get(6).shouldBe(visible).shouldHave(text("Alt + Enter"));
            hotKeys.get(7).shouldBe(visible).shouldHave(text("Alt + Insert"));
            hotKeys.get(8).shouldBe(visible).shouldHave(text("Alt + F7"));
            hotKeys.get(9).shouldBe(visible).shouldHave(text("Double Shift"));

            aboutKeys.get(5).shouldBe(visible).shouldHave(text("Поиск любых действий в IDE"));
            aboutKeys.get(6).shouldBe(visible).shouldHave(text("Просмотр intention-действий и быстрых исправлений"));
            aboutKeys.get(7).shouldBe(visible).shouldHave(text("Генерация кода"));
            aboutKeys.get(8).shouldBe(visible).shouldHave(text("Поиск использований"));
            aboutKeys.get(9).shouldBe(visible).shouldHave(text("Поиск везде"));
    }
}
