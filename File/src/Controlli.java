
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
public class Controlli {
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
            }
            else {
                contatore = 1;
            }
        }
    }
    public void DiversiStessoGiorno(ArrayList<Dato> lista) {

    for (int i = 0; i < lista.size(); i++) {LocalDate giorno = lista.get(i).data.toLocalDate();
        boolean giornoGiaStampato = false;for (int k = 0; k < i; k++) {
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