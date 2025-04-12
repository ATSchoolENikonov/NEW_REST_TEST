package org.example;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Pages {String URL="https://yandex.kz";
    String Enter="//a[contains(text(),'Войти')]";
    String Title="//title[contains(text(),'Авторизация')]";
    String LOGIN="//input[@name='login']";
    String BUTTON="//button[@type='submit']";
    String Error="//div[contains(text(),'Такой логин не')]";
    String Pop="//button[@class='simple-popup__close ']";

    public void loginCheck(){
        if ($x(Pop).exists()) {
            $x(Pop).click();
        }
        $x(Enter).shouldBe(Condition.visible).click();
        $x(Title).shouldBe(Condition.exist);
        $x(LOGIN).shouldBe(Condition.visible).val("111");
        $x(BUTTON).click();
    }
}
