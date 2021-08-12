import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Configuration.fileDownload;
import static com.codeborne.selenide.FileDownloadMode.*;
import static com.codeborne.selenide.Selenide.*;

public class DownloadFileTest {

    @Test
        void downloadFile() throws FileNotFoundException, InterruptedException {
        Configuration.timeout=20000;
        Configuration.browser = "firefox";
        Configuration.downloadsFolder = "C:\\TestDownload";
        fileDownload = FOLDER;

        open("https://www.google.com/intl/ru_ru/chrome/");
        File report = $("button#js-download-hero.chr-cta__button.chr-cta__button--blue.js-download.chr-full-bleed-hero__button.chr-cta__button--download.js-sticky-trigger.show").shouldBe(Condition.visible).download();
        TimeUnit.SECONDS.sleep(10);
        Assertions.assertEquals(report.getName(), "ChromeSetup.exe");
    }
}