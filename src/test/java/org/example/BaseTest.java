package org.example;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public void openPage(String url){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        open(url);
    }

}
