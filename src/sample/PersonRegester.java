package sample;

import Validtions.*;

import java.util.ArrayList;

public class PersonRegester {
    public   static ArrayList<PersonModel> personer = new ArrayList<>();



    public boolean regester(String navn, int dag, int måned, int år, String email, String tlf){
        boolean lages = true;
        try {
            int rektigdag= Avvik.sjekkDay(dag);
            int rektigMåned = Avvik.sjkkMåned(måned);
            int rektigÅr = Avvik.sjkkÅr(år);
            Dato nyDato = new Dato(rektigdag,rektigMåned,rektigÅr);
            String datoS = nyDato.toString();
            PersonModel enperson = new PersonModel(PersonValidator.navnValidering(navn),datoS,PersonValidator.ePostValidering(email),
                    PersonValidator.tlfNummerValidering(tlf));
            personer.add(enperson);

        }
        catch (InvalidDateException | InvalidNameException | InvalidEpostException | InvalidTlfonNrException iae){
            System.err.println(iae.getMessage());
            lages = false;
        }
        return lages;
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
