package com.example.demo;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Reger {
    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> usernames = new ArrayList<String>();
    String password;
    File file = new File("confirm.txt");
    FileWriter fr = new FileWriter(file, true);
    FileWriter accs = new FileWriter("accs.txt");
    WebDriver driver = new ChromeDriver();

    public Reger(String password) throws IOException {
        this.password = password;
    }

    public void open_browser_instagram() throws InterruptedException, AWTException {
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
    }

    public String createUsername(){
        Faker faker = new Faker();
        String username = faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        usernames.add(username);
        return username;
    }
    public void insertRegForm(String username) throws InterruptedException {
        WebElement em = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[1]/div/form/div[3]/div/label/input"));
        em.click();
        Thread.sleep(500);
        em.sendKeys(emails.get(0));
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
    }

    public void register() throws InterruptedException, IOException {
        String username = createUsername();
        insertRegForm(username);
        java.util.List<WebElement> ageratio = driver.findElements(By.xpath("//*[@id=\"igCoreRadioButtonageRadioabove_18\"]"));
        if(ageratio.size() != 0){
            ageratio.get(0).click();
            System.out.println("OK!");
            driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/button")).click();
        }
        java.util.List<WebElement> selects = driver.findElements(By.className("h144Z"));
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
        Thread.sleep(300);
        List<WebElement> confirm = driver.findElements(By.cssSelector("h2"));
        if(confirm.size() == 0){
            System.out.println("error or try to change vpn");
        }else{
            System.out.println("Created but check files with confirmation");
            BufferedWriter br = new BufferedWriter(fr);
            br.write("username: " + username + "\npassword: " + password + "\n\n\n");
            br.close();
            fr.close();
        }
        usernames.add(username);
        System.out.println(username);
    }

    public void stop(){
        System.out.println("BYE!");
        driver.quit();
    }
}
