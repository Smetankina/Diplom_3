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

public class TransitionTest extends TestBase {
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
        driver.quit();
    }


    @Description("Check transition From HomeTo ProfilePage")
    @DisplayName("Check transition From HomeTo ProfilePage")
    @Test
    public void transitFromHomeToProfilePage() {


        new HomePageClass(driver)
                .clickPersonalAreaButton();

        ProfilePageClass profilePageClass = new ProfilePageClass(driver);
        Assert.assertTrue("Transit to LoginPage didn't occur", profilePageClass.logoutButtonIsDisplayed());

    }

    @Description("Check transition From ProfilePage to HomePage  by click Constructor")
    @DisplayName("Check transition From ProfilePage to HomePage  by click Constructor")
    @Test
    public void transitFromProfileToConstructorPageConstructorButtonTest() {
        new HomePageClass(driver)
                .openPage()
                .clickPersonalAreaButton();
        new ProfilePageClass(driver)
                .clickConstructorButton();
        HomePageClass homePageClass = new HomePageClass(driver);
        Assert.assertTrue("Transit to Constructor didn't occur", homePageClass.bunsTitleIsDisplayed());
    }

    //Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers
    @Description("Check transition From ProfilePage to HomePage  by click Constructor")
    @DisplayName("Check transition From ProfilePage to HomePage  by click Constructor")
    @Test
    public void transitFromProfileToConstructorPageStellarBurgerTest() {
        new HomePageClass(driver)
                .openPage()
                .clickPersonalAreaButton();
        new ProfilePageClass(driver)
                .clickStellarBurgerLogo();

        HomePageClass homePageClass = new HomePageClass(driver);
        Assert.assertTrue("Transit to Constructor didn't occur", homePageClass.bunsTitleIsDisplayed());
    }


}
