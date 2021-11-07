package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 * Clase que simula la partida del juego Solterona
 */
public class Partida{

    // Cantidad de jugadores 
    int cantPlayers;
    // Cola con los jugadores
    TDAQueue<Players> colaPlayers= new Queue<>(); 
    // Solterona elegida
    Carta solterona;

    /** Método para construir una partida
     * 
     */
    // este aún no sé muy bien si se ocupa

     /** Metodo para crear a los jugadores de la partida
      *  @param cantPlayers la cantidad de jugadores que tendra la partida
      *  @return arrPlayers un arreglo con los jugadores. 
      */
    
    /** Metodo para preparar todo antes de una partida
     *  @param colaPlayers la lista con los jugadores de la partida.
     */
    public void preGame(TDAQueue<Players> colaPlayers){
        // Se crea el mazo y se barajea
        Mazo mazo=new Mazo(); 
        mazo=mazo.mazoCompleto().mazoCompletoBarajeado(); 
        // Elegimos a la Solterona 
        this.solterona=mazo.remove(0);    
        // Repartimos el resto
        while(!mazo.isEmpty()){ //Mientras que el mazo no este vacio
            // Obtenemos el mazo del jugador en la primera posicion de la cola    
            Mazo mazoAux=colaPlayers.first().getMazoPlayer(); 
            /* Cambiamos el mazo del jugador:
             * le agregamos al mazo del jugador la primera carta del mazo total
             * y la eliminamos del mazo total.*/
            mazoAux.setMazoPlayer(mazoAux.add(mazo.remove(0)));
            // Agrega al jugador actual al final de la cola y lo elimina del principio.
            colaPlayers.enqueue(colaPlayers.dequeue());    
        } 
        // Al terminar el while el mazo ya esta repartido entre los jugadores.
    }
}