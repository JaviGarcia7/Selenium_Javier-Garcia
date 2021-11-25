package class11_XPathAndCSS_Selector;
//Crear una clase llamada SpotifyWithCssSelectorTest
//Crear un método llamado spotifyByPlaceHolderTest
//Ingresar al sitio: https://www.spotify.com/uy/signup/
//Completar todos los campos con Css Selector placeholder

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class spotifyWithCssSelectorTest {

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[placeholder='Introduce tu correo electrónico.']")).sendKeys("test14@mailinator.com");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test14@mailinator.com");
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys("Test321*");
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("27");
        WebElement month = driver.findElement(By.cssSelector("#month"));
        month.click();
        Select monthDrd = new Select(month);
        monthDrd.selectByVisibleText("Agosto");
        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2016");
        Thread.sleep(2000);
        WebElement genreRbt = driver.findElement(By.cssSelector(".Radio-tr5kfi-0:nth-child(2) > label"));
        genreRbt.click();

        driver.close();
    }
}
