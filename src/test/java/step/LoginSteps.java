package step;

import io.qameta.allure.Step;
import model.User;
import page.object.LoginPageObject;

public class LoginSteps {
    @Step("Регистрация пользователя")
    public static void login(User user, LoginPageObject loginPageObject) {
        loginPageObject.setEmail(user.getEmail());
        loginPageObject.setPassword(user.getPassword());
        loginPageObject.clickLoginButton();
    }
}
