package ru.praktikum.yandex.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageClass {

    WebDriver driver;


    public LoginPageClass openPage() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        return this;
    }

    //Personal Area Button
    private By personalAreaButton = By.xpath(".//p[@class ='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    //Input field Email
    private By emailField = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default']");
    //Input Field Пароль
    private By passwordField = By.xpath(".//*[@type='password']");
    //Login Button
    private By loginButton = By.xpath(".//button[text()='Войти']");
    //Register Link
    private By registerLink = By.linkText("Зарегистрироваться");
    //Restore Password Link
    private By restoreLink = By.linkText("Восстановить пароль");

    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
    }


    //Click Personal Area Button
    public LoginPageClass clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
        return this;
    }

    //Input in the field email
    public LoginPageClass setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    //Input in the field password
    public LoginPageClass setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    //Click Login Button
    public LoginPageClass clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    //Click Register Link
    public LoginPageClass clickRegisterLink() {
        driver.findElement(registerLink).click();
        return this;
    }

    //Click Register Link
    public LoginPageClass clickRestorePasswordLink() {
        driver.findElement(restoreLink).click();
        return this;
    }

    //Login Button is Displayed
    public boolean loginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }


}
