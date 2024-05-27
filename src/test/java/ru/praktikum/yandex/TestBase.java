package ru.praktikum.yandex;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class TestBase {


    public WebDriver driver;


    @Before

    public void setDriverChrome() {

        //Chrome
      /*  ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);*/

        //для запуска Yandex.Browser



     //   System.setProperty("webdriver.chrome.driver","C:/Users/Smetankina.A.A/AppData/Local/Yandex/YandexBrowser/Application.browser.exe");
       // options.setBinary("C:/WebDriver/bin/yandexdriver.exe");
       // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/yandexdriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

    }


}
