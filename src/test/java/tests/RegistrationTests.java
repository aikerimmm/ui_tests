package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Форма регистрации студента")
public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешное заполнение всех полей формы")
    @Description("Позитивно проверяются все поля формы")
    void shouldRegisterWithAllFieldsFilled() {
        step("Открыть страницу регистрации", () -> {
            registrationPage.openPage();
        });
        step("Заполнить поля формы", () -> {
            registrationPage
                    .setFirstName(testData.userName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .setPhone(testData.userNumber)
                    .clickSubmit();
        });
    }

    @Test
    @DisplayName("Заполнение только обязательных полей")
    @Description("Позитивно заполняются только обязательные поля")
    void shouldRegisterWithOnlyRequiredFields() {
        step("Открыть страницу регистрации", () -> {
            registrationPage.openPage();
        });
        step("Заполнить поля формы", () -> {
            registrationPage
                    .setFirstName(testData.userName)
                    .setLastName(testData.lastName)
                    .setPhone(testData.userNumber)
                    .setDateOfBirth(testData.birthDate, testData.birthMonth, testData.birthYear)
                    .clickSubmit();
        });
    }
}