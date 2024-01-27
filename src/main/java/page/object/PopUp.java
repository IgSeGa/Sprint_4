package page.object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class PopUp {
    private WebDriver driver;
    //Кнопка "Да" при оформлении заказа
    private By yesButton = By.xpath("//button[contains(@class, \"Button_Middle__1CSJM\") " +
            "and contains (text(), \"Да\")]");
    //Поле с текстом "Заказ оформлен"
    private By textOrder = By.className("Order_ModalHeader__3FDaJ");
    //Кнопка "Посмотреть статус"
    private By buttonOrder = By.xpath("//button[contains(text(), \"Посмотреть статус\")]");

    public PopUp(WebDriver driver){
        this.driver = driver;
    }
    //Клик на кнопку "Да" для подтверждения заказа
    public void clickYes(){
        driver.findElement(yesButton).click();
    }
    //Метод проверяющий корректность окна оформления заказа
    public void checkOrderComplete(){
        new WebDriverWait(driver, Duration.ofSeconds(1)).until
                (ExpectedConditions.textToBePresentInElementLocated(textOrder, "Заказ оформлен"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until
                (ExpectedConditions.textToBePresentInElementLocated(buttonOrder, "Посмотреть статус"));
    }
}