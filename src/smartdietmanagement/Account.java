package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.util.regex.*;

public class Account {
    private static String users[][] = { { "Victor", "1234", "Victor Wong" }, { "Java", "1995", "Java Suns" },
            { "parabellum", "pencil", "John Wick" }, { "Placeholder", "root", "register" },
            { "Guest", "Guest", "Guest" } };
    private String username;
    private String password;

    public static int id;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int validation() {
        for (int i = 0; i < users.length; ++i) {
            if (username.compareTo(users[i][0]) == 0) {
                if (password.compareTo(users[i][1]) == 0) {
                    id = i;
                    return id;
                }
            }
        }
        return -1;
    }

    public static boolean validity(String text, String type) {
        if (type.equals("username")) {
            return Pattern.matches("\\w{4,256}", text);
        } else if (type.equals("password")) {
            return Pattern.matches("\\w{6,256}", text);
        }
        return false;
    }

    public int register(String username, String password) {
        users[3][0] = username;
        users[3][1] = password;
        return 3;
    }
}
