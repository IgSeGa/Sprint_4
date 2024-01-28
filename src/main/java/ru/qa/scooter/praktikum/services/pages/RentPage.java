package ru.qa.scooter.praktikum.services.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    private WebDriver driver;
    //Заголовок страницы
    private By titleOfPage = By.className("Order_Header__BZXOb");
    //Поле ввода даты
    private By deliveryDate = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    //Поле ввода срока аренды
    private By rentTime = By.className("Dropdown-placeholder");
    //Пункт списка со сроком аренды
    private By period = By.xpath("//div[@class=\"Dropdown-option\"][1]");
    //Чекбокс с черным цветом
    private By blackBox = By.id("black");
    //Чекбокс с серым цветом
    private By greyBox = By.id("grey");
    //Поле комментария
    private By comment = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]");
    //Кнопка Заказать
    private By orderButton = By.xpath("//button[contains(@class, \"Button_Middle__1CSJM\") " +
            "and contains (text(), \"Заказать\")]");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод проверяющий, что открыта нужная страница
    public void checkRentPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(titleOfPage, "Про аренду"));
    }

    //Заполнение даты
    public void setDeliveryDate(String date) {
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(deliveryDate).sendKeys(Keys.ENTER);
    }

    //Зполнение периода аренды
    public void setPeriod() {
        driver.findElement(rentTime).click();
        driver.findElement(period).click();
    }

    //Активация черного чекбокса
    public void setBlackBox() {
        driver.findElement(blackBox).click();
    }

    //Активация серого чекбокса
    public void setGreyBox() {
        driver.findElement(greyBox).click();
    }

    //Заполнение поля "Комментарий"
    public void setComment(String text) {
        driver.findElement(comment).sendKeys(text);
    }

    //Сводный метод проверки заполнения полей
    public void fillFormsRent(String date, String textComment) {
        checkRentPage();
        setDeliveryDate(date);
        setPeriod();
        setBlackBox();
        setGreyBox();
        setComment(textComment);
    }

    //Клик на кнопку создания заказа
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}