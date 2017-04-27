package cat.ipoma;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santi on 26/04/2017.
 */
public class AcbEnll implements Acb{



    private class Node{
        Immoble inf; Node esq,dret;
        public Node(Immoble m, Node e, Node d){inf=m;esq=e;dret=d;}

        /* TODO sentències Exercici 4 (AcbEnll Node)*/
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

        /* TODO sentències Exercici 5 (AcbEnll Node) */
        public void quinsHabitatges(Cua c) {
            // afegir a la cua si tenen preu de venda i lloger
            if (inf.getPreuVenda()!=0 && inf.getPreuLloguer()!=0){
                try{c.encuar(inf);}catch(Exception e){}}
            // recorregut per tot l arbre
            if (esq !=null) esq.quinsHabitatges(c);
            if (dret!=null) dret.quinsHabitatges(c);
        }

        //afegim a la classe Node de la AcbEnll. Aprofitem l’ordenació per fer la localització
        public Immoble hiEs(int identificador){
            if (inf.getIdentificador()==identificador)
                return inf;
            if (dret!=null && inf.getIdentificador()<identificador)
                return dret.hiEs(identificador);
            if (esq!=null && inf.getIdentificador()>identificador)
                return esq.hiEs(identificador);
            return null;
        }
    } //fi classe privada

    private Node a;
    public AcbEnll(){a=null;}

    /* TODO sentències Exercici 4 (AcbEnll)*/
    public Casa hihaCasa(float Min, float Max){
    //Cerca arbre. Recursivitat classe Node
    //sabem arbre no buit
        return a.hihaCasa(Min, Max);
    }

    /* TODO sentències Exercici 5 (AcbEnll)*/
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
        this.a = inserirRecursiu(this.a, e);
    }

    private Node inserirRecursiu(Node a, Comparable e) throws Exception {
        if(a == null) {
            a = new Node((Immoble)e,null,null);
        } else {
            if (a.inf.MajorQue(e))
                a.esq = inserirRecursiu(a.esq, e);
            if (a.inf.MenorQue(e)) {
                a.dret = inserirRecursiu(a.dret, e);
            }
        }
        return a;
    }

    @Override
    public void Esborrar(Comparable e) throws Exception {
        a = EsborrarRecursiu(a, e);
    }

    private Node EsborrarRecursiu(Node d, Comparable e) throws Exception {

        if (d==null)
            throw new Exception("l’element no hi és");
        // cerca inteligent
        // nodes ordenats per identificador del inmoble
        // recorregut en profunditat comparant el criteri
        else if (((Comparable)(d.inf)).MajorQue(e))
            d.esq=EsborrarRecursiu(d.esq,e);
        else if (((Comparable)d.inf).MenorQue(e))
            d.dret=EsborrarRecursiu(d.dret,e);
        else
            /* Node trobat */
            // cas 1: 2 fills -> obtenir node fulla per ocupar posicio
            if (d.esq!=null && d.dret!=null)
            { //sabem segur que d no es null
                d.inf= (Immoble)BuscarMinim(d.dret);
                d.dret=EsborrarMinim(d.dret);
            }
            // cas 2: sense fills -> eliminar referencia directamet
            else if (d.esq==null && d.dret==null)
                d=null;
            // cas 3: nomes fill dret -> fill dret ocupa la posicio
            else if (d.esq==null)
                d=d.dret;
            // cas 4: nomes fill esq -> fill esq ocupa la posicio
            else
                d=d.esq;
        return d;
    }

    private static Node EsborrarMinim( Node d){
        if (d.esq==null) { d=d.dret; return d;}
        else {d.esq=EsborrarMinim(d.esq); return d;}
    }
    private static Comparable BuscarMinim(Node d){
        //la d no es nul.la
        while (d.esq!=null) d=d.esq;return (Comparable)d.inf;
    }

    @Override
    public boolean Membre(Comparable e) {

        return (MembreRecursiva(a, e));
    }

    private boolean MembreRecursiva(Node d, Comparable c) {
        if (d == null) return false;
        if (((Immoble)c).getIdentificador() == ((Immoble)d.inf).getIdentificador() ) return true;
        if (c.MenorQue(d.inf))
            return (MembreRecursiva(d.esq, c));
        else if (c.MajorQue(d.inf))
            return (MembreRecursiva(d.dret, c));
        return false;
    }

    @Override
    public Comparable Arrel() throws Exception {
        if (a == null) throw new Exception("Arbre buit");
        return this.a.inf;
    }

    @Override
    public Acb FillEsq() {
        if (a != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).a.esq = a.esq;
            return v;
        } else return null;
    }
    @Override
    public Acb FillDret() {
        if (a != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).a.dret = a.dret;
            return v;
        } else return null;
    }

    @Override
    public boolean AcbBuit() {
        return this.a == null;
    }



    // EXTRA
    public List<Immoble> llistar() {
        List<Immoble> list = new ArrayList<Immoble>();
        llistarRecursiva(a, list);
        return list;
    }
    private void llistarRecursiva(Node d, List<Immoble> list) {
        if (d == null) return;
        if (d.esq!=null)
            llistarRecursiva(d.esq, list);
        list.add(d.inf);
        if (d.dret != null)
            llistarRecursiva(d.dret,list);
    }


} // fi classe