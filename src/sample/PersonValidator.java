package sample;

public class PersonValidator {
    public static String navnValidering(String input){
        String lbl = " ";
        String regx = "[A-ZÆØÅ][a-zøæå]* [A-ZÆØÅ][a-zøæå]*";
        if (!input.matches(regx)){
            return "Skriv rektig bokstav";
        }
        else if (input.isEmpty()){
            return "Du må skriv noe på Navn felt";
        }
        return input;
    }
    public static String ePostValidering(String epost){
        String regs = "[a-zæøåA-ZÆØÅ.-_[0-9]*]*[@][a-zæøåA-ZÆØÅ]*[.]{1}[a-zA-Z]{2,3}";
        if (!epost.matches(regs)){
            return "Skriv riktig Epost";
        }
        else if (epost.isEmpty()){
            return "Du må skriv noe på epost felt";

        }
        return epost;
    }
    public static String tlfNummerValidering(String tlf){
        String regx ="[0-9]{8}";
        if (!tlf.matches(regx)){
            return "Skriv rektig tlfonNummer";
        }
        else if (tlf.isEmpty()){
            return "Du må skriv noe på telefon felt";
        }
        return tlf;
    }

}
