package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class Pis extends Habitatge {
    private int nombreTerrasses;
    private boolean traster;
    public Pis(int habitacions, int lavabos, int parking, int mida, float preuVenda, float preuLloger,
               boolean traster, int terrasses){
        super(habitacions, lavabos, parking, mida, preuVenda, preuLloger);
        nombreTerrasses=terrasses; this.traster=traster;
    }
    public int getNombreTerrases(){ return nombreTerrasses;}
    public boolean getTraster(){ return traster;}
}