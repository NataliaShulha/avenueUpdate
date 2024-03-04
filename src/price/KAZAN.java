package price;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KAZAN {
    public static void main(String[] args) throws InterruptedException {
        int priceMonthOchno = 9039; // очно
        int priceMonthOnline = 8214; // онлайн
        int priceMonthVidep = 7393; // видео

        int oldPriceOchno = 24430; // старая цена Очно
        int oldPriceOnline = 22200; // старая цена Онлайн
        int oldPriceVideo = 19980; // старая цена Видео

        String monthPriceOznoStr = "Данный пакет можно приобрести в рассрочку БЕЗ банка по 10 990 руб./мес."; // очно
        String monthPriceOnlineStr = "Данный пакет можно приобрести в рассрочку БЕЗ банка по 9 990 руб./мес."; // онлайн
        String monthPriceVideoStr = "Данный пакет можно приобрести в рассрочку БЕЗ банка по 8 990 руб./мес."; // видео

        String[][] courses = {{"post-5446", "4"}, // Python для веба
                {"post-1637", "4"}, // Python для анализа

                {"post-1831", "2"}, // Верстка сайтов
                {"post-1636", "5"}, // Front End
                {"post-1635", "6"}, // Full Stack разработчик

                {"post-1594", "5.5"}, // Java разработчик
                {"post-1835", "4.5"}, // Android разработчик
                {"post-1830", "4"}, // Автотестирование на Java

                {"post-1837", "2"}, // Основы дизайна
                {"post-1633", "3.5"}, // Графический Дизайн
                {"post-1634", "3.5"}, // Веб дизайн

                {"post-1861", "4"}, // С++
                {"post-2433", "3.5"}, // Разработчик Игр (Unreal)

                {"post-1832", "3"}, // СММ
                {"post-1833", "4"}, // Интернет Маркетинг
                {"post-1838", "2"}, // Контекстная реклама

                {"post-1842", "4"}, // IOS разработчик
                //{"post-4518", "20240207"}, // Java Middle
                {"post-1824", "3"}, }; // Тестирование ПО

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // логин в админку
        driver.get("https://kazan.avenue.school/wp-admin/edit.php?post_type=course");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("natalia.shulhaa@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("0i0bF6DA2Fo2vAKzETESzqx*");
        driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
        Thread.sleep(1000);

        for (int i = 0; i < courses.length; i++) {
            driver.findElement(By.xpath("//*[@id=\"" + courses[i][0] + "\"]/td[1]/strong/a")).click();
            Thread.sleep(1000);
            // основная цена курса
            driver.findElement(By.xpath("//*[@id=\"acf-group_5bfbdd7d47d41\"]/div[2]/div[1]/ul/li[1]/a")).click();
            WebElement mainPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5bfc158339f66\"]"));
            double month = Double.parseDouble(courses[i][1]);
            int mainPrice = (int) (month * priceMonthVidep);
            String priceStr = mainPrice + " руб";
            priceStr = priceStr.substring(0, priceStr.length() - 7) + " " + priceStr.substring(priceStr.length() - 7);
            jse.executeScript("arguments[0].value='" + priceStr + "'", mainPriceElem);

            // все остальные цены
            driver.findElement(By.xpath("//*[@id=\"acf-group_5bfbdd7d47d41\"]/div[2]/div[1]/ul/li[6]/a")).click();
            // онлайн
            WebElement onlinePriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-0-field_5e7de79e9a16a\"]"));
            int onlinePrice = (int) (month * priceMonthOnline);
            String onlineStr = onlinePrice + " руб";
            onlineStr = onlineStr.substring(0, onlineStr.length() - 7) + " " + onlineStr.substring(onlineStr.length() - 7);
            jse.executeScript("arguments[0].value='" + onlineStr + "'", onlinePriceElem);

            // онлайн старая цена
            WebElement oldOnlinePriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-0-field_5d125adcfdc7f\"]"));
            int OldOnlinePrice = (int) (month * oldPriceOnline);
            String oldOnlineStr = OldOnlinePrice + " руб";
            oldOnlineStr = oldOnlineStr.substring(0, oldOnlineStr.length() - 7) + " " + oldOnlineStr.substring(oldOnlineStr.length() - 7);
            jse.executeScript("arguments[0].value='" + oldOnlineStr + "'", oldOnlinePriceElem);

            // очно
            WebElement ochnoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-1-field_5e7de79e9a16a\"]"));
            int ochnoPrice = (int) (month * priceMonthOchno);
            String ochnoStr = ochnoPrice + " руб";
            ochnoStr = ochnoStr.substring(0, ochnoStr.length() - 7) + " " + ochnoStr.substring(ochnoStr.length() - 7);
            jse.executeScript("arguments[0].value='" + ochnoStr + "'", ochnoPriceElem);

            // очно старая цена
            WebElement oldOchnoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-1-field_5d125adcfdc7f\"]"));
            int oldOchnoPrice = (int) (month * oldPriceOchno);
            String oldOchnoStr = oldOchnoPrice + " руб";
            oldOchnoStr = oldOchnoStr.substring(0, oldOchnoStr.length() - 7) + " " + oldOchnoStr.substring(oldOchnoStr.length() - 7);
            jse.executeScript("arguments[0].value='" + oldOchnoStr + "'", oldOchnoPriceElem);

            // видео
            WebElement videoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-2-field_5e7de79e9a16a\"]"));
            jse.executeScript("arguments[0].value='" + priceStr + "'", videoPriceElem);

            // видео старая цена
            WebElement oldVideoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_5d125a73fdc7c-2-field_5d125adcfdc7f\"]"));
            int oldVideoPrice = (int) (month * oldPriceVideo);
            String oldVideoStr = oldVideoPrice + " руб";
            oldVideoStr = oldVideoStr.substring(0, oldVideoStr.length() - 7) + " " + oldVideoStr.substring(oldVideoStr.length() - 7);
            jse.executeScript("arguments[0].value='" + oldVideoStr + "'", oldVideoPriceElem);

            // осправка формы для сохранения
            WebElement form = driver.findElement(By.xpath("//*[@id=\"post\"]"));
            form.submit();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"menu-posts-course\"]/a")).click();
        }

        // помесячная оплата без банка
        driver.findElement(By.xpath("//*[@id=\"toplevel_page_theme-general-settings\"]/a")).click();
        Thread.sleep(1000);
        WebElement strOchnoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_614c780fd5327\"]"));
        jse.executeScript("arguments[0].value='" + monthPriceOznoStr + "'", strOchnoPriceElem);
        WebElement strOnlinePriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_614c7802d5326\"]"));
        jse.executeScript("arguments[0].value='" + monthPriceOnlineStr + "'", strOnlinePriceElem);
        WebElement strVideoPriceElem = driver.findElement(By.xpath("//*[@id=\"acf-field_614c781cd5328\"]"));
        jse.executeScript("arguments[0].value='" + monthPriceVideoStr + "'", strVideoPriceElem);
        WebElement formMonth = driver.findElement(By.xpath("//*[@id=\"post\"]"));
        formMonth.submit();
        Thread.sleep(1000);

        driver.quit();

    }
}
