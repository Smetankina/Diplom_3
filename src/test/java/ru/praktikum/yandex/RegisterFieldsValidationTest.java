package ru.praktikum.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import ru.praktikum.yandex.API.UserClient;
import ru.praktikum.yandex.POM.HomePageClass;
import ru.praktikum.yandex.POM.LoginPageClass;
import ru.praktikum.yandex.POM.RegisterPageClass;
import ru.praktikum.yandex.model.User;

import static org.junit.Assert.assertTrue;

public class RegisterFieldsValidationTest extends TestBase {



    private String password = RandomStringUtils.random(5, true, false);
    private  String email = RandomStringUtils.random(10, true, true) + "@yandex.ru";
    private  String name = RandomStringUtils.random(10, true, false);

    User user = new User(email,password,name);
    UserClient userClient = new UserClient();
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

    @DisplayName("After unsuccessful input in the fields error message  is  Displayed")
    @Description("After successful input in the fields error message  is Not Displayed")
    @Test
    public void errorDisplayTest() {
        new HomePageClass(driver)
                .openPage()
                .clickPersonalAreaButton();
        new LoginPageClass(driver)
                .clickRegisterLink();
        new RegisterPageClass(driver)
                .setNameField(user.getName())
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickRegisterButton()
                .errorIsDisplayed();


        RegisterPageClass registerPageClass = new RegisterPageClass(driver);
        boolean isErrorDisplayed = registerPageClass.errorIsDisplayed();
        assertTrue("Smth is wrong with error display" +
                ".", isErrorDisplayed);

    }


}
