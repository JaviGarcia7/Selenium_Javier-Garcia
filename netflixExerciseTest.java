//Crear un método con un nombre a seleccionar
//Acceder a Netflix: https://www.netflix.com/co/
//Mostrar los elementos h1 y h2 que hay en el sitio
//Refrescar la página
//Mostrar el texto de los botones que se encuentran en la página
//Mostrar la cantidad de elementos div que contiene el sitio
//Obtener y mostrar el título de la página
//Mostrar la cantidad de elementos de tipos link

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class netflixExerciseTest {

    @Test
    public void netflixExerciseTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/co/");
        driver.manage().window().maximize();

        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        System.out.println("The Quantity of h1 in the website is: "+listH1.size());
        System.out.println("---> H1 Elements <---");
        for (WebElement elementH1: listH1){
            System.out.println(elementH1.getText());
        }

        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));
        System.out.println("The Quantity of h2 in the website is: "+listH2.size());
        System.out.println("---> H2 Elements <---");
        for (WebElement elementH2: listH2){
            System.out.println(elementH2.getText());
        }

        driver.navigate().refresh();

        List<WebElement> listButtons = driver.findElements(By.tagName("button"));
        System.out.println("The Quantity of buttons in the website is: "+listButtons.size());
        System.out.println("---> Button Elements <---");
        for (WebElement buttons: listButtons){
            System.out.println(buttons.getText());
        }

        List<WebElement> listDivs = driver.findElements(By.tagName("div"));
        System.out.println("The Quantity of divs in the website is: "+listDivs.size());
        System.out.println("---> Div Elements <---");
        for (WebElement divs: listDivs){
            System.out.println(divs.getText());
        }

        String title = driver.getTitle();
        System.out.println("The title is: "+title);

        List<WebElement> listLinks = driver.findElements(By.tagName("a"));
        System.out.println("The Quantity of links in the website is: "+listLinks.size());
        System.out.println("---> Link Elements <---");
        for (WebElement links: listLinks){
            System.out.println(links.getText());
        }

        driver.close();
    }
}
