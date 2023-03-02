package ru.praktikum.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.yandex.API.UserClient;
import ru.praktikum.yandex.POM.HomePageClass;
import ru.praktikum.yandex.POM.LoginPageClass;
import ru.praktikum.yandex.POM.ProfilePageClass;
import ru.praktikum.yandex.model.User;

public class LogoutTest extends TestBase{

    UserClient userClient = new UserClient();
    User user = new User(
            RandomStringUtils.random(10, true, true) + "@yandex.ru",
            RandomStringUtils.random(7, true, true),
            RandomStringUtils.random(10, true, false));


    @Before

    public void createUser() {
        userClient.registerUser(user);

        new HomePageClass(driver)
                .openPage()
                .clickEnterButton();
        new LoginPageClass(driver)
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickLoginButton();

    }
    @After
    public void teardown() {


        try {
            userClient.deleteUser(user);
            System.out.println("User deleted after Test");
        } catch (NullPointerException e) {
            System.out.println("Nothing to delete");

        }
        //   driver.quit();
    }


    @Description("Check Logout Button ProfilePage")
    @DisplayName("Check Logout Button ProfilePage")
    @Test
    public void checkLogoutButtonTest(){


        new HomePageClass(driver)
                .clickPersonalAreaButton();
        new ProfilePageClass(driver)
                .clickLogoutButton();
        new LoginPageClass(driver)
                .clickPersonalAreaButton();


      LoginPageClass loginPageClass = new LoginPageClass(driver);
      Assert.assertTrue("If you don't see this button you in Personal Area and you didnt Logout", loginPageClass.loginButtonDisplayed());

    }
}
