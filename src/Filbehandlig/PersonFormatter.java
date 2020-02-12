package Filbehandlig;

import sample.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class PersonFormatter {
    public static String DELIMITER = ";";

    // Følg mønsteret fra PersonFormat
    public static String formatPersoner(PersonModel model){
        return model.getNavn()+ DELIMITER+model.getFødselsdato()+DELIMITER+model.getEpost()+DELIMITER+model.getTelfonnummer();
    }
    public static String formatPeople(ArrayList<PersonModel> plist ){
        StringBuffer str = new StringBuffer();


        for (PersonModel model : plist){
            str.append(formatPersoner(model));
            str.append("\n");
        }
        //System.out.print(str.toString());
        return str.toString();

    }
}
