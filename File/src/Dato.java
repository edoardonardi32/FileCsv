
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nardi.edoardo
 */
public class Dato {
    LocalDateTime data;
    String nome;
    String ip;
    String accesso;
    

    Dato(LocalDateTime data,String nome,String ip,String accesso) {
        this.data=data;
        this.nome=nome;
        this.ip=ip;
        this.accesso=accesso;
    }
}
