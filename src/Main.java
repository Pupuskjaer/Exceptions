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
            throw new WrongLoginException("Логин может содержать только латинские буквы, " +
                    "цифры и знак подчеркивания количеством менее 20 символов");
        }
        if (!validPassword) {
            throw new WrongPasswordException("Логин может содержать только латинские буквы, " +
                    "цифры и знак подчеркивания количеством менее 20 символов");
        }
        if (!validConfirmPassword) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
    public static void validateLoginAndPassword(String login,String password,String confirmPassword) {
        try{
            check(login,password,confirmPassword);

        } catch ( WrongLoginException e) {
            throw new RuntimeException("Ошибка при вводе логина:" + e.getMessage());
        }
        catch ( WrongPasswordException e) {
            throw new RuntimeException("Ошибка при вводе пароля или при его подтверждении:" + e.getMessage());
        }
    }



    public static void main(String[] args) {

        validateLoginAndPassword("admin","admin","admin");
        validateLoginAndPassword("adminnnnnnnnnnnnnnnn","admin","admin");
        validateLoginAndPassword("admin","adminnnnnnnnnnnnnnnnnnnnn","adminnnnnnnnnnnnnnnnnnnnn");
        validateLoginAndPassword("admin","adminn","admin");
        validateLoginAndPassword("admin╗","adminn","admin");

    }

}