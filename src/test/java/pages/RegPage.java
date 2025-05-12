package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegPage {

    private SelenideElement
            first = $("#firstName"),
            last = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            number = $("#userNumber"),
            date = $("#dateOfBirthInput"),
            hobi = $("#hobbiesWrapper"),
            subject = $("#subjectsInput"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            stateIn = $("#state"),
            state = $("#react-select-3-input"),
            cityIn = $("#city"),
            city = $("#react-select-4-input"),
            submit = $("#submit");

    Calendar calendar = new Calendar();

    public RegPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegPage firstName(String value) {
        first.setValue(value);

        return this;
    }

    public RegPage lastName(String value) {
        last.setValue(value);

        return this;
    }

    public RegPage email(String value) {
        email.setValue(value);

        return this;
    }

    public RegPage gender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegPage number(String value) {
        number.setValue(value);

        return this;
    }

    public RegPage date(String day, String month, String year) {
        date.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegPage hobi(String value) {
        hobi.$(byText(value)).click();

        return this;
    }

    public RegPage subject(String value) {
        subject.click();
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegPage picture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public RegPage address(String value) {
        address.setValue(value);

        return this;
    }

    public RegPage state(String value) {
        stateIn.click();
        state.setValue(value).pressEnter();

        return this;
    }

    public RegPage city(String value) {
        cityIn.click();
        city.setValue(value).pressEnter();
        return this;
    }

    public RegPage submit() {
        submit.click();

        return this;
    }

}
