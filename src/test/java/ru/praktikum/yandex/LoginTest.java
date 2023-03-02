package ru.praktikum.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.praktikum.yandex.API.UserClient;
import ru.praktikum.yandex.POM.*;
import ru.praktikum.yandex.model.User;

import java.util.Locale;

public class LoginTest extends TestBase {
    UserClient userClient = new UserClient();
    //генерируем рандомные данные для пользователя
    User user = new User(
            RandomStringUtils.random(10, true, true) + "@yandex.ru",
            RandomStringUtils.random(7, true, true),
            RandomStringUtils.random(10, true, false));


    @Before
//регистрируем пользователя через API
    public void createUser() {
        userClient.registerUser(user);

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


    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    @Description("вход по кнопке «Войти в аккаунт» на главной,")
    @Test
    public void loginViaHomePage() {

        new HomePageClass(driver)
                .openPage()
                .clickEnterButton();// кнопка Войти в аккаунт
        new LoginPageClass(driver)
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickLoginButton();
        new HomePageClass(driver)
                .clickPersonalAreaButton();


        ProfilePageClass profilePageClass = new ProfilePageClass(driver);
        //there are a bug with lowercase. api returns tolowercase email
        Assert.assertEquals("User login and email doesn't match", user.getEmail().toLowerCase(Locale.ROOT), profilePageClass.getLoginFieldValue());
        System.out.println(profilePageClass.getLoginFieldValue());

    }


    @DisplayName("вход через кнопку «Личный кабинет»")
    @Description("вход через кнопку «Личный кабинет»")
    @Test

    public void loginViaLoginFormTest() {
        new HomePageClass(driver)
                .openPage()
                .clickPersonalAreaButton();//кнопка Личный кабинет
        new LoginPageClass(driver)

                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickLoginButton();
        new HomePageClass(driver)
                .clickPersonalAreaButton();


        ProfilePageClass profilePageClass = new ProfilePageClass(driver);
        //there are a bug with lowercase. api returns tolowercase email
        Assert.assertEquals("User name doesn't match", user.getEmail().toLowerCase(Locale.ROOT), profilePageClass.getLoginFieldValue());


    }

    @DisplayName("вход через кнопку в форме регистрации")
    @Description("вход через кнопку в форме регистрации")
    @Test
    public void loginViaRegisterPage() {
        new RegisterPageClass(driver)
                .openPage()
                .clickLoginLink();
        new LoginPageClass(driver)
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickLoginButton();
        new HomePageClass(driver)
                .clickPersonalAreaButton();


        ProfilePageClass profilePageClass = new ProfilePageClass(driver);
        //there are a bug with lowercase. api returns tolowercase email
        Assert.assertEquals("User data doesn't match", user.getEmail().toLowerCase(Locale.ROOT), profilePageClass.getLoginFieldValue());


    }

    @DisplayName("Login via Login Link on ForgotPasswordPage")
    @Description("Login via Login Link on ForgotPasswordPage")
    @Test
    public void loginViaForgotPasswordPage() {
        new ForgotPasswordPageClass(driver)

                .openPage()
                .clickLoginLink();
        new LoginPageClass(driver)
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickLoginButton();
        new HomePageClass(driver)
                .clickPersonalAreaButton();


        ProfilePageClass profilePageClass = new ProfilePageClass(driver);
        //there are a bug with lowercase. api returns tolowercase email
        Assert.assertEquals("User name doesn't match", user.getEmail().toLowerCase(Locale.ROOT), profilePageClass.getLoginFieldValue());


    }

}
