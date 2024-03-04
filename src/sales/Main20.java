package sales;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String textOnMainPage = "Весенние цены согреют с 1 по 8 марта! Не упусти возможность!";
        String textUnderPackage = "Весенние цены с 1 по 8 марта! ☀\uFE0F";

        String[][] cities = {
                {"cheliabinsk", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"omsk", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"rostov", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"ufa", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"krasnoyarsk", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"perm", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"volgograd", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"krasnodar", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"tyumen", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"},
                {"tolyatti", "//*[@id=\"acf-field_62b1f2ccf02d4\"]"}
};

        for(int i = 0; i < cities.length; i++){
            // логин в админку
            driver.get("https://"+ cities[i][0] +".avenue.school/wp-admin/edit.php?post_type=course");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("natalia.shulhaa@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("0i0bF6DA2Fo2vAKzETESzqx*");
            driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
            Thread.sleep(1000);

            // главная страница
            driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"post-2\"]/td[1]/strong/a")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"acf-group_5bfc2dcfa9939\"]/div[2]/div[1]/ul/li[1]/a")).click();
            WebElement mainTextInput = driver.findElement(By.xpath("//*[@id=\"acf-field_5bfc2e4d709b4\"]"));
            jse.executeScript("arguments[0].value='" + textOnMainPage + "'", mainTextInput);

            WebElement form = driver.findElement(By.xpath("//*[@id=\"post\"]"));
            form.submit();
            Thread.sleep(1000);

            // текст под пакетом
            driver.findElement(By.xpath("//*[@id=\"toplevel_page_theme-general-settings\"]/a")).click();
            Thread.sleep(1000);

            WebElement textUnderInput = driver.findElement(By.xpath(cities[i][1]));
            jse.executeScript("arguments[0].value='" + textUnderPackage + "'", textUnderInput);
            WebElement form2 = driver.findElement(By.xpath("//*[@id=\"post\"]"));
            form2.submit();
            Thread.sleep(1000);
        }
        driver.quit();
    }
}
