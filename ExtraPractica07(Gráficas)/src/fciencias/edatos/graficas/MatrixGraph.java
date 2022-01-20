package fciencias.edatos.graficas;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Implementación de una gráfica 
* dirigida usando una matriz de adyacencias.
* @author Liahut Ley Celic Aislinn.
* @author Salgado Tirado Diana Laura.
* @version 19 Enero 2022.
* @since Estructuras de datos 2021-1.
*/
public class MatrixGraph<V, E> implements TDAGraph<V, E>{


    public int maximoDeVertices; 

    public int numeroDeVertices;
    int matrix[][];

    MatrixGraph(int maximoDeVértices){
        this.maximoDeVertices = maximoDeVértices;
        matrix= new int[maximoDeVértices][maximoDeVértices];
    }
    public void addEdge(V startVertex, V endVertex){

        //checar si existen ambos vertices 

        //en caso de que no enviar error

        //en caso de que si modificar matrix
    }

    
	public Arista<V,E> removeEdge(V v1, V v2){
        return null;
    }

    public ArrayList<V> getListOfAdjacencies(V v){
        return null;
    }

    
    public void printGraph(){
        for(int i=0; i < this.numeroDeVertices;i++ ){
            for(int j = 0; j< this.numeroDeVertices; j++){
                System.out.println(matrix[i][j]+ " ");
            }
            System.out.println("/n");
        }        
    }

    
    public void BFSpath(){

    }

    // public void asignarMaxDeV(int x){
    //     maximoDeVertices =
    // }
    public static void main(String[] args) {

        System.out.println("Hola mundo");

             // COLORES
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String azul = "\033[34m";
    String yellow = "\033[33m";
    String red = "\u001B[31m";
    Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner

   

    // INICIO DEL MENU
    System.out.println(yellow + "Bienvenido al Menu , a continuación podras crear una matriz dirigida🤓" + white + "\n");
    int eleccion = 0;
    int aux = 0;
    System.out.println("Ingresa la cantidad de vértices para la gráfica:");
    try {
        eleccion = sc.nextInt();
        MatrixGraph<String,String > grafica = new MatrixGraph<>(eleccion);

      } catch (InputMismatchException ime) {
        System.out.println(red + "\tNo ingresaste un entero" + white);
        System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
        sc.nextLine();
       // continue;
      } catch (Exception e) {
        System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
        System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
        sc.nextLine();
       // continue;
      }
	}
	
}