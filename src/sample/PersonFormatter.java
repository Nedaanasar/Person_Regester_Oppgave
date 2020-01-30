package sample;

import java.util.ArrayList;
import java.util.List;

public class PersonFormatter {
    public static String DELIMITER = ";";

    // Følg mønsteret fra PersonFormat
    public static String formatPersoner(Person p){
        return p.getNavn()+ DELIMITER+p.getFødselsdato().getDag()+ DELIMITER+p.getFødselsdato().getMåned()+
                DELIMITER+p.getFødselsdato().getÅr()+DELIMITER+p.getAlder()+DELIMITER+p.getEpost()+DELIMITER+p.getTlfNummer();
    }
    public static String formatPeople(ArrayList<Person> plist ){
        StringBuffer str = new StringBuffer();

        for (Person p : plist){
            str.append(formatPersoner(p));
            str.append("\n");
        }
        System.out.print(str.toString());
        return str.toString();

    }
}
