package model;

import com.github.javafaker.Faker;

import java.util.Locale;

public class User {
    private String name;
    private String email;
    private String password;

    private final static Faker faker = new Faker(new Locale("ru_RU"));

    public static User random() {
        User user = new User();

        user.name = faker.name().firstName();
        user.email = faker.internet().emailAddress();
        user.password = faker.internet().password();

        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
