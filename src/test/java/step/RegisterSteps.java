package step;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import model.User;
import page.object.RegisterPageObject;

import static io.restassured.RestAssured.given;

public class RegisterSteps {
    static {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Step("Регистрация пользователя")
    public static void registerUser(User user, RegisterPageObject registerPageObject) {
        registerPageObject.setName(user.getName());
        registerPageObject.setEmail(user.getEmail());
        registerPageObject.setPassword(user.getPassword());
        registerPageObject.clickRegisterButton();
    }

    @Step("Создание Пользователя через API")
    public static String registerUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("api/auth/register")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Step("Удаление Пользователя через API")
    public static void deleteUser(String tokenToDelete) {
        given()
                .header("Content-type", "application/json")
                .header("authorization", tokenToDelete)
                .and()
                .body("")
                .when()
                .delete("api/auth/user")
                .then()
                .assertThat()
                .statusCode(202);
    }

    @Step("Удаление Пользователя через API")
    public static void deleteUser(User user) {
        String token = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("api/auth/login")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");

        deleteUser(token);
    }
}
