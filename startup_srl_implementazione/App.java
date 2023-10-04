import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // creo l'oggetto startUp
        CAzienda startUp = new CAzienda();
        // leggo dal file
        startUp.uploadFromFile("temp.txt");
        // toString di tutta l'azienda
        String strStartUp = startUp.toString();
        System.out.println("File caricato: \n" + strStartUp);

        // prova delle varie funzionalità
        CUfficio uProva = new CUfficio(1, 2, "Amministrazione", "A1", "Andrea Finazzi");
        CDipendente dProva = new CDipendente("30/12/2005", "05/05/2022", 40, "Luca", "Bertiato","Via Milano 78, Cantù");
        startUp.addDipendente(uProva, dProva);
        startUp.saveOnFile("temp.txt");
        // toString di tutta l'azienda
        strStartUp = startUp.toString();
        System.out.println("File dopo modifiche dal main: \n" + strStartUp);

    }
}