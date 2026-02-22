
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author nardi.edoardo
 */
public class File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        Controlli cr = new Controlli();
        ArrayList<Dato> lista = fm.Leggi();
        System.out.println("accessi ordinati per data");
        cr.OrdinaPerData(lista);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).data + " \n"+ lista.get(i).ip + " \n"+ lista.get(i).accesso + " \n"+ lista.get(i).nome);
        }
        System.out.println("fail per utente");
        cr.FallitiUtente(lista);
        System.out.println("ip");
        cr.IpSospetti(lista);
        System.out.println("ip diversi stesso giorno");
        cr.DiversiStessoGiorno(lista);
    }
}
    

