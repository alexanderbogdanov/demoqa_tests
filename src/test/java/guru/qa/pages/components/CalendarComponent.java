package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
//        $("[aria-label$='" + month + " " + day + "th, " + year + "']").click();

        String dayLocator = format("[aria-label$='%s %sth, %s']", month, day, year); //same
        $(dayLocator).click();
    }

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String dayLocator = format("[aria-label$='%s %sth, %s']", month, day, year); //same
        $(dayLocator).click();
    }
}
