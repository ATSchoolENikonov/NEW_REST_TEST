package org.example;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ExtendWith(AllureJunit5.class)
public class RestAssuredTest {

    @Test
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void checkGetUser() {
        baseURI = "https://reqres.in/api";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all()
                .body(notNullValue())
                .body("data.id", everyItem(notNullValue()));
    }

    @Test
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void checkGetTEstUser2() {
        baseURI = "https://reqres.in/api";
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users/3")
                .then()
                .statusCode(200)
                .log().all()
                .body("data.email", containsString("@"));
    }

    @Test
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void checkGetTEstUserUq() {
        baseURI = "https://reqres.in/api";
        given()
                .contentType(ContentType.JSON)
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all()
                .body("page", equalTo(2));
    }


    @Test
    @Step
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void postUserTest() {
        baseURI = "https://reqres.in/api";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"name\": \"Alex\",\n" +
                        "  \"job\": \"QA\"\n" +
                        "}")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Alex"))
                .body("job", equalTo("QA"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())
                .log().all();
    }

    @Test
    @Step("SSSSS")
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void postUser2() {
        baseURI = "https://reqres.in/api";
        Map<String, Object> request = new HashMap<>();
        request.put("name", "Statam");
        request.put("job", "Loshka");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("Statam"))
                .body("job",equalTo("Loshka"))
                .log().all();
    }
    @Test
    @Epic("Smoke")
    @Feature("Main page")
    @Story("Открытие страницы")
    @Owner("you")
    @Severity(SeverityLevel.CRITICAL)
    public void postUser3() {
        baseURI = "https://reqres.in/api";
        Map<String, Object> request = new HashMap<>();
        request.put("name", "Statam");
        request.put("job", "Loshka");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("createdAt",notNullValue())
                .body("createdAt",not(blankOrNullString()))
                .log().all();
    }
}