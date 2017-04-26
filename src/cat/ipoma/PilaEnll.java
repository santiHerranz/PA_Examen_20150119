package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class PilaEnll implements Pila {

    private class Node {
        private Object inf;
        private Node seg;

        Node(Object data){
            this.inf = data;
        }
    }

    @Override
    public void empilar(Object o) throws Exception {

    }

    @Override
    public Object desempilar() throws Exception {
        return null;
    }

    @Override
    public boolean pilaBuida() {
        return false;
    }

    @Override
    public boolean pilaPlena() {
        return false;
    }

    @Override
    public Object consultaPila() throws Exception {
        return null;
    }

    @Override
    public void buidar() {

    }


    @Override
    public Pila clone() {
        PilaEnll copia = new PilaEnll();

        // TODO

        return copia;
    }
}
