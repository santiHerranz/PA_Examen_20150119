package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class Habitatge extends Immoble {
    private int nombreHabitacions;
    private int nombreLavabos;
    private int nombrePlacesParking;
    public Habitatge(int habitacions, int lavabos, int parking, int mida, float preuVenda, float
            preuLloguer){
        super(mida, preuVenda, preuLloguer);
        nombreHabitacions=habitacions;nombreLavabos=lavabos; nombrePlacesParking=parking;
    }
    public int getNombreHabitacions(){ return nombreHabitacions;}
    public int getNombreLavabos(){ return nombreLavabos;}
    public int getNombrePlacesParking(){ return nombrePlacesParking;}
}