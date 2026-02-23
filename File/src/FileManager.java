
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La classe FileManager gestisce la lettura del file CSV contenente
 * il log degli accessi e crea una lista di oggetti Dato.
 * <p>
 * Il file viene letto riga per riga e ogni riga viene convertita
 * in un oggetto Dato che viene aggiunto alla lista.
 *
 * @author nardi.edoardo
 * @version 1.0
 */
public class FileManager {

    /**
     * Nome del file CSV contenente i dati degli accessi.
     */
    String nomeFile = "LogAccessi.csv";

    /**
     * Lista che contiene tutti gli oggetti Dato letti dal file.
     */
    ArrayList<Dato> lista = new ArrayList<>();

    /**
     * Oggetto temporaneo utilizzato per salvare i dati letti da una riga del file.
     */
    Dato d;

    /**
     * Legge il file CSV assegnato alla variabile nomeFile
     * e restituisce una lista di oggetti Dato.
     * <p>
     * La prima riga del file viene ignorata (intestazione).
     * Ogni riga successiva viene suddivisa tramite il separatore ",".
     * La data viene convertita in un oggetto LocalDateTime
     * utilizzando il formato "yyyy-MM-dd HH:mm".
     *
     * @return lista di oggetti Dato contenente tutti i dati presenti nel file CSV
     */
    public ArrayList<Dato> Leggi() {

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {

            String riga;
            reader.readLine();

            while ((riga = reader.readLine()) != null) {

                String[] dati = riga.split(",");

                for (int i = 0; i < dati.length; i++) {

                    DateTimeFormatter formatter =
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    LocalDateTime giorno =
                            LocalDateTime.parse(dati[0], formatter);

                    d = new Dato(giorno, dati[1], dati[2], dati[3]);
                }

                lista.add(d);
            }

        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }

        return lista;
    }
}