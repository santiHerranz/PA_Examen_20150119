package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class Casa extends Habitatge {
    private float superficieJardi;
    private int nombrePlantes;
    public Casa(int habitacions, int lavabos, int parking, int mida, float preuVenda, float preuLloguer, float
            jardi, int plantes){
        super(habitacions, lavabos, parking, mida, preuVenda, preuLloguer);
        nombrePlantes=plantes; superficieJardi=jardi;
    }
    public int getNombrePlantes(){ return nombrePlantes;}
    public float getSuperficieJardi(){ return superficieJardi;}
}