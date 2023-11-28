package ru.praktikum.qa.order;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver webDriver;
    private final By inputFieldNameLocator = By.cssSelector("input.Input_Input__1iN_Z[placeholder='* Имя']"); //поле ввода Имя
    private final By inputFieldSurnameLocator = By.cssSelector("input.Input_Input__1iN_Z[placeholder='* Фамилия']"); //поле ввода Фамилия
    private final By inputFieldAdressLocator = By.cssSelector("input.Input_Input__1iN_Z[placeholder='* Адрес: куда привезти заказ']"); //поле ввода Адрес
    private final By dropdownSubwayLocator = By.cssSelector("input.select-search__input[placeholder='* Станция метро']"); //дропдаун Станция метро
    private final By inputFieldPhoneLocator = By.cssSelector("input.Input_Input__1iN_Z[placeholder='* Телефон: на него позвонит курьер']"); //поле ввода Телефон
    private final By buttonNextStepLocator = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); //кнопка "Далее"
    private final By inputFieldCalendarLocator = By.cssSelector("input.Input_Input__1iN_Z[placeholder='* Когда привезти самокат']"); //поле ввода Дата
    private final By dropDownRentTimeListLocator = By.cssSelector("div.Dropdown-control[aria-haspopup='listbox']"); //дропдаун с списком сроков аренды
    private final By clickDropdownRentTimeItemLocator = By.xpath("//div[@class='Dropdown-menu']/div[text()='пятеро суток']"); //элемент из списка
    private final By clickScooterColorLocator = By.cssSelector("#black"); //чекбокс с цветом
    private final By enterCommentClientLocator = By.cssSelector("input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']"); //поле ввода Комментарий
    private final By clickOrderButtonSecondPageLocator = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']"); //кнопка "Заказать"

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterClientDetails(String name, String surname, String address) {
        enterNameClient(name);
        enterSurnameClient(surname);
        enterAdressClient(address);
    }

    public void enterNameClient(String nameClient) {
        WebElement inputFieldName = webDriver.findElement(inputFieldNameLocator);
        inputFieldName.sendKeys(nameClient);
    }

    public void enterSurnameClient(String surnameClient) {
        WebElement inputFieldSurname = webDriver.findElement(inputFieldSurnameLocator);
        inputFieldSurname.sendKeys(surnameClient);
    }

    public void enterAdressClient(String adressClient) {
        WebElement inputFieldAdress = webDriver.findElement(inputFieldAdressLocator);
        inputFieldAdress.sendKeys(adressClient);
    }

    public void enterSubwayClient() {
        WebElement dropdownSubway = webDriver.findElement(dropdownSubwayLocator);
        dropdownSubway.click();
        dropdownSubway.sendKeys(Keys.ARROW_DOWN);
        dropdownSubway.sendKeys(Keys.ENTER);
    }

    public void enterPhoneClient(String phoneClient) {
        WebElement inputFieldPhone = webDriver.findElement(inputFieldPhoneLocator);
        inputFieldPhone.sendKeys(phoneClient);
    }

    public void clickNextButton() {
        WebElement buttonNextStep = webDriver.findElement(buttonNextStepLocator);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", buttonNextStep);
    }

    public void enterOrderDate(String orderDate) {
        WebElement inputFieldCalendar = webDriver.findElement(inputFieldCalendarLocator);
        inputFieldCalendar.sendKeys(orderDate);
        inputFieldCalendar.sendKeys(Keys.ESCAPE);
    }

    public void clickDropdownRentTimeList() {
        WebElement dropDownRentTimeList = webDriver.findElement(dropDownRentTimeListLocator);
        dropDownRentTimeList.click();
    }

    public void clickDropdownRentTimeItem() {
        WebElement dropDownRentTimeItem = webDriver.findElement(clickDropdownRentTimeItemLocator);
        dropDownRentTimeItem.click();
    }

    public void clickScooterColor() {
        WebElement checkBoxScooterColor = webDriver.findElement(clickScooterColorLocator);
        checkBoxScooterColor.click();
    }

    public void enterCommentClient(String commentClient) {
        WebElement inputFieldComment = webDriver.findElement(enterCommentClientLocator);
        inputFieldComment.sendKeys(commentClient);
    }

    public void clickOrderButtonSecondPage() {
        WebElement buttonOrderSecondPage = webDriver.findElement(clickOrderButtonSecondPageLocator);
        JavascriptExecutor executorSecondPage = (JavascriptExecutor) webDriver;
        executorSecondPage.executeScript("arguments[0].click();", buttonOrderSecondPage);
    }
}
