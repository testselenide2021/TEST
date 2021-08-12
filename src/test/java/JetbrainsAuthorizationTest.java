import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class JetbrainsAuthorizationTest {
    @Test

    void authorizationTest(){
        Configuration.timeout=20000;
        Configuration.browser = "firefox";
        open("https://www.jetbrains.com/ru-ru/");

        $(".site-header__actions > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)")
                .shouldBe(visible).click(); //User Profile btn
        insertLoginPassword();
        $("div.pull-left").click(); //Sign In Button

        logOffAndFillAuthFields("username");
        logOffAndFillAuthFields("password");
    }

    void logOffAndFillAuthFields(String field){
        logOff();
        $(".col-sm-6").shouldBe(visible).shouldHave(text("Welcome to JetBrains Account"));
        insertLoginPassword();
        $(By.name(field)).shouldBe(visible).pressEnter(); //Field Textbox username\pass Press Enter
        $(".list-group-item").shouldBe(visible).shouldHave(text("Selenide Test"));
    }

    void logOff(){
        $(".dropdown-toggle").shouldBe(visible).click();
        $(".dropdown-menu.pull-right").shouldBe(visible).click();
    }

    void insertLoginPassword(){
        $(By.name("username")).shouldBe(visible).setValue("SelenideTest");
        $(By.name("password")).shouldBe(visible).setValue("javauicheckup");
    }


}
