package ru.praktikum.qa.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalPageOrderConfirm {
    private final WebDriver webDriver;
    private final By clickOrderConfirmButtonLocator = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Да']"); //кнопка "Да" в модальном окне подтверждения заказа

    public ModalPageOrderConfirm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderConfirmButton() {
        WebElement buttonOrderConfirm = webDriver.findElement(clickOrderConfirmButtonLocator);
        JavascriptExecutor executorModal = (JavascriptExecutor) webDriver;
        executorModal.executeScript("arguments[0].click();", buttonOrderConfirm);
    }
}
