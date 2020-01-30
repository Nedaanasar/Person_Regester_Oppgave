package sample;

public class Dato {
    private int dag;
    private int måned;
    private int år;

    public int getDag() {
        return dag;
    }

    public int getMåned() {
        return måned;
    }

    public int getÅr() {
        return år;
    }

    public Dato(int dag, int måned, int år){
        this.dag= dag;
        this.måned= måned;
        this.år= år;

    }
    public String toString(){
        return dag+"/"+måned+"/"+år;
    }
}
