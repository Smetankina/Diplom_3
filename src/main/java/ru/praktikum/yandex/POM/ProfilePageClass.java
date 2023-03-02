package ru.praktikum.yandex.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageClass {
    private WebDriver driver;

    public ProfilePageClass(WebDriver driver) {
        this.driver = driver;
    }


    //field Name
    private By fieldName = By.xpath(".//label[text()='Имя']/following::input[1]");
    //field Login
    private By fieldLogin = By.xpath(".//label[text()='Логин']/following::input[1]");
    //Logout button
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    //Constructor Button
    private By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2']");
    //Stellar Burger Logo
    private By stellarBurgerLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']//a");

    public String getLoginFieldValue() {
        return driver.findElement(fieldLogin).getAttribute("value");
    }


    public ProfilePageClass clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;
    }

    public ProfilePageClass clickStellarBurgerLogo() {
        driver.findElement(stellarBurgerLogo).click();
        return this;
    }


    public boolean logoutButtonIsDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();


    }

    //click on ConstructorButton
    public ProfilePageClass clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return this;
    }


}
