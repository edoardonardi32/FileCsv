
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author nardi.edoardo
 */


/**
 * Classe principale del programma.
 * <p>
 * Questa classe contiene il metodo main che avvia l'applicazione.
 * Il programma:
 * <ul>
 *     <li>Legge i dati da un file CSV tramite FileManager</li>
 *     <li>Ordina gli accessi per data</li>
 *     <li>Stampa gli accessi ordinati</li>
 *     <li>Mostra il numero di accessi falliti per utente</li>
 *     <li>Individua eventuali IP sospetti</li>
 *     <li>Verifica accessi da IP diversi nello stesso giorno</li>
 * </ul>
 *
 * @version 1.0
 */
public class File {

    /**
     * Metodo principale che avvia l'esecuzione del programma.
     * <p>
     * Vengono creati gli oggetti FileManager e Controlli,
     * viene letta la lista dei dati dal file CSV e vengono
     * eseguiti i vari controlli sui log degli accessi.
     *
     * @param args argomenti passati da riga di comando
     */
    public static void main(String[] args) {

        FileManager fm = new FileManager();
        Controlli cr = new Controlli();

        ArrayList<Dato> lista = fm.Leggi();

        System.out.println("accessi ordinati per data");

        cr.OrdinaPerData(lista);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                lista.get(i).data + " \n" +
                lista.get(i).ip + " \n" +
                lista.get(i).accesso + " \n" +
                lista.get(i).nome
            );
        }

        System.out.println("fail per utente");
        cr.FallitiUtente(lista);

        System.out.println("ip");
        cr.IpSospetti(lista);

        System.out.println("ip diversi stesso giorno");
        cr.DiversiStessoGiorno(lista);
    }
}