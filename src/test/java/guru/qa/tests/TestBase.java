package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x1200";
//        Configuration.holdBrowserOpen = true;
    }
    public interface Browsers {
        String CHROME = "chrome";
        String FIREFOX = "firefox";
        String SAFARI = "safari";
    }
}
