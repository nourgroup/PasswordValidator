public class PasswordValidator {
    String password;

    boolean length(String password){
        return password.length()<6;
    }

    boolean digit(String password){
        return true;
    }

    boolean letter(String password){
        return true;
    }
}
