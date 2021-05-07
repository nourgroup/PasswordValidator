import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    String password;

    public enum Strings {
        AtLeastlength("AtLeastlength"),
        AtLeastOneDigit("AtLeastOneDigit"),
        AtLeastOneLetter("AtLeastOneLetter"),
        AtLeastDixCar("AtLeastDixCar"),
        AtLeastOneCarSpe("AtLeastOneCarSpe");

        private final String text;

        Strings(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }


    boolean AtLeastlength(String password){
        return password.length()<6;
    }

    boolean AtLeastOneDigit(String password){
        // compilation de la regex /*
        Pattern p = Pattern.compile("\\d{1,}");//[0-9],
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }

    boolean AtLeastOneLetter(String password){
        // compilation de la regex
        Pattern p = Pattern.compile("[A-Za-z]+");
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }
    //Au moins 10 caractères
    boolean AtLeastDixCar(String password){
        return password.length()>9;
    }
    //Au moins un caractère spéciale
    boolean AtLeastOneCarSpe(String password){
        // compilation de la regex
        Pattern p = Pattern.compile("\\W");
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }

    boolean verifyAll(String password){
        return AtLeastlength(password)
                && AtLeastOneDigit(password)
                && AtLeastOneLetter(password)
                && AtLeastDixCar(password)
            && AtLeastOneCarSpe(password);
    }

    ArrayList<Strings> msgError(String password){
        ArrayList<Strings> ERROR = new ArrayList<>();
        if(verifyAll(password)){
            return null;
        }
        if(!AtLeastOneDigit(password)){
            ERROR.add(Strings.AtLeastlength);
        }
        if(!AtLeastOneLetter(password)){
            ERROR.add(Strings.AtLeastOneDigit);
        }
        if(!AtLeastDixCar(password)){
            ERROR.add(Strings.AtLeastOneLetter);
        }
        if(!AtLeastOneCarSpe(password)){
            ERROR.add(Strings.AtLeastDixCar);
        }
        if(!AtLeastOneCarSpe(password)){
            ERROR.add(Strings.AtLeastOneCarSpe);
        }
        /**
         AtLeastlength("AtLeastlength"),
         AtLeastOneDigit("AtLeastOneDigit"),
         AtLeastOneLetter("AtLeastOneLetter"),
         AtLeastDixCar("AtLeastDixCar"),
         AtLeastOneCarSpe("AtLeastOneCarSpe")
         */
        return ERROR;
    }


}
