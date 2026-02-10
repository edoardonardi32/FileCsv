
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nardi.edoardo
 */
public class Dato {
    String ip;
    String accesso;
    LocalDate data;
    String nome;

    Dato(String ip,String accesso,LocalDate data,String nome) {
        this.ip=ip;
        this.accesso=accesso;
        this.data=data;
        this.nome=nome;
    }
}
