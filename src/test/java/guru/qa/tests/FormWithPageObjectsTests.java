package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void successfulFormFillTest() {
        registrationPage.openPage()
                .typeFirstName("Alex")
                .typeLastName("Bogdanov");
        $("#userEmail").setValue("alex@mail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("7911999781");
//        registrationPage.calendarComponent.setDate("30", "July", "1977");
        registrationPage.setBirthDate("30", "July", "1977");
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("foto.png");
        $("#currentAddress").setValue("Lenina 49");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Bogdanov"), text("alex@mail.com"));
        registrationPage.checkResultsValue("Student Name", "Alex Bogdanov");
    }

}
