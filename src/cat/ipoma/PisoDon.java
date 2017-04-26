package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class PisoDon{

    private class node{
        Immoble inf;node seg;
        public node(Immoble p){this(p,null);}
        public node(Immoble p, node s){this.inf=p;this.seg=s;}
    }
    private node locals; //magatzem dels locals de la immobiliària. Seqüència enllaçada lineal sense node capçalera
    private Acb []habitatges; // taula de 2 arbres ACB, l’arbre de la posició d’índex 0
    //emmagatzemarà tots els habitatges que estan a la venda, i al d’índex 1 els que estan en
    //lloguer. NOTA: els qui tenen les dues possibilitats de gestió estaran ambdós arbres.

    public PisoDon(){
        /* TODO sentències Exercici 1 (0.5 punts)
        * Constructor, ha de crear tots els magatzems de la immobiliària. De moment romandran buits.
        * */
        locals=null; //sense capçalera de la seq enllaçada
        habitatges=new Acb[2];
        habitatges[0]=new AcbEnll(); // VENDA
        habitatges[1]=new AcbEnll(); // LLOGUER
    }

    public void afegirImmoble(Immoble p) throws Exception{
        /* TODO sentències Exercici 2 (1.5 punts)
        * el mètode ha d’afegir al magatzem adequat l’immoble que es vol donar d’alta;
        * recordeu que tenim més d’un magatzem i per tant cal afegir‐lo
        * al(s) magatzem(s) adients en funció de les característiques de l’immoble ha donar d’alta.
        * Com us podeu imaginar, no pot haver‐hi immobles repetits, en cas de donar‐se aquesta situació
        * el mètode llançarà una excepció.*/

        if (p instanceof Local){
            //afegir seq enllaçada. Recordem no té capçalera
            // BUSQUEM REPE
            node aux=locals;
            while (aux!=null){ //esquema cerca
                if (aux.inf.getIdentificador() != p.getIdentificador())
                    aux=aux.seg;
                else
                    throw new Exception("Repetit !");
            }
            //afegim al començament
            locals=new node(p,locals);
        }
        else{ //arbres, no és un local. Podrien afegir‐se als 2 arbres
            if (p.getPreuLloguer()!=0) habitatges[1].Inserir(p);
            if (p.getPreuVenda()!=0) habitatges[0].Inserir(p);
        }
    }

    public void eliminarImmoble(Immoble p) throws Exception{
        /* TODO sentències Exercici 3 (1.5 punts)
        * el mètode ha de donar de baixa l’immoble indicat al paràmetre del mètode;
        * cal eliminar‐lo del(s) magatzem(s) adient(s).
        * Llançarà una exception si l’immoble a eliminar no es troba a cap magatzem.*/

        if (p instanceof Local){
            //eliminar seq enllaçada, no té capçalera
            if (locals==null ) throw new Exception("No hi es");
            if (locals.inf.getIdentificador()==p.getIdentificador()) locals=locals.seg;
            else{
                boolean trobat=false; node aux=locals;
                while (!trobat && aux.seg!=null){
                    if (aux.seg.inf.getIdentificador()!=p.getIdentificador())
                        aux=aux.seg;
                    else trobat=true;
                }
                if(!trobat)
                    throw new Exception("No hi es");
                else aux.seg=aux.seg.seg;
            }
        }
        else{ //arbres
            if (p.getPreuLloguer()!=0) habitatges[1].Esborrar(p);
            if (p.getPreuVenda()!=0) habitatges[0].Esborrar(p);
        }
    }

    public Casa hihaCasa(float preuMinimVenda, float preuMaximVenda) throws Exception{
        /* TODO sentències Exercici 4 (2 punts)
        * el mètode ha de retornar la referència a un objecte Casa de la immobiliària que té un preu
        * de venda comprès entre ambdós preus especificats en els paràmetres del mètode.
        * Llançarà una excepció si no hi ha cap casa que compleixi el requeriment de preu.*/
        // Cerca arbre ACB pos 0
        Casa m=null;
        if (!habitatges[0].AcbBuit())
            m=((AcbEnll)habitatges[0]).hihaCasa(preuMinimVenda, preuMaximVenda);
        if (m==null) throw new Exception("Cap !!!"); else return m;
    }

    public Cua quinsHabitatges() {
        /* TODO sentències Exercici 5*/

        Cua c=new CuaEnll();
        //recorregut arbre ACB pos 0
        if (!habitatges[0].AcbBuit()) //han d’estar als dos
            ((AcbEnll)habitatges[0]).quinsHabitatges(c);
        return c;
    }
    public Pila obtenirDadesImmobles(Pila p){
        /* TODO sentències Exercici 6*/

        Pila aux = (PilaEnll)((PilaEnll)p).clone();
        Pila resultat=new PilaEnll(10);
        while (!aux.pilaBuida()){
            int identificador= 0;
            try {
                identificador = (int)aux.desempilar();
            } catch (Exception e) {
                e.printStackTrace();
            }
//no sabem quin tipus d’immoble és, no sabem en quin magatzem està
            Immoble trobat= hiEs(identificador, locals);
            if (trobat==null) trobat=hiEs(identificador, habitatges[0]);
            if (trobat==null) trobat=hiEs(identificador, habitatges[1]);
            if (trobat!=null){ try{resultat.empilar(trobat);}catch(Exception e){}}
        }
        return resultat;
    }

    private static Immoble hiEs(int identificador, node locals){
        boolean trobat=false;
        node aux=locals;
        while (!trobat && aux!=null){
            if (aux.inf.getIdentificador() != identificador)
                aux=aux.seg;
            else trobat=true;
        }
        if(!trobat)
            return null;
        else
            return aux.inf;
        //null si no hi és, sinó la referència a l’habitatge
    }

    private static Immoble hiEs(int identificador, Acb arbre){
//null si no hi és, sinó la referència a l’habitatge
//l’arbre esta ordenat per identificador. Aprofitem l’ordenació per fer la cerca
        if (!arbre.AcbBuit())
            return ((AcbEnll)arbre).hiEs(identificador);
        return null;
    }
}