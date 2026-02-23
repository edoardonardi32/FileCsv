
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nardi.edoardo
 */
/**
 * La classe Controlli fornisce metodi per l'analisi
 * dei dati di accesso letti dal file CSV.
 * <p>
 * I controlli permettono di:
 * <ul>
 *     <li>Contare i tentativi di accesso falliti per utente</li>
 *     <li>Individuare IP sospetti</li>
 *     <li>Verificare accessi da IP diversi nello stesso giorno</li>
 *     <li>Ordinare i dati per data</li>
 * </ul>
 *
 * @version 1.0
 */
public class Controlli {

    /**
     * Costruttore della classe Controlli.
     */
    public Controlli() {
    }

    /**
     * Calcola e stampa il numero totale di tentativi di accesso falliti
     * (FAIL) per ogni utente presente nella lista.
     * <p>
     * Ogni utente viene analizzato una sola volta.
     *
     * @param lista lista di oggetti Dato contenente i log degli accessi
     */
    public void FallitiUtente(ArrayList<Dato> lista) {

        for (int i = 0; i < lista.size(); i++) {

            String nomeUtente = lista.get(i).nome;
            int numeroFail = 0;
            boolean stampato = false;

            for (int k = 0; k < i; k++) {
                if (lista.get(k).nome.equals(nomeUtente)) {
                    stampato = true;
                    break;
                }
            }

            if (!stampato) {

                for (int j = 0; j < lista.size(); j++) {
                    if (lista.get(j).nome.equals(nomeUtente) &&
                        lista.get(j).accesso.equalsIgnoreCase("FAIL")) {
                        numeroFail++;
                    }
                }

                System.out.println("Utente " + nomeUtente + " ha fatto " + numeroFail + " fail");
            }
        }
    }

    /**
     * Individua e stampa gli indirizzi IP sospetti.
     * <p>
     * Un IP è considerato sospetto quando effettua almeno
     * tre tentativi consecutivi di accesso falliti (FAIL).
     *
     * @param lista lista di oggetti Dato contenente i log degli accessi
     */
    public void IpSospetti(ArrayList<Dato> lista) {

        int contatore = 1;

        for (int i = 1; i < lista.size(); i++) {

            String attuale = lista.get(i).ip;
            String precedente = lista.get(i - 1).ip;

            boolean failAttuale = lista.get(i).accesso.equals("FAIL");
            boolean failPrecedente = lista.get(i - 1).accesso.equals("FAIL");

            if (attuale.equals(precedente) && failAttuale && failPrecedente) {

                contatore++;

                if (contatore == 3) {
                    System.out.println("IP sospetto: " + attuale);
                }

            } else {
                contatore = 1;
            }
        }
    }

    /**
     * Verifica se nello stesso giorno sono stati effettuati accessi
     * da più indirizzi IP differenti.
     *
     * @param lista lista di oggetti Dato contenente i log degli accessi
     */
    public void DiversiStessoGiorno(ArrayList<Dato> lista) {

        for (int i = 0; i < lista.size(); i++) {

            LocalDate giorno = lista.get(i).data.toLocalDate();
            boolean giornoGiaStampato = false;

            for (int k = 0; k < i; k++) {
                if (lista.get(k).data.toLocalDate().equals(giorno)) {
                    giornoGiaStampato = true;
                    break;
                }
            }

            if (!giornoGiaStampato) {

                ArrayList<String> ipDiversi = new ArrayList<>();

                for (int j = 0; j < lista.size(); j++) {

                    if (lista.get(j).data.toLocalDate().equals(giorno)) {

                        String ip = lista.get(j).ip;

                        if (!ipDiversi.contains(ip)) {
                            ipDiversi.add(ip);
                        }
                    }
                }

                if (ipDiversi.size() > 1) {
                    System.out.println("Stesso giorno: " + giorno);
                    System.out.println("IP diversi: " + ipDiversi);
                }
            }
        }
    }

    /**
     * Ordina la lista di oggetti Dato in ordine cronologico crescente.
     *
     * @param lista lista di oggetti Dato da ordinare
     */
    public void OrdinaPerData(ArrayList<Dato> lista) {

        for (int i = 0; i < lista.size(); i++) {

            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(i).data.isAfter(lista.get(j).data)) {

                    Dato temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
    }
}