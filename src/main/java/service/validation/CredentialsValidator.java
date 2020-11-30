package service.validation;

public class CredentialsValidator {
    public static boolean isCorrect(String login, String password) {
        return isLoginCorrect(login) && isPasswordCorrect(login);

    }

    private static boolean isLoginCorrect(String login) {
        return login.length() > 2;
    }

    private static boolean isPasswordCorrect(String password) {
        return password.length() > 2;
    }

}
