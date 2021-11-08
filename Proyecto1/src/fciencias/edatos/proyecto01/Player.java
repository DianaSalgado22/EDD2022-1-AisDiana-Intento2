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
    //Diana  hay algo raro, parece que esta bien pero si lo corres varias veces notaras q derepente no elimina todos los pares nose xq🥺😭 .
    public void descartaPares(){
        //areglo que guarda en una arreglo las repeticiones de las cartas que tienen los mismos valores
        int[] numeroDeRepeticiones=new int[13];
        //auxiliar que nos ayudara a saber si eliminar todas o hasta que quede una, pues esto dependera si el numero de veces que se repite es par o impar
        int aux=0;
        
        for(int i =0;i<cartsOfThePlayer.size();i++){
            numeroDeRepeticiones[cartsOfThePlayer.get(i).valor-1]++;
        }
     //   System.out.println(numeroDeRepeticiones[0]);
     //imprimirmos el array de las repeticiones de cada carta para checar 
        System.out.println(Arrays.toString(numeroDeRepeticiones));
        //ahora recorremos el array de repeticones porque por cada iteracion se va a checar si es mayor que una
        // la repeticion del valor y si si entonces procedera a eliminar ya se todas o hasta que reste una dependiendo si la repeticion es par o no
        for(int i=0;i<numeroDeRepeticiones.length;i++){
            //solo procedera a hacer algo si la  repeticion es 1, pues si no lo fuera pues no podemos eliminar ningun par
            if(numeroDeRepeticiones[i]> 1){
                //checamos si es par la repeticion y asinamos 0 si es par y 1 si no lo es
                if(numeroDeRepeticiones[i] % 2 ==0){
                    aux =0;
                }else{
                    aux=1;
                }
                //ahora recorremos las cartas del jugador para eliminar las cartas pares
                for(int k =0;k<cartsOfThePlayer.size();k++){
                    //ponemos este if para que si ya llego a que ya elimino cartas pares y ya no tiene por eliminar o solo resta una cortar el ciclo.
                    if(numeroDeRepeticiones[i]==aux){
                        break;
                    }

                    //si es valor de la carta es igual al indice i+1 que en particular ese valor es donde se guarda las repeticiones del valor q estamos checando entonces elimina la carta
                    if(cartsOfThePlayer.get(k).valor==i+1){
                       // System.out.println("holi,probando");
                       //se elimina la carta
                        cartsOfThePlayer.remove(k);
                        //se baja en menos 1 el valor de la repeticion de la carta
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
            //se recorren las cartas
            for(int i=1;i<cartsOfThePlayer.size();i++){
                //si la carta que robo es igual a otra de las cartas entonces se elima la primera q es la q se robo y la de posicion i que fue la q encontro
                // y sera unica pues antes ya se eliminaron todos los pares
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