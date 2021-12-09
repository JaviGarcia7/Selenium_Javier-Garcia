package class12_TestNG;
//Crear un método llamado método LoginFailureTest
//En el sitio de salesforce: “https://login.salesforce.com/?locale=eu“
//Validar que se encuentre el logo en el sitio (utilizar un WebElement)
//Completar el username con “test@test.com”
//Completar el campo Password con “123456”
//Hacer click en Login
//Imprimir en pantalla el mensaje de error

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginFailureTest {

    public WebDriver driver;
    public String SITE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SITE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLoginFailureTest() throws InterruptedException {
        WebElement image = driver.findElement(By.cssSelector("#logo"));
        boolean imagePresent = image.isDisplayed();
        Assert.assertTrue(imagePresent, "No image is exist...");

        driver.findElement(By.cssSelector("#username")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#Login")).click();
        Thread.sleep(2000);
        WebElement error = driver.findElement(By.cssSelector("#error"));
        System.out.println("The error displayed is: "+error.getText());
        String errorMessage = "Your access to salesforce.com has been disabled by your system administrator. " +
                "Please contact your Administrator for more information.";
        Assert.assertEquals(errorMessage, error.getText());
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
