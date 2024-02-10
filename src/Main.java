import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static void check(String login,String password,String confirmPassword) throws WrongLoginException,WrongPasswordException {
        final String validPattern = "\\w+"; // ^[a-zA-z0-9_]+$
        boolean validLogin = login.matches(validPattern) && login.length() <= 20;
        boolean validPassword = password.matches(validPattern) && password.length() <= 20;
        boolean validConfirmPassword = password.equals(confirmPassword) &&
                confirmPassword.length() <= 20;
        System.out.println("login.matches(validPattern) = " + login.matches(validPattern));
        if (!validLogin) {
            throw new WrongLoginException();
        }
        if (!validPassword) {
            throw new WrongPasswordException();
        }
        if (!validConfirmPassword) {
            throw new WrongPasswordException();
        }
    }
    public static void validateLoginAndPassword(String login,String password,String confirmPassword) {
        try{
            check(login,password,confirmPassword);

        } catch ( WrongLoginException e) {
            throw new RuntimeException("Ошибка при вводе логина",e);
        }
        catch ( WrongPasswordException e) {
            throw new RuntimeException("Ошибка при вводе пароля или при его подтверждении",e);
        }
    }



    public static void main(String[] args) {
        String login = "Larochka1_3";
        String password = "1_32DhkdaDsknK";
        String confirmPassword = "1_32DhkdaDsknK";
        validateLoginAndPassword(login,password,confirmPassword);
    }

}