package cat.ipoma;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PisoDon dp = new PisoDon();

        Habitatge h1 = new Habitatge(4,1,1,300,100000,0);
        Habitatge h2 = new Habitatge(4,1,1,300,0,400);
        Habitatge h3 = new Habitatge(4,1,1,300,250000,0);

        Local l1 = new Local("Botiga", 200, 50000, 400, true);

        try {

            dp.afegirImmoble(h1);
            dp.afegirImmoble(h2);
            dp.afegirImmoble(h3);

            dp.afegirImmoble(l1);

        } catch (Exception e) {
            e.printStackTrace();
        }

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
    }
}
