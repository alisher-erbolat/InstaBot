package autotest.core.business;

import lombok.Getter;

/*
* Класс User - Пользователь веб приложения вынесен в отдельный класс для отделения
* бизнес логики от тестирования и классов страниц
*/
public class User {
    @Getter
    private final String email;
    @Getter
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
