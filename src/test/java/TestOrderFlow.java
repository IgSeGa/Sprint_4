import page.object.MainPage;
import page.object.PopUp;
import page.object.RentPage;
import page.object.WhoPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestOrderFlow {
    WebDriver driver = new FirefoxDriver();
    //Поле с именем для ввода в поле Имя
    private final String name;
    //После с фамилией для ввода в поле Фамилия
    private final String surname;
    //Поле с адресом для ввода в поле Адрес
    private final String toWhere;
    //Поле с номером телефона для ввода в поле Телефон
    private final String phoneNumber;
    //Поле с датой для поля Когда привезти самокат
    private final String date;
    //Поле с текстом для поля "Комментарий"
    private final String textComment;
    //Поле со значением для выбора кнопки "Заказать" (значение 0 или 1, где 0 - кнопка в шапке, а 1 - в середине страницы)
    private final int buttonNumber;

    public TestOrderFlow(String name, String surname, String toWhere, String phoneNumber, String date, String textComment,
                         int buttonNumber) {
        this.name = name;
        this.surname = surname;
        this.toWhere = toWhere;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.textComment = textComment;
        this.buttonNumber = buttonNumber;
    }
    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Имя", "Фамилия", "Нигдегород", "+12345678901", "28.01.2024", "Комментарий", 0},
                {"Артём", "Савиновский", "ул. Льва Толстого, 16", "8(800)250-96-39", "31.12.2024",
                        "Доставлять строго до 17:00, дальше никого не будет дома", 1}
        };
    }
    @Test
    public void checkOrderFlow(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        WhoPage objWhoPage = new WhoPage(driver);
        RentPage objRentPage = new RentPage(driver);
        PopUp objPopUp = new PopUp(driver);
        objMainPage.checkButton(buttonNumber);
        objWhoPage.fillFormsWho(name, surname,toWhere,phoneNumber);
        objWhoPage.checkButtonNext();
        objRentPage.fillFormsRent(date, textComment);
        objRentPage.clickOrderButton();
        objPopUp.clickYes();
        objPopUp.checkOrderComplete();
    }
    @After
    public void endTest(){
        driver.quit();
    }
}