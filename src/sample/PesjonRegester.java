package sample;

import Validtions.*;

import java.util.ArrayList;

public class PesjonRegester {
    public   static ArrayList<Person> personer = new ArrayList<>();



    public void regResjon(String navn, int dag,int måned, int år,String email,String tlf){
        try {
            int rektigdag= Avvik.sjekkDay(dag);
            int rektigMåned = Avvik.sjkkMåned(måned);
            int rektigÅr = Avvik.sjkkÅr(år);
            Dato nyDato = new Dato(rektigdag,rektigMåned,rektigÅr);
            Person enperson = new Person(PersonValidator.navnValidering(navn),
                    nyDato,2020-rektigÅr,

                    PersonValidator.ePostValidering(email),
                    PersonValidator.tlfNummerValidering(tlf));
            personer.add(enperson);
           /* for(Person p: personer){
                System.out.print(p);
            }*/

        }
        catch (InvalidDateException | InvalidNameException | InvalidEpostException | InvalidTlfonNrException iae){
            System.err.println(iae.getMessage());

        }
    }
    public String vispersoner(){
        String ut = " ";
        for (Person enperson : personer){
            ut+="Navnet er : "+enperson.getNavn()+", Fødselsdato er : "+enperson.getFødselsdato() +
                    " Alderen er "+enperson.getAlder()+", Eposten er "+enperson.getEpost()+ ", TelefonNr : "+enperson.getTlfNummer()+"\n"
            ;

        }
        return ut;
    }

    /*public  void testWriter(String str) {


        Path path = Paths.get("person.txt");
        try {
            FileSaverTxt fileSaver =new FileSaverTxt();
            fileSaver.writeString(path, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
