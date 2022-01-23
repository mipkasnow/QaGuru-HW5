package guru.qa.Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeEach
    public void beforeTest() {

        clearBrowserCookies();

        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1590x850";


        open("");
    }

    @AfterEach
    public void after(){closeWebDriver();}
}
