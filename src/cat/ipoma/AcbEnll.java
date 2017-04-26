package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class AcbEnll implements Acb{



    private class Node{
        Immoble inf; Node esq,dret;
        public Node(Immoble m, Node e, Node d){inf=m;esq=e;dret=d;}

        /* TODO sentències Exercici 4 */
        //Afegim classe Node privada de la AcbEnll. No podem aprofitar l’ordenació, no és per preu
        public Casa hihaCasa(float Min, float Max){
            if (inf instanceof Casa && inf.getPreuVenda()>=Min &&
                    inf.getPreuVenda()<=Max)
                return (Casa)inf;
            if (esq !=null){
                Casa m=esq.hihaCasa(Min,Max);
                if (m!=null) return m;
            }
            if (dret!=null) return (dret.hihaCasa(Min, Max));
            return null;
        }

        public void quinsHabitatges(Cua c) {
            if (inf.getPreuVenda()!=0 && inf.getPreuLloguer()!=0){
                try{c.encuar(inf);}catch(Exception e){}}
            if (esq !=null) esq.quinsHabitatges(c);
            if (dret!=null) dret.quinsHabitatges(c);
        }

        //afegim a la classe Node de la AcbEnll. Aprofitem l’ordenació per fer la localització
        public Immoble hiEs(int identificador){
            if (inf.getIdentificador()==identificador) return inf;
            if (dret!=null && inf.getIdentificador()<identificador) return dret.hiEs(identificador);
            if (esq!=null && inf.getIdentificador()>identificador) return esq.hiEs(identificador);
            return null;
        }
    } //fi classe privada

    private Node a;
    public AcbEnll(){a=null;}

    /* TODO sentències Exercici 4 */
    public Casa hihaCasa(float Min, float Max){
    //Cerca arbre. Recursivitat classe Node
    //sabem arbre no buit
        return a.hihaCasa(Min, Max);
    }


    public void quinsHabitatges(Cua c) {
        //recorregut arbre. Recursivitat classe Node
        //sabem arbre no buit
        a.quinsHabitatges(c);
    }

    public Immoble hiEs(int identificador){
        return a.hiEs(identificador);
    }

    /*implementació de totes les operacions de la interfície */

    @Override
    public void Inserir(Comparable e) throws Exception {

    }

    @Override
    public void Esborrar(Comparable e) throws Exception {

    }

    @Override
    public boolean Membre(Comparable e) {
        return false;
    }

    @Override
    public Comparable Arrel() throws Exception {
        return null;
    }

    @Override
    public Acb FillEsq() {
        return null;
    }

    @Override
    public Acb FillDret() {
        return null;
    }

    @Override
    public boolean AcbBuit() {
        return false;
    }

} // fi classe