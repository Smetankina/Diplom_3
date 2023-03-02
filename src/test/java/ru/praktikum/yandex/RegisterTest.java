package ru.praktikum.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.yandex.API.UserClient;
import ru.praktikum.yandex.POM.HomePageClass;
import ru.praktikum.yandex.POM.LoginPageClass;
import ru.praktikum.yandex.POM.RegisterPageClass;
import ru.praktikum.yandex.model.User;

import static org.hamcrest.CoreMatchers.equalTo;

//Успешную регистрацию.
@RunWith(Parameterized.class)
public class RegisterTest extends TestBase {

    private final User user;
    private final boolean isSuccess;

    public RegisterTest(User user, boolean isSuccess) {
        this.user = user;
        this.isSuccess = isSuccess;
    }

    UserClient userClient = new UserClient();

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] registerTestData() {
        return new Object[][]{
//для пароля далее использую тестовые данные длиной 5(на шаг внутр границ), 6 на границе и 7 за границами
                {new User(
                        RandomStringUtils.random(10, true, true) + "@yandex.ru",
                        RandomStringUtils.random(7, true, true),
                        RandomStringUtils.random(10, true, false)), true},
                {new User(
                        RandomStringUtils.random(10, true, true) + "@yandex.ru",
                        RandomStringUtils.random(6, true, true),
                        RandomStringUtils.random(10, true, false)), true},
                {new User(
                        RandomStringUtils.random(10, true, true) + "@yandex.ru",
                        RandomStringUtils.random(5, true, true),
                        RandomStringUtils.random(10, true, false)), false},
        };
    }


    @DisplayName("After successful registration Login Page is Displayed")
    @Description("Успешная регистрация.")
    @Test
    public void registerTest() {
        new HomePageClass(driver)
                .openPage()
                .clickPersonalAreaButton();
        new LoginPageClass(driver)
                .clickRegisterLink();
        new RegisterPageClass(driver)
                .setNameField(user.getName())
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickRegisterButton();


        userClient.loginUser(user).then().assertThat().body("success", equalTo(isSuccess));


/*
СПРОСИТЬ

как правильно сделать такой тест. у меня в негативе в isDisabled возвращался NPE/
        LoginPageClass loginPageClass = new LoginPageClass(driver);
        boolean isDisplayed = loginPageClass.loginButtonDisplayed();
        assertTrue("Пользователь не зарегистрирован", isDisplayed);
*/

    }

    @After
    public void teardown() {
        //удаляем пользователя после теста
        try {
            userClient.deleteUser(user);
            System.out.println("User deleted after Test");
        } catch (NullPointerException e) {
            System.out.println("Nothing to delete");

        }
        driver.quit();
    }

}
