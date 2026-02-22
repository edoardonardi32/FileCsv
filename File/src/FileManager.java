
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
 *
 * @author nardi.edoardo
 */
public class FileManager {
    String nomeFile = "LogAccessi.csv";
    ArrayList<Dato> lista = new ArrayList<>();
    Dato d;
    public ArrayList<Dato> Leggi(){
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String riga;
            reader.readLine();
            while ((riga = reader.readLine()) != null) {
                String[] dati = riga.split(",");
                for(int i = 0; i < dati.length; i++){
                    DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime giorno = LocalDateTime.parse(dati[0], formatter);
                    d = new Dato(giorno,dati[1],dati[2],dati[3]);
                    }
                lista.add(d);
                }
            }
            catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
        return lista;
    }
}
