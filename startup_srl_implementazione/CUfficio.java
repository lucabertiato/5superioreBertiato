import java.util.List;
import java.util.ArrayList;

public class CUfficio {
    //attributi della classe
    String nome;
    int pianoUfficio;
    String siglaUfficio;
    int nPostazioni;
    String nomeResponsabile;
    List<CDipendente> listaDipendenti = new ArrayList();

    //costruttore con parametri (in questo ordine per lunghezza fissa / variabile)
    public CUfficio(int piano, int nPostazioni, String nome,  String siglaUfficio, String nomeResponsabile) {
        this.nome = nome;
        this.pianoUfficio = piano;
        this.siglaUfficio = siglaUfficio;
        this.nPostazioni = nPostazioni;
        this.nomeResponsabile = nomeResponsabile;
        listaDipendenti = new ArrayList<CDipendente>();
    }

    //toString per ritornare tutti i parametri separati con un carattere separatore (;)
    @Override
    public String toString() {
        String str = nome + ";" + pianoUfficio + ";" + siglaUfficio + ";" + nPostazioni + ";" + nomeResponsabile;
        for (int i = 0; i < listaDipendenti.size(); i++) {
            str += "\n" + listaDipendenti.get(i).toString();
        }
        return str;
    }
}
