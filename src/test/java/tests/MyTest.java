package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import pages.RegPage;
import pages.components.Submitting;




public class MyTest extends TestBase  {

    RegPage regPage = new RegPage();
    Submitting submitting = new Submitting();

    String firstName = "Kotik",
            lastName = "Krasiviy",
            userEmail = "kotik@kotik.catq",
            gender = "Male",
            mobilePhone = "9998887766",
            dayOfBirth = "26",
            monthOfBirth = "January",
            yearOfBirth = "1999",
            subjects = "Maths",
            hobbies = "Music",
            pic = "TestBox1.JPG",
            address = "address null",
            state = "NCR",
            city = "Delhi";

    @Test
    @DisplayName("Проверка успешного заполнения всех полей формы")
    void fillFormTest() {
        regPage.openPage()
                .firstName(firstName)
                .lastName(lastName)
                .email(userEmail)
                .gender(gender)
                .number(mobilePhone)
                .date(dayOfBirth, monthOfBirth, yearOfBirth)
                .hobi(hobbies)
                .subject(subjects)
                .picture(pic)
                .address(address)
                .state(state)
                .city(city)
                .submit();
        submitting.checkForm()
                .checkContentForm("Student Name", firstName + " " + lastName)
                .checkContentForm("Student Email", userEmail)
                .checkContentForm("Gender", gender)
                .checkContentForm("Mobile", mobilePhone)
                .checkContentForm("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkContentForm("Subjects", subjects)
                .checkContentForm("Hobbies", hobbies)
                .checkContentForm("Picture", pic)
                .checkContentForm("Address", address)
                .checkContentForm("State and City", state + " " + city);
                }

    @Test
    @DisplayName("Проверка успешного заполнения обязательных полей")
    void requiredFillFormTest() {

        regPage.openPage()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .number(mobilePhone)
                .submit();
        submitting.checkForm()
                .checkContentForm("Student Name", firstName + " " + lastName)
                .checkContentForm("Gender", gender)
                .checkContentForm("Mobile", mobilePhone);
    }

    @Test
    @DisplayName("Проверка на валидацию")
    void validFillFormTest() {
        regPage.openPage()
                .firstName(firstName)
                .lastName(lastName)
                .number(mobilePhone)
                .submit();
        submitting
                .absenceForm();
    }
}
