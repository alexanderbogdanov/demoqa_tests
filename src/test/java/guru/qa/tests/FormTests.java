package guru.qa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormTests extends TestBase {

    @Test
    public void successfulFormFillTest() {
        open("/automation-practice-form");
// First name last name and email
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Bogdanov");
        $("#userEmail").setValue("alex@mail.com");
// Gender
        $("#genterWrapper").$(byText("Other")).click(); // будет искать только в нужном блоке
        // Mobile number
        $("#userNumber").setValue("7911999781");
// Date of birth
        $("div#dateOfBirth #dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1977");
// день месяца первый вариант
        $("[aria-label$='July 30th, 1977']").click();
//Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
// Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
//Picture
        $("#uploadPicture").uploadFromClasspath("foto.png");
// Address
        $("#currentAddress").setValue("Lenina 49");
//State and city
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("#submit").click();
        $("#submit").click();
//Assertions
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Bogdanov"), text("alex@mail.com"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Alex Bogdanov"));
    }

}
