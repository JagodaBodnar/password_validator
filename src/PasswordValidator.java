import java.util.Scanner;

public class PasswordValidator {
    private String currentPassword;
    private String userName;
    static Scanner scanner = new Scanner(System.in);
    public PasswordValidator(String username, String currentPassword) {
        this.userName = username;
        this.currentPassword = currentPassword;
    }
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator(getUserName(), getPassword());
        getNewPassword(validator);
        scanner.close();
    }

    public static String getUserName() {
        System.out.println("Please enter username: ");
        return scanner.next();
    }

    public static String getPassword() {
        System.out.println("Please enter password: ");
        return scanner.next();
    }

    public static void getNewPassword(PasswordValidator validator) {
        System.out.println("Your password has expired.");
        String password;
        boolean isIncorrect = true;
        do {
            if(isIncorrect){
                printPasswordRules();
            }
            System.out.println("Please enter new password: ");
            password = scanner.next();
            isIncorrect = false;
        } while (!validator.isValid(password));
        System.out.println("Your new password is correct!");
    }

    public boolean isValid(String password) {
        if (password.length() < 8) {
            System.out.println("Password needs to be at least 8 characters long.");
            return false;
        }
        if (password.equals(password.toLowerCase())) {
            System.out.println("Password needs to contain an upper case letter.");
            return false;
        }
        if (password.matches("[a-zA-Z0-9 ]*")) {
            System.out.println("Password needs to contain a special character.");
            return false;
        }
        if (password.toLowerCase().contains(userName.toLowerCase())) {
            System.out.println("Password can't contain the username.");
            return false;
        }
        if (password.equals(currentPassword)) {
            System.out.println("Password can't be the same as the old password. ");
            return false;
        }
        return true;
    }

    public static void printPasswordRules() {
        System.out.println("----------------------");
        System.out.printf("Password must: %n" +
                "be at least 8 characters long %n" +
                "contain an uppercase letter %n" +
                "contain a special character %n" +
                "not contain the username %n" +
                "not be the same as the old password%n");
        System.out.println("----------------------");
    }

}
