package cat.ipoma;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PisoDon dp = new PisoDon();

        Habitatge h1 = new Habitatge(4,1,1,300,100000,400);


        try {
            dp.afegirImmoble(h1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
