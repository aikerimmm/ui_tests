package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    @Step("Открыть форму регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
}