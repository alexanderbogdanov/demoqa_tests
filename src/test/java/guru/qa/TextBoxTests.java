package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1000x1000";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("Alex@mail.ru");
        $("#currentAddress").setValue("Lenina street");
        $("#permanentAddress").setValue("Stalina street");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output").$("#email").shouldHave(text("Alex@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Lenina street"));
        $("#output #permanentAddress").shouldHave(text("Stalina street"));

//        $("#output").shouldHave(text("Alex"),
//                text("Alex@mail.ru"), text("Lenina street"), text("Stalina street"));


    }
}
