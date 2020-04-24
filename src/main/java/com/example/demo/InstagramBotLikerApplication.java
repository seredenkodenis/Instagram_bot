package com.example.demo;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class InstagramBotLikerApplication {

    public static void main(String[] args) throws InterruptedException, AWTException {

        ArrayList<String> emails = new ArrayList<String>();
        ArrayList<String> usernames = new ArrayList<String>();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window();
        driver.get("https://10minutemail.net/");
        Thread.sleep(2000);
        String email = driver.findElement(By.xpath("//*[@id=\"fe_text\"]")).getAttribute("value");
        emails.add(email);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.instagram.com/accounts/emailsignup/");
        register(driver,emails.get(0),"seredenko302003",usernames);
    }

    public static void register(WebDriver driver, String email, String password, ArrayList<String> usernames) throws InterruptedException {
        Faker faker = new Faker();
        String username = faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        System.out.println("email: " + email);
        System.out.println("username: " + username);
        WebElement em = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[3]/div/label/input"));
        em.click();
        Thread.sleep(500);
        em.sendKeys(email);
        WebElement name = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[4]/div/label/input"));
        name.click();
        Thread.sleep(500);
        name.sendKeys(username);
        WebElement name2 = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[5]/div/label/input"));
        name2.click();
        name2.sendKeys(username);
        Thread.sleep(500);
        WebElement ps = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[6]/div/label/input"));
        ps.click();
        ps.sendKeys(password);
        Thread.sleep(500);
        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[7]/div/button"));
        btn.click();
        Thread.sleep(3000);
        List<WebElement> ageratio = driver.findElements(By.xpath("//*[@id=\"igCoreRadioButtonageRadioabove_18\"]"));
        if(ageratio.size() != 0){
            ageratio.get(0).click();
            System.out.println("OK!");
            driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/button")).click();
        }
        List<WebElement> selects = driver.findElements(By.className("h144Z"));
        if(selects.size() != 0){
            Select date  = new Select(selects.get(0));
            Select month  = new Select(selects.get(1));
            Select year  = new Select(selects.get(2));
            date.selectByValue("1");
            Thread.sleep(500);
            month.selectByValue("14");
            Thread.sleep(500);
            year.selectByValue("2000");
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
            Thread.sleep(700);
        }
        List<WebElement> confirm = driver.findElements(By.className("_7UhW9      x-6xq  yUEEX   KV-D4        uL8Hv     l4b0S    "));
        if(confirm.size() == 0){
            System.out.println("Created accaount or proof email");
        }else{
            System.out.println("Created but check files with confirmation");
        }
        usernames.add(username);
    }
    /*
    *
email: hwd77955@bcaoo.com
username: DarkCandance84544
*
*
*
* email: uuy20797@eoopy.com
username: TheMatthew64073
*
* email: fln47480@bcaoo.com
username: DarkLorri126
*
* email: wkv79991@bcaoo.com
username: AgentLuis3827
*
* email: yyu04989@eoopy.com
username: MagnificentMarguerite16766
*
* email: jdy50909@bcaoo.com
username: DarkMarc9798
*
* email: vtz78153@bcaoo.com
username: CaptainRolf80466
*
* email: mqv16012@eoopy.com
username: TheStuart61542
*
*
* email: jsf83047@bcaoo.com
username: UltraSteve60084
*
* 
* email: ugi02606@bcaoo.com
username: MrDennis50090
*
* email: uie08142@eoopy.com
username: DoctorAvril9788
*
* email: wgc56414@eoopy.com
username: MagnificentJodi09042
*
* email: wmj20219@eoopy.com
username: MrBrain7512
*
* email: mni51980@eoopy.com
username: DarkEdgar767
*
* email: inz89558@bcaoo.com
username: DarkLeonor508
*
*
* email: qrm11215@bcaoo.com
username: MrTheressa062
*
* email: xgi76113@eoopy.com
username: AgentHenrietta9702
*
*
* email: wsg03406@bcaoo.com
username: GeneralWerner884
*
* email: uwg42828@bcaoo.com
username: CyborgJonas075
*
* email: xyc95285@eoopy.com
username: SupahKeneth671   (6)
*
* email: qkk76851@eoopy.com
username: UltraNeville5046
*
* email: vre92148@bcaoo.com
username: CyborgEmerson39259
*
*
*email: tib21174@bcaoo.com
username: GeneralKeith061
*
    * */

    public static void login(WebDriver driver, String username, String password){
        WebElement usr = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement pswrd = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        driver.findElement(By.xpath("//input[@name=\"username\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
        usr.sendKeys(username);
        pswrd.sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public static void closeNotificationPopup(WebDriver driver){
        driver.findElement(By.xpath("//button[contains(text(), 'Not Now')]")).click();
    }
}
