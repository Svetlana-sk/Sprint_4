package ru.praktikum.qa.order;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.qa.accordion.MainPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String orderDate;
    private final String comment;
    private WebDriver webDriver;

    public OrderTest(String name, String surname, String address, String phone, String orderDate, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.orderDate = orderDate;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Мария", "Петровская", "Москва, пр-т Московский дом 78", "89887775544", "22.12.2023", "Без комментария"},
                {"Михаил", "Иванов", "Москва, пр-т Московский дом 78", "81111111111", "26.12.2023", "..."}
        });
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void checkOrderSuccess() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.enterClientDetails(name, surname, address);
        orderPage.enterSubwayClient();
        orderPage.enterPhoneClient(phone);
        orderPage.clickNextButton();
        orderPage.enterOrderDate(orderDate);
        orderPage.clickDropdownRentTimeList();
        orderPage.clickDropdownRentTimeItem();
        orderPage.clickScooterColor();
        orderPage.enterCommentClient(comment);
        orderPage.clickOrderButtonSecondPage();

        ModalPageOrderConfirm modalPageOrderConfirm = new ModalPageOrderConfirm(webDriver);
        modalPageOrderConfirm.clickOrderConfirmButton();

        ModalPageOrderSuccess modalPageOrderSuccess = new ModalPageOrderSuccess(webDriver);
        boolean buttonViewStatus = modalPageOrderSuccess.isSuccessOrder();
        Assert.assertTrue(buttonViewStatus);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}