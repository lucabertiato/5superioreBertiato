public class CDipendente{
    //attributi per la classe dipendente
    public String nome;
    public String cognome;
    public String residenza;
    public String dataNascita;
    public String dataAssunzione;
    public int numOreSettimanali;

    //costruttore cdi default
    public CDipendente() {
        this.nome = "";
        this.cognome = "";
        this.residenza = "";
        this.dataNascita = "";
        this.dataAssunzione = "";
        this.numOreSettimanali = -1;
    }

    //costruttore con parametri (in questo ordine per lunghezza fissa / variabile)
    public CDipendente(String dataN, String dataA, int numOreSettimanali, String nome, String cognome, String residenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.residenza = residenza;
        this.dataNascita = dataN;
        this.dataAssunzione = dataA;
        this.numOreSettimanali = numOreSettimanali;
    }

    //toString per ritornare tutti i parametri separati con un carattere separatore (;)
    @Override
    public String toString(){
        return nome + ";" + cognome + ";" + residenza + ";" + dataNascita + ";" + dataAssunzione + ";" + numOreSettimanali;
    }
}

