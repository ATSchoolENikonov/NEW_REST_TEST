package org.example;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Selenide_LOGIN extends BaseTest{
    Pages pages=new Pages();

    @Test
    public void login(){
        openPage(pages.URL);
        pages.loginCheck();
        $x(pages.Error).shouldBe(Condition.exist);
    }
}
