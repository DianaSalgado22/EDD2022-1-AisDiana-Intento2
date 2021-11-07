package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 * Clase que simula a un jugador del juego Solterona
 */
public class Player{
    // Turno del jugador 
    int playerTurn;
    // Nombre del jugador
    String name="";
    // Mazo del jugador
    Mazo mazoPlayer= new Mazo();

    /** Metodo para crear a un jugador
     *  @param name nombre del jugador
     *  @param playerTurn turno del jugador
     *  @param mazoPlayer mazo del jugador 
     */
    public Player(String name,int playerTurn,Mazo mazoPlayer){
        this.name=name;
        this.playerTurn=playerTurn;
        this.mazo=mazoPlayer;
    }

}