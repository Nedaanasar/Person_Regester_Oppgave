package sample;

public class Person {
    private String navn;
    private Dato fødselsdato;
    private int alder;
    private String epost;
    private String tlfNummer;

    public String getNavn() {
        return navn;
    }

    public Dato getFødselsdato() {
        return fødselsdato;
    }

    public int getAlder() {
        return alder;
    }

    public String getEpost() {
        return epost;
    }

    public String getTlfNummer() {
        return tlfNummer;
    }

    public Person(String navn, Dato fødselsdato, int alder, String epost, String tlfNummer) {
        this.navn = navn;
        this.fødselsdato= fødselsdato;
        this.alder = alder;
        this.epost=epost;
        this.tlfNummer= tlfNummer;

    }
}
