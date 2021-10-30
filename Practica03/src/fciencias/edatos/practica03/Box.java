package fciencias.edatos.practica03;

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
    TDAQueue<integer> neighbors=new Queue<>();

    /** Crea una nueva casilla
     *  @param wall te dice si la casilla es una pared.
     *  @param visited te dice si la casilla ya fue visitada.
     *  @param neighbors Cola por rellenar.
    */
    public Box(boolean wall,boolean visited,Queue neighbors){
        this.wall=wall;
        this.visited=visited;
        this.neighbors=rellenaNeighbors(neighbors);
    }

    /** Crea una los elementos de la cola neighbors
     *  @param cola , cola a la que se le asignaran 
     *  los números del 1 al 4
     *  @return la cola ya  rellena y con tamaño 4.
     */
    public Queue rellenaNeighbors(Queue cola){
        while(cola.size()<4){
            int random=new Random();
            int x=random.nextInt(4);
                int random=new Random();
                x=random.nextInt(4);
            }
            cola.enqueue(x);   
        }
    }

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