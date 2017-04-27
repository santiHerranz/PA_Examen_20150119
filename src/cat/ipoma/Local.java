package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class Local extends Immoble {
    private String tipusNegoci;
    private boolean lavabo;
    public Local(String tipusNegoci, int mida, float preuVenda, float preuLloguer, boolean lavabo){
        super(mida,preuVenda,preuLloguer); this.tipusNegoci=tipusNegoci;this.lavabo=lavabo;
    }
    public boolean getLavabo(){ return lavabo;}
    public String getTipusNegoci(){ return tipusNegoci;}



    @Override
    public String toString() {
        String s = "Local\t ";
        s += super.toString();
        s += String.format("\ttipusNegoci: %s",tipusNegoci) ;
        s += String.format("\tlavabo: %s",(lavabo?"SI":"NO")) ;
        return s;
    }
}

