package fciencias.edatos.proyecto03;
import java.io.Serializable;
/**
 * Clase que representa al jugador(sus atributos) para
 * el juego del proyecto 03
 * @version 1.Enero 2022.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class Jugador implements Serializable {
    //Nombre 
    public String nombre;
    // Puntos 
    public int puntos;
    public Jugador(String nombre,int puntos){
        this.nombre=nombre;
        this.puntos=puntos;
    }
}
    

