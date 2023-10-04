import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class CAzienda {
    // attributi
    List<CUfficio> listaUffici = new ArrayList();

    // costruttore di default
    public CAzienda() {
        this.listaUffici = new ArrayList<CUfficio>();
    }

    // aggiunge un dipendente a un determinato ufficio presente nella lista
    // se l'ufficio non c'è lo crea
    public boolean addDipendente(CUfficio u, CDipendente d) {
        // ciclo che controlla se l'ufficio richiesto esiste
        for (int i = 0; i < listaUffici.size(); i++) {
            // se trova una corrispondenza aggiunge il dipendete e esce dal ciclo for
            if (listaUffici.get(i).nome.equals(u.nome)) {
                listaUffici.get(i).listaDipendenti.add(d);
                return true;
            }
        }
        // se arriva qua vuol dire che bisogna aggiungere un nuovo ufficio
        CUfficio uTemp = u;
        uTemp.listaDipendenti.add(d);
        listaUffici.add(u);
        return true;
    }

    // per avere una stringa con tutti gli uffici e i dipendeti dell'azienda
    @Override
    public String toString() {
        String str = "";
        // per ogni ufficio
        for (int i = 0; i < listaUffici.size(); i++) {
            str += listaUffici.get(i).toString() + "\n";
        }
        return str;
    }

    // carica il file nella lista
    public void uploadFromFile(String pathName) throws IOException {
        // apro il file in lettura
        FileReader fR = new FileReader(pathName);
        // buffer per leggere
        BufferedReader reader = new BufferedReader(fR);
        // variabile in cui memorizzo le linee del file (prima linea non da memorizzare)
        String line = reader.readLine();
        // finchè non arrivo alla fine del file
        while ((line = reader.readLine()) != null) {
            // splitta
            String vettSplit[] = line.split(";");
            // crea un oggetto dipendente
            CDipendente dTemp = new CDipendente(vettSplit[0], vettSplit[1], Integer.parseInt(vettSplit[2]), vettSplit[5], vettSplit[6], vettSplit[7]);
            // creo ufficio
            CUfficio uTemp = new CUfficio(Integer.parseInt(vettSplit[3]), Integer.parseInt(vettSplit[4]), vettSplit[8], vettSplit[9], vettSplit[10]);
            // aggiungo
            addDipendente(uTemp, dTemp);
        }
        // chiudo il buffer e il file aperto il lettura
        reader.close();
        fR.close();
    }

    // salvo la lista su un file
    public void saveOnFile(String pathName) throws IOException {
        // apro il file in scrittura (sovrascive)
        FileWriter fW = new FileWriter(pathName);
        // riga iniziale del file per indicare come sono memorizzati i parametri
        String str = "dataNascita;dataAssunzione;numOreSett;pianoUfficio;numPostazioni;nome;cognome;residenza;nomeUfficio;siglaLocale;nomeResponsabile;\n";
        fW.write(str);
        str = "";
        // per tutti gli uffici
        for (int i = 0; i < listaUffici.size(); i++) {
            // creo un oggetto ufficio e uno dipendente temporanei
            CUfficio uTemp = listaUffici.get(i);
            CDipendente dTemp = new CDipendente(str, str, i, str, pathName, str);
            // per tutti i dipendenti dell'ufficio i
            for (int c = 0; c < uTemp.listaDipendenti.size(); c++) {
                // iesimo dipendente della lista
                dTemp = uTemp.listaDipendenti.get(c);
                // salva su una variabile la stringa da scrivere sul file
                // prima memorizio i parametri a lunghezza fissa (interi, date ec...) e poi
                // tutti quelli a lunghezza variabili (stringe...)
                str += dTemp.dataNascita + ";" + dTemp.dataAssunzione + ";" + dTemp.numOreSettimanali + ";"
                        + uTemp.pianoUfficio + ";" + uTemp.nPostazioni + ";" + dTemp.nome + ";" + dTemp.cognome + ";"
                        + dTemp.residenza + ";" + uTemp.nome + ";" + uTemp.siglaUfficio + ";" + uTemp.nomeResponsabile
                        + ";\n";
                // scrivi sul file
                fW.write(str);
            }
        }
        // pulisci
        fW.flush();
        // chiudo il file apero in scrittura
        fW.close();
    }
}
