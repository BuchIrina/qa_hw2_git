package com.denoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    String firstName = "Darth";
    String lastName = "Vader";
    String email = "darty@gmail.com";
    String mobile = "0123456789";
    String subjects = "Eng";
    String currentAddress = "Empire, Death Star";


    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__day--030").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("QA-Tester-meme-03.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        executeJavaScript("$('footer').remove()");
        $("[id=submit]").pressEnter();


        $(".table-responsive").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text("Male"),
                text(mobile),
                text("30 November,1987"),
                text("English"),
                text("Sports, Reading, Music"),
                text("QA-Tester-meme-03.jpg"),
                text("Empire, Death Star"),
                text("NCR Noida"));
    }
}

