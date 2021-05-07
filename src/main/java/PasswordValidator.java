import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    String password;

    boolean length(String password){
        return password.length()<6;
    }

    boolean OneDigit(String password){
        // compilation de la regex /*
        Pattern p = Pattern.compile("\\d+");//[0-9],\d{1,}
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }

    boolean OneLetter(String password){
        // compilation de la regex
        Pattern p = Pattern.compile("[A-Za-z]+");
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }
    //Au moins 10 caractères ● b. Au moins un caractère spéciale
    boolean DixCar(String password){
        return true;
    }

    boolean OneSpe(String password){
        return true;
    }
}
