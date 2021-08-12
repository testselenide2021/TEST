import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.WaitUntil;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.LocalDateTime;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MailSendTest_4 {
    @Test
    void mailSendTest() {
        Configuration.timeout=20000;
//        Configuration.browser = "firefox";
        open("https://mail.ru/");

        mailAuth("testselenide", "javauicheckup");
        mailSend("bikmaevrr@mail.ru", LocalDateTime.now() + " Тестовое сообщение", "Test message 999999");
    }

    void mailAuth(String user, String pass) {
        $(By.name("login")).shouldBe(visible).setValue(user);
        $(".button.svelte-1eyrl7y").shouldBe(visible).click();
        $(By.name("password")).shouldBe(visible).setValue(pass);
        $(".second-button.svelte-1eyrl7y").shouldBe(visible).click();
    }

    void mailSend(String sendTo, String subject, String messageText) {

        $(".compose-button__wrapper").shouldBe(visible).click();
        $(".scrollview--SiHhk.scrollview_main--3Vfg9").shouldBe(visible);
        $(".container--H9L5q.size_s--3_M-_").setValue(sendTo);
        $(By.name("Subject")).setValue(subject);
        $x("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]").shouldBe(visible).setValue(messageText);
        $("span.button2.button2_base.button2_primary.button2_hover-support.js-shortcut").shouldBe(visible).click();
    }

}
