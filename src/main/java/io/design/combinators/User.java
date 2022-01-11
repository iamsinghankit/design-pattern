package io.design.combinators;

/**
 * @author iamsinghankit
 */
public class User {
    private final String name;
    private final int age;
    private final String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String email() {
        return email;
    }
}
