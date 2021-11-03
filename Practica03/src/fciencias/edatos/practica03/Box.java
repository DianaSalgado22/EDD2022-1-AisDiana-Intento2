package fciencias.edatos.practica03;
import java.util.Random;
import java.util.Iterator;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Box{

    // Atributo que te dice si la casilla representa una pared 
    boolean wall;
    // Atributo que te dice si la casilla ya fue visitada
    boolean visited;
    /** Crea la cola que representa el orden 
    en que se recorrera al siguiente vecino si es posible.
    */

    public Queue<Integer> neighbors=new Queue<>();

    int fila;
    int columna;
    

    /** Crea una nueva casilla
     *  @param wall te dice si la casilla es una pared.
     *  @param visited te dice si la casilla ya fue visitada.
     *  @param fila la fila donde se encuentra la casilla
     *  @param columna la columna de la casilla
     *  @param neighbors Cola por rellenar.
    */
    public Box(boolean wall,boolean visited,int fila,int columna ){
        this.fila = fila;
        this.columna = columna;
        this.wall=wall;
        this.visited=visited;
        this.neighbors=rellenaNeighbors(neighbors);
    
    }

    public Box(boolean wall){
        this.wall=wall;
        
    
    }

    public Queue getNeighbors(){
        return neighbors;
    }


    /** Crea una los elementos de la cola neighbors
     *  @param cola , cola a la que se le asignaran 
     *  los números del 1 al 4
     *  @return la cola ya  rellena y con tamaño 4.
     */
    public Queue rellenaNeighbors(Queue cola){
        int random;
        String numeros="";
        while(cola.size()<4){
            Random x = new Random();
			random = x.nextInt(4);

         

                if(numeros.contains(""+random)){
                    continue;
                }
                numeros += ""+random+"";

               // if(!(cola.contains(random))){
                    cola.enqueue(random);  
                


            }
             
            return cola;
        }
   // }

    /** Permite saber si una casilla 
     *  es pared o no.
     *  @return true si es pared, false si no
     */ 
    public boolean isWall(){
        if(wall==true)
            return true;
        return false;
    }
    /** Permite saber si una casilla esta visitada o no.
     *  @return true si esta visitada, false si no.
     */
    public boolean isVisited(){
        if(visited==true)
            return true;
        return false;
    }
    /** Visita la casilla  */
    public void visit(){
        this.visited=true;
    }
}