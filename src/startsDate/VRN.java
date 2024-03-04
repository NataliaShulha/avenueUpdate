package startsDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VRN {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // логин в админку
        driver.get("https://vrn.avenue.school/wp-admin/edit.php?post_type=course");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("natalia.shulhaa@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("0i0bF6DA2Fo2vAKzETESzqx*");
        driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
        Thread.sleep(1000);

        String[][] courses = {{"post-5428", "20240307"}, // Python для веба
                              {"post-1637", "20240307"}, // Python для анализа

                              {"post-1831", "20240308"}, // Верстка сайтов
                              {"post-1636", "20240308"}, // Front End
                              {"post-1635", "20240308"}, // Full Stack разработчик

                              {"post-1594", "20240309"}, // Java разработчик
                              {"post-1835", "20240309"}, // Android разработчик
                              {"post-1830", "20240309"}, // Автотестирование на Java

                              {"post-1837", "20240306"}, // Основы дизайна
                              {"post-1633", "20240306"}, // Графический Дизайн
                              {"post-1634", "20240306"}, // Веб дизайн

                              {"post-1861", "20240310"}, // С++
                              {"post-2433", "20240310"}, // Разработчик Игр (Unreal)

                              {"post-1832", "20240305"}, // СММ
                              {"post-1833", "20240305"}, // Интернет Маркетинг
                              {"post-1838", "20240305"}, // Контекстная реклама

                              {"post-1842", "20240311"}, // IOS разработчик
                              //   {"post-4518", "20240212"}, // Java Middle
                              {"post-1824", "20240307"}, }; // Тестирование ПО

        for (int i = 0; i < courses.length; i++) {
            driver.findElement(By.xpath("//*[@id=\"" + courses[i][0] + "\"]/td[1]/strong/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"acf-group_5bfbdd7d47d41\"]/div[2]/div[1]/ul/li[2]/a")).click();
            WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"acf-field_5bfbf230649f6\"]"));
            jse.executeScript("arguments[0].value='" + courses[i][1] + "'", dateInput);
            Thread.sleep(1000);
            WebElement form = driver.findElement(By.xpath("//*[@id=\"post\"]"));
            form.submit();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"menu-posts-course\"]/a")).click();
        }
        driver.quit();

    }
}
