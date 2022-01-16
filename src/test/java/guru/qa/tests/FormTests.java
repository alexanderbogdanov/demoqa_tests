package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.CssClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.not;
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
//        $(By.name("gender")).setValue("Male");
//        $(".custom-control-label").click(); // мой вариант
//        $("#gender-radio-3").parent().click(); // не мой вариант
//        $("label[for=gender-radio-3]).click(); // не мой вариант
//        $(byText("Other")).click(); // плохо, так как будет искать по всей странице
        // Gender
        $("#genterWrapper").$(byText("Other")).click(); // будет искать только в нужном блоке
        // Mobile number
        $("#userNumber").setValue("7911999781");

//        $("div#dateOfBirth #dateOfBirthInput").setValue("14 Jan 1977");
//        $("#dateOfBirthInput").pressEscape();
//        String date = "14 Jan 1977";
//        executeJavaScript("$(\"#dateOfBirthInput\").datepicker('setDate', 'date')");
//        executeJavaScript("document.getElementById('dateOfBirthInput').setAttribute('value', '14 Jan 1977')");
// Date of birth
        $("div#dateOfBirth #dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1977");
        // день месяца первый вариант
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        // второй вариант
//        $$(".react-datepicker__day--030").filter(not(cssClass("react-datepicker__day--outside-month")))
//                .first().click();
        // or
        // третий вариант
//        $$(".react-datepicker__day--030").filter(not(cssClass("react-datepicker__day--outside-month")))
//                .get(0).click();

        // четвертый вариант
//        $("[aria-label='Choose Saturday, July 30th, 1977']").click();
        // пятый вариант с ария лейбел и частью текста
//        $("[aria-label$='July 30th, 1977']").click(); //очень хороши ends-with или *=
        //шестой вариант с икспасом
        $x("//*[contains(@aria-label, 'July 30th, 1977')]").click();


        //Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        //or
        //???
        // Hobbies
        $("#hobbiesWrapper .custom-control-label", 1).click();
        //or
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Picture
        //1
        $("#uploadPicture").uploadFromClasspath("foto.png");
        //2
//        File file = new File("src/test/resources/foto.png");
//        $("input#uploadPicture").uploadFile(file);

// Address
        $("#currentAddress").setValue("Lenina 49");


//        $("#stateCity-wrapper #state").click();
//        $("#stateCity-wrapper #state div div div").setValue("Uttar Pradesh");
//        $("#stateCity-wrapper #state").pressEnter();


//        $("div.form-file input#uploadPicture").click();
//        $("div.form-file input#uploadPicture").click();


        //State and city
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("#submit").click();

//        sleep(3000);
    }
}
// последовательность тестов - @Order(n)