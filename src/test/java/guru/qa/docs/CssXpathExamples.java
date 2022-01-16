package guru.qa.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void examples(){
        // By data-textid
        $("[data-testid=email").click();
        $(by("data-textid","email")).click();

        // By data-id + xpath
        $("[id=email]").click();
        $("#email").click();
        $("input[id=email]").click();
        $("input#email").click();

        $(byId("#email")).click();
        $(By.id("#email")).click();
        $("[id='email']").click();
        $(by("id", "email")).click();
        $x("//*[@id='email']").click();
        $(byXpath("//*[@id='email']")).click();

        $("input[id=email]").click();
        $("input#email").click();

        //by name
        $("[name=email]").click();
        $(byName("email")).click();

        // by class
        $(".login_form_input_box").click();
        $(byClassName("login_form_input_box")).click();

        //  <div>Hello qa.guru</div>
        $(byText("Hello qa.guru")).click();
        $(withText("He o .guru")).click();
    }
}
