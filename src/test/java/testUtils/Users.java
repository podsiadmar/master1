package testUtils;

import java.util.HashMap;

public class Users {

    public static final HashMap<String, UserModel> userRoles = new HashMap<String, UserModel>() {{
        put("Admin", new UserModel("", ""));
    }};
}
