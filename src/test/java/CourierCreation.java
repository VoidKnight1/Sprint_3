import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreation {
    //Затрудняюсь в нахождении токена, на странице в f12 его нет, в задании его нет, без токена запускать не выходит, поэтому проверить написанное не получается, помогите пожалуйста
    String token = "Какой-то токен";

    @Before
    public void setUp() {
        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Adds new Courier") // имя теста
    public void addCourier() {
        Courier courier = new Courier("ninja", "1234", "saske");
        given()
                .header("Content-type", "application/json")
                .auth().oauth2(token)
                .and()
                .body(courier)
                .when()
                .post("/api/couriers")
                .then().statusCode(201);
    }












}
