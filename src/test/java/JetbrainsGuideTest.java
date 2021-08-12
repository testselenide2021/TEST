import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class JetbrainsGuideTest {

        @Test

        void jetbrainsTest() {
            // Переходим в раздел "С чего начать?", листаем инструкцию "Overview of the user interface"
            // и просматриваем раздел Getting started
            Configuration.timeout=20000;
            Configuration.startMaximized = true;

            open("https://www.jetbrains.com/ru-ru/idea/resources/");

            // Chapter 3 - Getting started
            $x("//a[@href='https://www.jetbrains.com/help/idea/getting-started.html']").click();
            $(".wt-subtitle-2.wt-subtitle-2_flow.wt-subtitle-2_theme_light").shouldBe(visible)
                    .shouldHave(text("Check out the most useful and popular topics to get you started with IntelliJ IDEA."));

            // Chapter 3 - Getting started ---> Overview of the user interface
            $(By.linkText("Overview of the user interface")).shouldBe(visible).click();
            ElementsCollection rightNavigationPatel = $$("li.toc-node");
            {
                rightNavigationPatel.get(0).shouldBe(visible).shouldHave(text("Overview of the user interface")).click();
                rightNavigationPatel.get(1).shouldBe(visible).shouldHave(text("Editor")).click();
                rightNavigationPatel.get(2).shouldBe(visible).shouldHave(text("Navigation bar")).click();
                rightNavigationPatel.get(3).shouldBe(visible).shouldHave(text("Status bar")).click();
                rightNavigationPatel.get(4).shouldBe(visible).shouldHave(text("Tool windows")).click();
                rightNavigationPatel.get(5).shouldBe(visible).shouldHave(text("Context menus")).click();
                rightNavigationPatel.get(6).shouldBe(visible).shouldHave(text("Popup menus")).click();
                rightNavigationPatel.get(7).shouldBe(visible).shouldHave(text("Main window")).click();
            }
            // Chapter 3 - Getting started ---> Create your first Java application
            $(By.linkText("Create your first Java application")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Keyboard shortcuts
            $(By.linkText("Keyboard shortcuts")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Plugins
            $(By.linkText("Plugins")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Keyboard shortcuts
            $(By.linkText("Keyboard shortcuts")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Work offline
            $(By.linkText("Work offline")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Accessibility
            $(By.linkText("Accessibility")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Support and assistance
            $(By.linkText("Support and assistance")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Support and assistance
            $(By.linkText("IntelliJ IDEA pro tips")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> IntelliJ IDEA pro tips
            $(By.linkText("Migrate from Eclipse")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Migrate from Eclipse
            $(By.linkText("Import a project from Eclipse")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Import a project from Eclipse
            $(By.linkText("Export an IntelliJ IDEA project to Eclipse")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Export an IntelliJ IDEA project to Eclipse
            $(By.linkText("Migrate from NetBeans")).shouldBe(visible).click();
            // Chapter 3 - Getting started ---> Migrate from NetBeans
            $(By.linkText("IntelliJ IDEA vs NetBeans terminology")).shouldBe(visible).click();
        }
    }

