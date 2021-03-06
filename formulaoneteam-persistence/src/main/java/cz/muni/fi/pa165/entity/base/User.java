package cz.muni.fi.pa165.entity.base;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author elderanakain (Arcadii Rubailo)
 */
@MappedSuperclass
public abstract class User extends BaseEntity {

    public final static String EMAIL_FIELD = "email";

    @NotNull
    @Column(nullable = false)
    private String name = "";

    @NotNull
    @Column(nullable = false)
    private String surname = "";

    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String email = "";

    @NotNull
    @Column(nullable = false)
    private String password = "";

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NotNull String surname) {
        this.surname = surname;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public boolean hasName() {
        return !getName().isEmpty();
    }

    public boolean hasSurname() {
        return !getSurname().isEmpty();
    }

    public boolean hasEmail() {
        return !getEmail().isEmpty();
    }

    public boolean hasFullName() {
        return hasName() && hasSurname();
    }

    public boolean hasPassword() {
        return !getPassword().isEmpty();
    }

    public boolean isConfigured() {
        return hasFullName()
                && hasEmail()
                && hasPassword()
                && hasId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                "} " + super.toString();
    }
}
