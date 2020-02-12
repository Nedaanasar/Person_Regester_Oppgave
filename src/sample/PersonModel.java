package sample;

import Validtions.InvalidEpostException;
import Validtions.InvalidNameException;

import Validtions.InvalidTlfonNrException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class PersonModel {


    private SimpleStringProperty navn ;
    private SimpleStringProperty epost;
    private SimpleStringProperty telfonnummer ;
    private SimpleStringProperty fødselsdato;
    private SimpleIntegerProperty alder;

    public PersonModel(String navn, String fødselsdato, String epost, String telfonnummer) {
        this.navn = new SimpleStringProperty(navn);
        this.epost = new SimpleStringProperty(epost);
        this.telfonnummer = new SimpleStringProperty(telfonnummer);
        this.fødselsdato = new SimpleStringProperty(fødselsdato);
        this.alder = new SimpleIntegerProperty(alderBeregning(fødselsdato));
    }
    private void setNavn(String navn) throws InvalidNameException {
        this.navn.set(PersonValidator.navnValidering(navn));
    }
    public String getNavn(){
        return this.navn.getValue();
    }
    public void setEpost(String epost ) throws InvalidEpostException {
        this.epost.set(PersonValidator.ePostValidering(epost));
    }
    public String getEpost(){
        return this.epost.getValue();
    }
    public void setTelfonnummer(String telfonnummer) throws InvalidTlfonNrException {
        this.telfonnummer.set(PersonValidator.tlfNummerValidering(telfonnummer));

    }
    public String getTelfonnummer(){
        return this.telfonnummer.getValue();
    }
    public void setFødselsdato(Dato fødselsdato){
        this.fødselsdato.set(String.valueOf(fødselsdato));
    }

    public String getFødselsdato() {
        return this.fødselsdato.getValue();
    }
    public void setAlder(int alder){
        this.alder.set(alder);
    }
    public int getAlder(){
        return this.alder.getValue();
    }


    private Dato fDate(String fødselsdato){

        String [] fødselsdatoArray = fødselsdato.split("-");
        int year = 0;
        int måned = 0;
        int dag = 0;
        try{
            year = Integer.parseInt(fødselsdatoArray[2]);
            måned = Integer.parseInt(fødselsdatoArray[1]);
            dag = Integer.parseInt(fødselsdatoArray[0]);
        }catch (NumberFormatException e){
            e.getMessage();
        }
        return new Dato(dag,måned,year);
    }
    private int alderBeregning(String fødselsdato){
        return 2020 - fDate(fødselsdato).getÅr();
    }








}
