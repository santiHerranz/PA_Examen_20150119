package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class Immoble implements Comparable {

    private static int comptador=0;
    //Comptador d’immobles creats. Compte és estàtic!
    private int identificador; //diferent per cada immoble – és identificador
    private int superficie; //mesurat en m2
    private float preuLloguer;
    private float preuVenda;

    public Immoble(int mida, float preuVenda, float preuLloguer){
        comptador++;
        identificador=comptador;
        superficie=mida;
        this.preuLloguer=preuLloguer;
        this.preuVenda=preuVenda;
    }

    public boolean MenorQue(Comparable c){return (identificador<((Immoble)c).identificador);}
    public boolean MajorQue(Comparable c){return (identificador>((Immoble)c).identificador);}

    public float getPreuLloguer(){ return preuLloguer;}
    public float getPreuVenda(){ return preuVenda;}
    public void setPreuLloguer(float p){ preuLloguer=p;}
    public void setPreuVenda(float p){ preuVenda=p;}
    public int getIdentificador(){ return identificador;}
    public int getSuperficie(){ return superficie;}

    public String toString() {
        String s = "id: "+ String.valueOf(identificador);
        s += String.format("\tsuperficie(m2): %d",superficie) ;
        s += String.format("\tlloger: %.0f",preuLloguer) ;
        s += String.format("\tvenda: %.0f",preuVenda) ;
        return  s ;
    }
}