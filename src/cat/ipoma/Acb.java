package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public interface Acb {
    void Inserir(Comparable e) throws Exception;
    void Esborrar(Comparable e) throws Exception;
    boolean Membre(Comparable e);
    Comparable Arrel() throws Exception;
    Acb FillEsq();
    Acb FillDret();
    boolean AcbBuit();

} //fi interfície