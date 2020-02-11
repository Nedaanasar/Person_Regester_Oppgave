package Filbehandlig;

import Validtions.InvalidPersonFormatException;
import sample.Dato;
import sample.Person;
import sample.PersonFormatter;

public class ParsePesron {
public static Person parsePerson(String str) throws InvalidPersonFormatException {
  String [] strings= str.split(PersonFormatter.DELIMITER);
  if (strings.length != 7){
      throw new InvalidPersonFormatException("Feil bruk av spesil tgen");
  }
  String navn = strings[0];
  String epost = strings[5];
  String tlfNummer = strings[6];
  int dag,måned,år,alder;
  try{
      dag= Integer.parseInt(strings[1]);
      måned= Integer.parseInt(strings[2]);
      år= Integer.parseInt(strings[3]);
      alder= Integer.parseInt(strings[4]);
  }
  catch (NumberFormatException e){
      throw new InvalidPersonFormatException("Ugjeldig number");
  }
  return new Person(navn,new Dato(dag,måned,år),alder,epost,tlfNummer);


}
}
