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
  //  int playerTurn;
    // Nombre del jugador
    String name="";
    // Mazo del jugador
    //Mazo mazoPlayer= new Mazo();
    TDAList<Carta> cartsOfThePlayer= new DoubleLinkedList<>();
    //atributo que se le asignara al final de la partida pero por default se inicializa en false
    // true si es loser osea perdedor jeje y falso si no es loser osea ganador jeje
    boolean Loser;


    /** Metodo para crear a un jugador
     *  @param name nombre del jugador
     *  @param playerTurn turno del jugador
     *  @param mazoPlayer mazo del jugador 
     */
    public Player(String name){
        this.name=name;
       // this.playerTurn=playerTurn;
      //  this.cartsOfThePlayer=cartsPlayer;

    }

    /**
     * Método que simula cuando el jugador descarta las cartas pares si tiene
     * de su mazo de cartas
     */
    //sientp que hay algo raro en q aveces no eleimina los pares de los 13 cartas de valor 13 ,creo
    public void descartaPares(){
        //areglo que guarda en una arreglo las repeticiones de las cartas que tienen los mismos valores
        int[] numeroDeRepeticiones=new int[13];
        //auxiliar que nos ayudara a saber si eliminar todas o hasta que quede una, pues esto dependera si el numero de veces que se repite es par o impar
        int aux=0;
        
        for(int i =0;i<cartsOfThePlayer.size();i++){
            numeroDeRepeticiones[cartsOfThePlayer.get(i).valor-1]++;
        }
     //   System.out.println(numeroDeRepeticiones[0]);
        System.out.println(Arrays.toString(numeroDeRepeticiones));
        for(int i=0;i<numeroDeRepeticiones.length;i++){
            if(numeroDeRepeticiones[i]> 1){
                if(numeroDeRepeticiones[i] % 2 ==0){
                    aux =0;
                }else{
                    aux=1;
                }
                for(int k =0;k<cartsOfThePlayer.size();k++){
                    if(numeroDeRepeticiones[i]==aux){
                        break;
                    }
                    if(cartsOfThePlayer.get(k).valor==i+1){
                       // System.out.println("holi,probando");
                        cartsOfThePlayer.remove(k);

                        numeroDeRepeticiones[i]--;
                    }                
                }
                // while(numeroDeRepeticiones[i]!= 1){

                // }
            }
        }

       

        System.out.println(Arrays.toString(numeroDeRepeticiones));
       // System.out.println(cartsOfThePlayer);
    }
    

    /**
         * Metodo que revisa sihay un par de cartas
         * (este metodo es par cuando se roba una carta y dado que ya se tuvo que haber ocupado el metodo anterior entonces maximo se encuentra un par de cartas)
         */
        public void descartarPar(){
            // la carta que robo siempre estara en la posición 0 de la lista xq tramposas jiji nosotras siempre la pondremos en 
            Carta cartaQueRobo = cartsOfThePlayer.get(0);
            for(int i=1;i<cartsOfThePlayer.size();i++){
                if(cartaQueRobo.valor == cartsOfThePlayer.get(i).valor){
                    System.out.println("holi probando");
                    cartsOfThePlayer.remove(i);
                    cartsOfThePlayer.remove(0);
                    
                }
            }
        }
    public String toString(){
        return name + cartsOfThePlayer;
    }

} 