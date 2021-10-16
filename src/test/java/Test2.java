import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Test2 {
    @Test
    public void Testfunc()
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.findElement(By.id("startStopButton")).click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resetButton\"]")));
//        String  innerText = driver.findElement(By.id("startStopButton")).getText();
            System.out.println("100%");


    }

    @Test
    public void Testfunc2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();

        Select choose = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]")));
        choose.selectByValue("python");

        List<WebElement> list  = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement el : list )
            {
                if (!el.isSelected()){
                    el.click();
                }

            }


        driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]")).click();

    }

    @Test
    public void Testfunc3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        WebElement box = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(box);
        WebElement textInput = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        textInput.clear();
        textInput.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]")).click();

    }


}
