package com.cyn.bean;

import java.util.Objects;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/15
 */
public class User {
    String name;
    String Gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(Gender, user.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Gender);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
