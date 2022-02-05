package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.tools.Tools;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeEach
    public void beforeTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        clearBrowserCookies();
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1590x850";
        open("");
    }

    @AfterEach
    public void after(){
        Tools.screenshotAs("Last screen");
        Tools.pageSource();
        Tools.browserConsoleLogs();
        closeWebDriver();
    }
}
