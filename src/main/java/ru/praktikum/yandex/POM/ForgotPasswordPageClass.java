package ru.praktikum.yandex.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageClass {
    private WebDriver driver;

    //конструктор для класса страницы
    public ForgotPasswordPageClass(WebDriver driver) {
        this.driver = driver;
    }


    public ForgotPasswordPageClass openPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        return this;
    }

    //Login Link
    private By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    //Login Link
    public ForgotPasswordPageClass clickLoginLink() {
        driver.findElement(loginLink).click();
        return this;
    }
}
