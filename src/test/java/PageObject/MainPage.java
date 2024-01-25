package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class MainPage {
    private WebDriver driver;
    //Раздел вопросы о важном
    private By faqBlock = By.className("Home_FourPart__1uthg");
    //Первый вопрос о важном
    private By faqQuestion1 = By.id("accordion__heading-0");
    //Второй вопрос о важном
    private By faqQuestion2 = By.id("accordion__heading-1");
    //Третий вопрос о важном
    private By faqQuestion3 = By.id("accordion__heading-2");
    //Четвертый вопрос о важном
    private By faqQuestion4 = By.id("accordion__heading-3");
    //Пятый вопрос о важном
    private By faqQuestion5 = By.id("accordion__heading-4");
    //Шестой вопрос о важном
    private By faqQuestion6 = By.id("accordion__heading-5");
    //Седьмой вопрос о важном
    private By faqQuestion7 = By.id("accordion__heading-6");
    //Восьмой вопрос о важном
    private By faqQuestion8 = By.id("accordion__heading-7");
    //Тест первого вопрос
    private By faqText1 = By.id("accordion__panel-0");
    //Тест второго вопрос
    private By faqText2 = By.id("accordion__panel-1");
    //Тест третьего вопрос
    private By faqText3 = By.id("accordion__panel-2");
    //Тест четвертого вопрос
    private By faqText4 = By.id("accordion__panel-3");
    //Тест пятого вопрос
    private By faqText5 = By.id("accordion__panel-4");
    //Тест шестого вопрос
    private By faqText6 = By.id("accordion__panel-5");
    //Тест седьмого вопрос
    private By faqText7 = By.id("accordion__panel-6");
    //Тест восьмого вопрос
    private By faqText8 = By.id("accordion__panel-7");
    //верхняя кнопка заказа
    private By buttonTop = By.className("Button_Button__ra12g");
    //нижняя кнопка заказа
    private By buttonBottom = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //Скролл до раздел "Вопросы о важном"
    public void scrollToFaq(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(faqBlock));
    }
    //Метод для получения отдельных вопросов блока "Вопросы о важном"
    private By getFaqQuestions(int x){
        By [] questions = {faqQuestion1,faqQuestion2,faqQuestion3,faqQuestion4,
                faqQuestion5,faqQuestion6,faqQuestion7,faqQuestion8};
        return questions[x];
    }
    //Клик на разделы блока "Вопросы о важном"
    public void clickFaq(int num){
        By question = getFaqQuestions(num);
        driver.findElement(question).click();
    }
    //Метод для получения конкретного текста, появляющегося после клика на разделы блока "Вопросы о важном"
    private By getFaqText(int x){
        By [] text = {faqText1,faqText2,faqText3,faqText4,faqText5,faqText6,faqText7,faqText8};
        return text[x];
    }
    //Проверка корректности текста в разделах блока "Вопросы о важном"
    public void checkFaq(int num1, String text){
        By faqText = getFaqText(num1);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated
                        (faqText, text));
    }
    //Метод для получения конкретной кнопки "Заказать"
    private By getButtons(int x){
        By [] buttons = {buttonTop, buttonBottom};
        return buttons[x];
    }
    //Метод для проверки кнопки заказа
    public void checkButton(int buttonNumber){
        By button = getButtons(buttonNumber);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe("https://qa-scooter.praktikum-services.ru/order"));
    }
}