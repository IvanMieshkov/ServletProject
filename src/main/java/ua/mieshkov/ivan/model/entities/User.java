package ua.mieshkov.ivan.model.entities;

public class User {
    private Integer id;
    private String nameUkr;
    private String nameEn;
    private String login;
    private String password;
    private String gender;
    private String email;
    private String role;
    private boolean active;

    public User(String nameUkr, String nameEn, String login,
                String password, String gender, String email, String role) {
        this.nameUkr = nameUkr;
        this.nameEn = nameEn;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.role = role;
    }

    public User(Integer id, String nameUkr, String nameEn, String login,
                String password, String gender, String email, String role, boolean active) {
        this.id = id;
        this.nameUkr = nameUkr;
        this.nameEn = nameEn;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameUkr() {
        return nameUkr;
    }

    public void setNameUkr(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

