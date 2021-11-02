package fciencias.edatos.practica03;

import java.util.Iterator;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Maze{

    /** Un arreglo de casillas 
     *  que es la representación del 
     *  tablero del laberinto */
    Box[][] tablero;  

    /** Representa la casilla de inicio del
     *  recorrido del laberinto.
     *  Esta casilla no puede ser una pared*/
    Box inicio;

    /** Representa la casilla de fin del
     *  recorrido del laberinto.*/
    Box fin;

    /** Representa la casilla actual del
     *  recorrido del laberinto.
     *  Esta casilla no puede ser una pared*/
    Box actual;

    public Maze(Box[][] tablero,Box inicio,Box fin, Box actual){
        this.tablero = tablero;
        this.inicio = inicio;
        this.fin = fin;
        this.actual = actual;
    }

    public Maze(Box[][] tablero){

        this.tablero = tablero;

    }
     

    /** Metodo para saber si el laberinto esta resuelto
     *  @return true si ya esta resuleto,false si no.
     */
   /*  public boolean isSolution(){
        // Si son iguales significa que encontramos un camino
        if(actual==fin)
           return isExtensible();
        // De otra manera aún no se encuentra una solución
        return false;
    }  */

    public String toString(){
        String representación = "";
        for(int i = 0; i < tablero.length; i++){
            representación += "|";
            for(int j = 0; j < tablero[i].length; j++){
            //    if(tablero[i][j] == null){
            //        rep += 
            //    } 
              representación += tablero[i][j] == null ? "@@@" : "   ";
            }
            representación += "|\n";
        }
        return representación;
    }

    public static void main(String[] args) {

        Box[][] p1 = ArrayReader.readMatrix("Laberintos/LaberintoA.txt");

		Maze laberinto = new Maze(p1);

        //System.out.println("holiu");
        System.out.println(laberinto);       


       // ArrayReader p1 = new ArrayReader();
		
	}


}