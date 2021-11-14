package class10_SeleniumTools;
//Crear una nueva branch llamada prácticoSelenium y subir una clase llamada registrationFacebookTest,
//con el siguiente ejercicio:
//Crear un método de test llamado fullRegistrationTest
//Ir a Facebook https://www.facebook.com/
//Completar los campos de registro con los siguientes valores:
//First Name: “John”
//Last Name: “Smith”
//Mobile: “5555555”
//New Password: “123456789”
//Birthday: Jun 26 1980
//Gender: Male

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    @Test
    public void registrationFacebookTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Create new account")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementMonth = driver.findElement(By.id("month"));
        Select monthSelect = new Select(elementMonth);
        monthSelect.selectByVisibleText("Jun");

        WebElement elementDay = driver.findElement(By.id("day"));
        Select daySelect = new Select(elementDay);
        daySelect.selectByVisibleText("26");

        WebElement elementYear = driver.findElement(By.id("year"));
        Select yearSelect = new Select(elementYear);
        yearSelect.selectByVisibleText("1980");

        List<WebElement> genreList = driver.findElements(By.name("sex"));
        WebElement genreMaleRadioButton = genreList.get(1);
        genreMaleRadioButton.click();

        driver.close();
    }
}
