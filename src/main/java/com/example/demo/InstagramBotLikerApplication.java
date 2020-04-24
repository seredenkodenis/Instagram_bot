package com.example.demo;
import java.awt.*;
import java.io.IOException;

public class InstagramBotLikerApplication {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        for(int i = 0; i < 10;++i) {
            Reger reger = new Reger("seredenko302003");
            reger.open_browser_instagram();
            reger.register();
            reger.stop();
            Thread.sleep(120000);
        }
    }

}