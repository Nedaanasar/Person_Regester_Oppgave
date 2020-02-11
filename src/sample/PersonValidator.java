package sample;

import Validtions.InvalidEpostException;
import Validtions.InvalidNameException;
import Validtions.InvalidTlfonNrException;

public class PersonValidator {
    public static String navnValidering(String input) throws InvalidNameException{
        String lbl = " ";
        String regx = "[A-ZÆØÅ][a-zøæå]* [A-ZÆØÅ][a-zøæå]*";
        if (!input.matches(regx)){
            throw new InvalidNameException("Skriv rektig bokstav") ;
        }
        else if (input.isEmpty()){
            throw new  InvalidNameException("Du må skriv noe på Navn felt") ;
        }
        return input;
    }
    public static String ePostValidering(String epost) throws InvalidEpostException {
        String regs = "[a-zæøåA-ZÆØÅ.-_[0-9]*]*[@][a-zæøåA-ZÆØÅ]*[.]{1}[a-zA-Z]{2,3}";
        if (!epost.matches(regs)){
            throw new InvalidEpostException("Skriv riktig Epost") ;
        }
        else if (epost.isEmpty()){
            throw new InvalidEpostException("Du må skriv noe på epost felt") ;

        }
        return epost;
    }
    public static String tlfNummerValidering(String tlf) throws InvalidTlfonNrException {
        String regx ="[0-9]{8}";
        if (!tlf.matches(regx)){
            throw new InvalidTlfonNrException("Skriv rektig tlfonNummer") ;
        }
        else if (tlf.isEmpty()){
            throw  new InvalidTlfonNrException("Du må skriv noe på telefon felt") ;
        }
        return tlf;
    }

}
