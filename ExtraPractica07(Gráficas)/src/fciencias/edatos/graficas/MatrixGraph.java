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

            // COLORES
            String green = "\033[32m";
            String white = "\u001B[0m";
            String purple = "\033[35m";
            String azul = "\033[34m";
            String yellow = "\033[33m";
            String red = "\u001B[31m";

   // public int maximoDeVertices; 

    public int numeroDeVertices;
    int matrix[][];

    MatrixGraph(int numeroDeVertices){
        this.numeroDeVertices = numeroDeVertices;
        matrix= new int[numeroDeVertices][numeroDeVertices];
    }

    //public void addEdge(V startVertex, V endVertex){
    public void addEdge(int startVertex, int endVertex){

        //checar si existen ambos vertices 
        if(startVertex < numeroDeVertices && endVertex < numeroDeVertices){
            matrix[startVertex][endVertex] = 1;
            System.out.println("n");
        }


        //en caso de que no enviar error

        
    }

  // public Arista<V,E> removeEdge(V v1, V v2){
	public void  removeEdge(int startVertex, int endVertex){
      matrix[startVertex][endVertex] = 0;
    }

    public ArrayList<V> getListOfAdjacencies(V v){
        return null;
    }

    
    public void printGraph(){


       for(int k=0; k < this.numeroDeVertices;k++ ){

        if(k ==0){
        System.out.print("  "+azul+k +white + " ");
        continue;
        }
        System.out.print(azul+k +white + " ");
       }
       System.out.println();

        for(int i=0; i < this.numeroDeVertices;i++ ){

                System.out.print(azul+i +white + " ");
            for(int j = 0; j< this.numeroDeVertices; j++){
                //   if(i==0 ){
                //   System.out.print(azul+j+white+ "\n");
                //  } 
              
                System.out.print(matrix[i][j]+ " ");

            }
            System.out.println();
        } 

      //  System.out.println();       
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

    //MatrixGraph<Integer, Arista<Integer, String>> grafica=
   

    // INICIO DEL MENU
    System.out.println(yellow + "Bienvenido al Menu , a continuación podras crear una matriz dirigida🤓" + white + "\n");
    int eleccion = 0;
    //int aux = 0;
    System.out.println("Ingresa la cantidad de vértices para la gráfica:");
    try {
        eleccion = sc.nextInt();
       // MatrixGraph<Integer, Arista<Integer, String>> grafica=  new MatrixGraph<>(eleccion);

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

      MatrixGraph<Integer, Arista<Integer, String>> grafica= new MatrixGraph<>(eleccion);;
      System.out.println("Recuerda que como tu cantidad de vertices es"+ eleccion+ " entonces solo existe los vertices  del 0 al " + (eleccion-1) );

      do {
        System.out.println(azul + "Elige algunas de las siguientes opciones:" + white);
      

    System.out.println(
        green +
        "[1]" +
        white +
        "Agregar una arista\n" +
        green +
        "[2]" +
        white +
        "Eliminar una arista\n" +
        green +
        "[3]" +
        white +
        "Obtener la lista de adyacencias de un v ́ertice\n" +
        green +
        "[4]" +
        white +
        "Imprimir la matriz de adyacencia asociada a la grafica\n" +
        green +
        "[5]" +
        white +
        "ERecorrer los elementos de la gr ́afica gr ́afica con BFS.\n" +
        green +
        "[6]" +
        white +
        "Salir del menu\n");
        try {
            eleccion = sc.nextInt();
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
         
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
          
          }
         
          switch (eleccion) {
            case 1:
                grafica.addEdge(2,3);
              //  grafica.printGraph();
                break;
            case 4:
                grafica.printGraph();
            break;
            case 2:
                grafica.removeEdge(2, 3);
              break;

          }
        }while(eleccion != 6);

	
}



}