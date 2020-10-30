package ua.mieshkov.ivan.string.container;

public interface RegexContainer {
    String UKR_NAME_REGEX = "[[А-ЯҐІЇЄ]&&[^ЁЫЭЪ]][[а-яґєії\\']&&[^ёыэъ]]{1,18}[[а-яґєії]&&[^ёыэъ]]";
    String LAT_NAME_REGEX = "[A-Z][a-z]+";
    String LOGIN_PASSWORD_REGEX = "[A-Za-z0-9_@]{2,20}";
    String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
}
