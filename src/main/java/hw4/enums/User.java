package hw4.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Екатерина on 08.06.2018.
 */
public enum User {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");
    public String login;
    public String password;
    public String name;

    User(String login, String password, String name) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
    private static final Map<String,User> USERS_NAME_MAP = new HashMap<>();

    static {
        for (User user : values()) {
            USERS_NAME_MAP.put(user.name, user);
        }
    }
    public static User getUserByName(String name){
        return USERS_NAME_MAP.get(name.toUpperCase());
    }
}
