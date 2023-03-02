package ru.praktikum.yandex.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageClass {

    private WebDriver driver;

    //конструктор для класса страницы
    public HomePageClass(WebDriver driver) {
        this.driver = driver;
    }


    public HomePageClass openPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
        return this;
    }

    //кнопка Личный кабинет
    private By personalAreaButton = By.xpath(".//p[(@class ='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет')]");
    //кнопка Войти в аккаунт
    private By enterButton = By.xpath(".//*[text()='Войти в аккаунт']");
    //title Buns
    private By bunsTitle = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']");
    //Булки
    private By bunsTab = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Булки']");
    //Соусы
    private By sauceTab = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Соусы']");
    //Начинки
    private By fillingTab = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Начинки']");

    //List of ingredients with Buns
    private By bunsList = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() ='Булки']");
    //List of ingredients with Sauce
    private By sauceList = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() ='Соусы']");
    //List of ingredients with Filling
    private By fillingList = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() ='Начинки']");


    //метод для клика по кнопке Личный кабинет
    public HomePageClass clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
        return this;
    }

    //метод для клика по кнопке Войти в аккаунт
    public HomePageClass clickEnterButton() {
        driver.findElement(personalAreaButton).click();
        return this;
    }

    //buns title is Displayed
    public boolean bunsTitleIsDisplayed() {
        return driver.findElement(bunsTitle).isDisplayed();
    }

    //click on bunsTab
    public HomePageClass clickOnBunsTab() {
        driver.findElement(bunsTab).click();
        return this;
    }

    //click on SauceTab
    public HomePageClass clickOnSauceTab() {
        driver.findElement(sauceTab).click();
        return this;
    }

    //click on FillingTab
    public HomePageClass clickOnFillingTab() {
        driver.findElement(fillingTab).click();
        return this;
    }


    public HomePageClass scrollToSauceList() {
        WebElement element = driver.findElement(sauceList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public HomePageClass scrollToBunList() {
        WebElement element = driver.findElement(bunsList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public HomePageClass scrollToFillingList() {
        WebElement element = driver.findElement(fillingList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

}
