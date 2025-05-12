package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Submitting {

    private final String HEADER = "Thanks for submitting the form";
    private final SelenideElement modalContent = $("#example-modal-sizes-title-lg"),
            contentForm = $(".table-responsive");

    public Submitting checkForm() {
        modalContent.should(appear);
        modalContent.shouldHave(text(HEADER));

        return this;
    }

    public Submitting absenceForm() {
        modalContent.shouldNotBe(appear);

        return this;
    }

    public Submitting checkContentForm(String key, String value) {
        contentForm.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

}
