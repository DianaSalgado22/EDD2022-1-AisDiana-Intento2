package fciencias.edatos.proyecto03;
import java.io.Serializable;
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
    

