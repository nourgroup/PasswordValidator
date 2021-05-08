import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    String password;

    public enum Strings {
        AtLeastlength("At Least 6 in length"),
        AtLeastOneDigit("At Least One Digit"),
        AtLeastOneLetter("At Least One Letter"),
        AtLeastDixCar("At Least ten Character"),
        AtLeastOneCarSpe("At Least One Special Character");

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
        return password.length()>6;
    }

    boolean AtLeastOneDigit(String password){
        // compilation de la regex /*
        Pattern p = Pattern.compile("[0-9]+");//,
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
        Pattern p = Pattern.compile("[@,#,$,%]+");
        // création d'un moteur de recherche
        Matcher m = p.matcher(password);
        // lancement de la recherche de toutes les occurrences
        return m.matches();
    }

    boolean verifyAllForUser(String password){
        return AtLeastlength(password)
                && AtLeastOneDigit(password)
                && AtLeastOneLetter(password);
    }

    boolean verifyAllForAdmin(String password){
        return verifyAllForUser(password)
                && AtLeastDixCar(password)
                && AtLeastOneCarSpe(password);
    }

    ArrayList<Strings> msgErrorUser(String password){
        ArrayList<Strings> ERROR = new ArrayList<>();
        if(verifyAllForUser(password)){
            return null;
        }
        if(!AtLeastlength(password)){
            ERROR.add(Strings.AtLeastlength);
        }
        if(!AtLeastOneDigit(password)){
            ERROR.add(Strings.AtLeastOneDigit);
        }
        if(!AtLeastOneLetter(password)){
            ERROR.add(Strings.AtLeastOneLetter);
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


    ArrayList<Strings> msgErrorAdmin(String password){
        ArrayList<Strings> ERROR = msgErrorUser(password);
        if(verifyAllForAdmin(password)){
            return null;
        }

        if(!AtLeastOneCarSpe(password)){
            ERROR.add(Strings.AtLeastOneCarSpe);
        }

        if(!AtLeastDixCar(password)){
            ERROR.add(Strings.AtLeastDixCar);
        }

        return ERROR;
    }

}
