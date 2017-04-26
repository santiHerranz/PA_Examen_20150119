package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public interface Pila{
    void empilar(Object o) throws Exception;
    Object desempilar () throws Exception;
    boolean pilaBuida();
    boolean pilaPlena();
    Object consultaPila() throws Exception;
    void buidar();
}
