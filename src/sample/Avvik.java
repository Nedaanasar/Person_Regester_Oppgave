package sample;

public class Avvik {
    public static int sjekkAlder(int alder) throws InvalidDateException{
        if (alder<0 || alder>120){
            throw new InvalidDateException("Det er feil alder, alderen må være mellom 0 og 120");
        }
        return alder;

    }
    public static  int sjekkDay(int dag) throws InvalidDateException{
        if (dag<1 || dag>31){
            throw new InvalidDateException("Det er feil dag, dagen må være mellom 1 og 31");
        }
        return dag;
    }
    public static int sjkkMåned(int måned) throws InvalidDateException{
        if (måned<1 || måned>12){
            throw new InvalidDateException("Det er feil måned, måneden må være mellom 1 og 12");
        }
        return måned;
    }
    public static int sjkkÅr(int år) throws InvalidDateException{
        if (år<1900|| år>2020){
            throw new InvalidDateException("Det er feil år, Året må være mellom 1900 og 2020");
        }
        return år;
    }
}
