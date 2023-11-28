package ru.praktikum.qa.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalPageOrderSuccess {
    private final WebDriver webDriver;
    private final By checkSuccessOrderLocator = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Посмотреть статус']"); //кнопка "Посмотреть статус" на финальной модалке

    public ModalPageOrderSuccess(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isSuccessOrder() {
        WebElement buttonViewStatus = webDriver.findElement(checkSuccessOrderLocator);
        return buttonViewStatus.isDisplayed();

    }

}

