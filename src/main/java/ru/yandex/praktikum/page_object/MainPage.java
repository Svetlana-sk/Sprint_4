package ru.yandex.praktikum.page_object;

import org.openqa.selenium.*;

public class MainPage {
        private final WebDriver webDriver;
        //кнопка "Заказать" в хедере
        private final By orderButtonHeaderLocator = By.cssSelector(".Header_Nav__AGCXC button.Button_Button__ra12g");

        public MainPage(WebDriver webDriver){
            this.webDriver = webDriver;
        }

        public void open(){
            webDriver.get("https://qa-scooter.praktikum-services.ru/");
        }

        public void clickOrderButtonHeader(){
            WebElement orderButtonHeader = webDriver.findElement(orderButtonHeaderLocator);
            orderButtonHeader.click();
        }

}
