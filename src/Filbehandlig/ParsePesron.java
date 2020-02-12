package Filbehandlig;

import Validtions.InvalidPersonFormatException;
import sample.PersonModel;

public class ParsePesron {
public static PersonModel parsePerson(String str) throws InvalidPersonFormatException {
  String [] strings= str.split(PersonFormatter.DELIMITER);
  if (strings.length != 4){
      throw new InvalidPersonFormatException("Feil bruk av spesil tgen");
  }
  String navn = strings[0];
  String epost = strings[2];
  String tlfNummer = strings[3];
  String fødselsDato = strings[1];
  return new PersonModel(navn,fødselsDato,epost,tlfNummer);


}
}
