package ru.praktikum.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.POM.HomePageClass;

public class ConstructorTest extends TestBase {
@After
public void tearDown(){
    driver.quit();
}
    @Description("Check Scroll to Sauce List")
    @DisplayName("Check Scroll to Sauce List")
    @Test
    public void checkScrollToSauceListTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToBunList()//здесь я скролю окно к единой начальной точке
                .clickOnSauceTab(); //жмакаю на соусы, вижу, что скролл идет
        // нагуглила, что window.pageYOffset; - это на сколько прокрутился скролл по вертикали
        Object actualScrollPosition = executor.executeScript("return window.pageYOffset;");


        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToBunList()//здесь я скролю окно к единой начальной точке
                .scrollToSauceList(); //ожидаемый скролл к соусам
        //нагуглила, что window.pageYOffset; - это на сколько прокрутился скролл по вертикали
        Object expectedScrollPosition = executor2.executeScript("return window.pageYOffset;");

        Assert.assertEquals("Sauce button scroll to different position then SauceList", expectedScrollPosition, actualScrollPosition);
    }

    @Description("Check Scroll to Filling List")
    @DisplayName("Check Scroll to Filling List")
    @Test
    public void checkScrollToFillingListTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToBunList()//здесь я скролю окно к единой начальной точке
                .clickOnFillingTab();

        Object actualScrollPosition = executor.executeScript("return window.pageYOffset;");
      driver.quit();

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToBunList()//здесь я скролю окно к единой начальной точке
                .scrollToFillingList(); //ожидаемый скролл к соусам

        Object expectedScrollPosition = executor2.executeScript("return window.pageYOffset;");

        Assert.assertEquals("Sauce bytton scroll to different position then SauceList", expectedScrollPosition, actualScrollPosition);
    }

    @Description("Check Scroll to Filling List")
    @DisplayName("Check Scroll to Filling List")
    @Test
    public void checkScrollToBunListTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToSauceList()
                .clickOnBunsTab();

        Object actualScrollPosition = executor.executeScript("return window.pageYOffset;");


        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        new HomePageClass(driver)
                .openPage()
                .scrollToSauceList()
                .scrollToBunList();

        Object expectedScrollPosition = executor2.executeScript("return window.pageYOffset;");

        Assert.assertEquals("Sauce button scroll to different position then SauceList", expectedScrollPosition, actualScrollPosition);
    }
}