package page.object;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WhoPage {
    private WebDriver driver;
    //Заголовок страницы
    private By titleOfPage = By.className("Order_Header__BZXOb");
    //Поле ввода имени
    private By firstName = By.xpath("//input[@placeholder = \"* Имя\"]");
    //Поле ввода фамилии
    private By lastName = By.xpath("//input[@placeholder = \"* Фамилия\"]");
    //Поле ввода адреса
    private By adress = By.xpath("//input[@placeholder = \"* Адрес: куда привезти заказ\"]");
    //Поле выбора станции метро
    private By metro = By.className("select-search__input");
    //Поле ввода номера телефона
    private By phone = By.xpath("//input[@placeholder = \"* Телефон: на него позвонит курьер\"]");
    //Кнопка Далее
    private By buttonNext = By.xpath("//button[contains(@class, \"Button_Middle__1CSJM\")]");

    public WhoPage(WebDriver driver){
        this.driver = driver;
    }
    //Проверка корректно загруженной страницы
    public void checkWhoPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(titleOfPage, "Для кого самокат"));
    }
    //Метод для заполнения имени
    public void setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    //Метод для заполнения фамилии
    public void setLastName(String surname){
        driver.findElement(lastName).sendKeys(surname);
    }
    //Метод для заполнения адреса
    public void setAdress(String toWhere){
        driver.findElement(adress).sendKeys(toWhere);
    }
    //Метод для выбора станции метро
    public void setMetro(){
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metro).sendKeys(Keys.ENTER);
    }
    //Метод для заполнения номера телефона
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phone).sendKeys(phoneNumber);
    }
    //Сводный метод заполнения форм на странице
    public void fillFormsWho(String name, String surname, String toWhere, String phoneNumber){
        checkWhoPage();
        setFirstName(name);
        setLastName(surname);
        setAdress(toWhere);
        setMetro();
        setPhoneNumber(phoneNumber);
    }
    //Клик на кнопку "Далее"
    public void checkButtonNext(){
        driver.findElement(buttonNext).click();
    }
}