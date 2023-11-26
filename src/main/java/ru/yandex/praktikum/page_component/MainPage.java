package ru.yandex.praktikum.page_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
        private final WebDriver webDriver;
        //кнопка "Заказать" в хедере
        private final By orderButtonHeaderLocator = By.cssSelector(".Header_Nav__AGCXC button.Button_Button__ra12g");
        //блок "Вопросы о важном"
        private final By faqItems = By.cssSelector(".accordion__item");


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

    public FaqComponent getFaqComponent(int index) {
       WebElement webElement = webDriver.findElements(faqItems).get(index);
      return new FaqComponent(webElement, webDriver);
    }
}
