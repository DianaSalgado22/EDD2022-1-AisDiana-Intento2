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

    // COLORES                                                               
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String blue = "\033[34m";
    String yellow= "\033[33m";
    String red =  "\u001B[31m";  
    String black = "\033[30m";
 
    // Nombre del jugador
    String name="";
    // Mazo del jugador
    DoubleLinkedList<Carta> cartsOfThePlayer= new DoubleLinkedList<>();
    //atributo que se le asignara al final de la partida pero por default se inicializa en false
    // true si es loser osea perdedor jeje y falso si no es loser osea ganador jeje
    boolean Loser;

    boolean sigueJugando;

    String historial="";

    DoubleLinkedList<Carta> cartsOfThePlayerInTheBeginning= new DoubleLinkedList<>();

    DoubleLinkedList<DoubleLinkedList<Carta>> historialDeCartas = new DoubleLinkedList<>();

   // int 


    /** Metodo para crear a un jugador
     *  @param name nombre del jugador 
     */
    public Player(String name){
        this.name=name;
        sigueJugando=true;
    }
    
    
        /**
         * Metodo que revisa si hay un par de cartas
         * (este metodo es para cuando se roba una carta y dado que ya se tuvo que haber ocupado el metodo anterior entonces maximo se encuentra un par de cartas)
         * @return true si se descarta el par, false si no
         */
        public boolean descartarPar(){
            // la carta que robo siempre estara en la posición 0 de la lista xq tramposas jiji nosotras siempre la pondremos en 
            Carta cartaQueRobo = cartsOfThePlayer.get(0);
            //se recorren las cartas
            for(int i=1;i<cartsOfThePlayer.size();i++){
                //si la carta que robo es igual a otra de las cartas entonces se elima la primera q es la q se robo y la de posicion i que fue la q encontro
                // y sera unica pues antes ya se eliminaron todos los pares
                if(cartaQueRobo.valor == cartsOfThePlayer.get(i).valor){
                    cartsOfThePlayer.remove(i);
                    cartsOfThePlayer.remove(0);
                    return true;       
                }
            }
            return false;
        }

    public String toString(){
        return name+": " + cartsOfThePlayer +green+ "   Cantidad de cartas: "+blue+cartsOfThePlayer.size()+white+"\n";
    }

} 