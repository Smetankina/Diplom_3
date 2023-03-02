package ru.praktikum.yandex.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageClass {

    WebDriver driver;



    public RegisterPageClass(WebDriver driver) {
        this.driver = driver;
    }


    public RegisterPageClass openPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        return this;
    }


    //input field Name
    //private By nameField = By.xpath(".//*[(@class='input__placeholder text noselect text_type_main-default' and text() ='Имя')]");
    private By nameField = By.cssSelector("input[name='name']");
    //input field Email
    private By emailField = By.xpath(".//fieldset[2]//input[@class='text input__textfield text_type_main-default']");
    //Input Field Пароль
    private By passwordField = By.cssSelector("input[name='Пароль']");
    //Register Button
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    //Login Link
    private By loginLink = By.linkText("Войти");
    //error display
    private By errorDisplay = By.xpath(".//p[(@class = 'input__error text_type_main-default' and text() = 'Некорректный пароль')]");


    //input in the field Name
    public RegisterPageClass setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    //input  in the  Email field
    public RegisterPageClass setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    //Input in the Password Field
    public RegisterPageClass setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    //Register Button
    public RegisterPageClass clickRegisterButton() {
        driver.findElement(registerButton).click();
        return this;
    }

    //Login Link
    public RegisterPageClass clickLoginLink() {
        driver.findElement(loginLink).click();
        return this;
    }

    //error Display

    public boolean errorIsDisplayed() {
      return   driver.findElement(errorDisplay).isDisplayed();

    }
}
