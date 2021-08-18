import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MailSendTest {
    @Test
    void mailSendTest() {
        Configuration.timeout=20000;
        open("https://mail.ru/");
//        Configuration.browser   = "Firefox";
        mailAuth("testselenide", "javauicheckup");
        mailSend("testselenide@mail.ru", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " Тестовое сообщение", "Входящих писем: ");
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
        ElementsCollection array = $$(".llc.js-tooltip-direction_letter-bottom.js-letter-list-item.llc_normal");
        $("*[role='textbox']").shouldBe(visible).append(messageText + " "+ array.size());
        $("span.button2.button2_base.button2_primary.button2_hover-support.js-shortcut").shouldBe(visible).click();
    }
}
