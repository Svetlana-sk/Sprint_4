package ru.yandex.praktikum.page_object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderTest {
    private WebDriver webDriver;

    @Before
    public void setup(){
        //WebDriverManager.firefoxdriver().setup();
        //webDriver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }


    @Test
    public void checkOrderSuccess(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage( webDriver);
        orderPage.enterNameClient("Мария");
        orderPage.enterSurnameClient("Петровская");
        orderPage.enterAdressClient("Москва, пр-т Московский дом 78");
        orderPage.enterSubwayClient();
        orderPage.enterPhoneClient("89887775544");
        orderPage.clickNextButton();
        orderPage.enterOrderDate("22.12.2023");
        orderPage.clickDropdownRentTimeList();
        orderPage.clickDropdownRentTimeItem();
        orderPage.clickScooterColor();
        orderPage.enterCommentClient("Без комментария");
        orderPage.clickOrderButtonSecondPage();

        ModalPageOrderConfirm modalPageOrderConfirm  = new ModalPageOrderConfirm(webDriver);
        modalPageOrderConfirm.clickOrderConfirmButton();

        ModalPageOrderSuccess modalPageOrderSuccess = new ModalPageOrderSuccess(webDriver);
        boolean buttonViewStatus = modalPageOrderSuccess.isSuccessOrder();
        Assert.assertTrue(buttonViewStatus);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
