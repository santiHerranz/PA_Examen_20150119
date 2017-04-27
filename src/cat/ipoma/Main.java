package cat.ipoma;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PisoDon dp = new PisoDon();

        Casa h1 = new Casa(4,1,1,301,100000,0, 1,2);
        Casa h2 = new Casa(4,1,1,302,0,400, 1,2);
        Casa h3 = new Casa(4,1,1,303,250000,0, 1,2);

        Pis p1 = new Pis(3,2,1,120,120000,0,true,1);
        Pis p2 = new Pis(3,2,1,120,130000,0,true,1);
        Pis p3 = new Pis(2,1,1,70,90000,300,true,1);
        Pis p4 = new Pis(2,1,1,70,90000,270,false,0);

        Local l1 = new Local("Botiga1", 200, 50000, 400, true);
        Local l2 = new Local("Botiga2", 200, 50000, 400, true);
        Local l3 = new Local("Botiga3", 200, 50000, 400, true);
        Local l4 = new Local("Botiga4", 200, 50000, 400, true);
        Local l5 = new Local("Botiga5", 200, 50000, 400, true);
        Local l6 = new Local("Botiga6", 200, 50000, 400, true);


        try {

            dp.afegirImmoble(p1);
            dp.afegirImmoble(p2);
            dp.afegirImmoble(p3);
            dp.afegirImmoble(p4);

            dp.afegirImmoble(h1);
            dp.afegirImmoble(h2);
            dp.afegirImmoble(h3);

            dp.afegirImmoble(l1);
            dp.afegirImmoble(l2);
            dp.afegirImmoble(l3);
            dp.afegirImmoble(l4);
            dp.afegirImmoble(l5);
            dp.afegirImmoble(l6);
/**/



            dp.eliminarImmoble(l4);

            System.out.print(dp.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        try {

            Pila ids = new PilaEnll(10);
            ids.empilar(1);
            ids.empilar(2);
            ids.empilar(3);
            ids.empilar(4);

            Pila pisos = dp.obtenirDadesImmobles(ids);

            while (!pisos.pilaBuida())
                System.out.println((Immoble)pisos.desempilar());

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
