import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase {

    @Test
    public void test1(){

        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        WebElement datepicker = driver.findElement(By.cssSelector("#datepicker"));

        datepicker.click();

        while (!month().getText().equals("August")){
            nextMonth().click();
        }

        WebElement day = driver.findElement(By.xpath("//a[@class='ui-state-default' and text()=31]"));
        day.click();

        Assert.assertEquals(datepicker.getAttribute("value"), "08/31/2022");
    }

    public WebElement month(){
        try {
            return driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            return driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        }
    }
    public WebElement nextMonth(){
        try {
            return driver.findElement(By.xpath("//a[@data-handler='next']"));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            return driver.findElement(By.xpath("//a[@data-handler='next']"));
        }
    }
}
