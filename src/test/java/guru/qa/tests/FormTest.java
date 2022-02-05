package guru.qa.tests;

import guru.qa.pages.FormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormTest extends BaseTest{

    FormPage form = new FormPage();
    public static final String MALE = "1";
    public static final String FEMALE = "2";

    @Test
    void checkForm() {
        String dateOfBirth = form.chooseDateOfBirth();
        String subject = form.choseSubject();
        String hobbies = form.chooseAllHobbies();
        String file = form.uploadFile();
        String address = form.fillAddress();
        String firstName = form.fillFirstName();
        String lastName = form.fillLastName();
        String email = form.fillEmail();
        String gender = form.chooseGender(MALE);
        String phone = form.fillPhoneNumber();
        String stateAndCity = form.selectStateAndCity();
        form.submit();

        $(byText("Thanks for submitting the form")).should(appear);
        $$("td").shouldHave(containExactTextsCaseSensitive(dateOfBirth, subject, hobbies, file,
                address, firstName + " " + lastName, email, phone, gender, stateAndCity));
    }

    // Комментарий для PR Александр

}
