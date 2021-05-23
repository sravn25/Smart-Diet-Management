package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

public class Account {
    private static String users[][] = { { "Victor", "1234" }, { "Java", "1990" }, { "Placeholder", "root" } };
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

    public void register() {
        users[2][0] = username;
        users[2][1] = password;
    }
}
