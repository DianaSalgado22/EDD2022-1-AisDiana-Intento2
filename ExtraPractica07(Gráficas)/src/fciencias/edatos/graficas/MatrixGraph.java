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
public class MatrixGraph implements TDAGraph{

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
    public void addEdge(int startVertex, int endVertex)throws IndexOutOfBoundsException{

      if(startVertex< 0 || startVertex >= numeroDeVertices || endVertex < 0 || endVertex>=numeroDeVertices){
        throw new IndexOutOfBoundsException("Alguno de los vertices no existe");
      }

      //checar si existen ambos vertices 
        if(startVertex < numeroDeVertices && endVertex < numeroDeVertices){
            matrix[startVertex][endVertex] = 1;
            //System.out.println("n");
        }
        

        //en caso de que no enviar error

        
    }

  // public Arista<V,E> removeEdge(V v1, V v2){
	public void  removeEdge(int startVertex, int endVertex){
      //matrix[startVertex][endVertex] = 0;
      if(startVertex< 0 || startVertex >= numeroDeVertices || endVertex < 0 || endVertex>=numeroDeVertices){
        throw new IndexOutOfBoundsException("Alguno de los vertices no existe");
      }
      if(startVertex < numeroDeVertices && endVertex < numeroDeVertices){
        matrix[startVertex][endVertex] = 0;
        //System.out.println("n");
    }
    }

    public void getListOfAdjacencies(int v)throws IndexOutOfBoundsException{


      if(v >= numeroDeVertices || v<0){
        throw new IndexOutOfBoundsException("El valor que que se ingreso no es valido");
      }

       for(int k=0;k<numeroDeVertices;k++){
         if(matrix[v][k] == 1){
         System.out.print(k+" ");
         }
       }
    }

    
    public void printGraph(){

      System.out.println();

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

    // Agregamos a s a q.
      // 2  Mientras q no esté vacía:
      // 3     Sacamos al siguiente vértice v de q.
      // 4     Si v no ha sido visitado:
      // 5         Marcamos a v como visitado.
      // 6         Procesamos a v.
      // 7         Metemos a los vecinos no visitados de v a q.
    public void BFSpath(int v){
      TDAQueue<Integer> cola = new Queue<>();
      boolean visitados[] = new boolean[numeroDeVertices];
      //visitados[v] = true;
      cola.enqueue(v);
       while(!cola.isEmpty()){
            v =  cola.dequeue();
            if(!visitados[v]){
                visitados[v] = true; 
                System.out.print(" "+v);
                
                for(int k=0;k<numeroDeVertices;k++){
                  if(matrix[v][k] == 1){
                    if(!visitados[k]){
                      cola.enqueue(k);
                    }
                 // System.out.print(k+" ");
                  }
                }
            }
       }
      
      

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

      MatrixGraph grafica= new MatrixGraph(eleccion);;

      System.out.println("Recuerda que como tu cantidad de vertices es"+ eleccion+ " entonces solo existe los vertices  del 0 al " + (eleccion-1) );

      do {
        System.out.println(azul + "\nElige algunas de las siguientes opciones:" + white);
      

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
         
          int eleccion2;
          switch (eleccion) {
            case 1:
            try{  
              System.out.println("Ingresa el vertice de partida de la arista (recuerda ingresar un int dado que los vertices van del 0 al "+(grafica.numeroDeVertices - 1));   
              eleccion = sc.nextInt();
              System.out.println("Ingresa el vertice de llegada de la arista (recuerda ingresar un int dado que los vertices van del 0 al "+(grafica.numeroDeVertices - 1));  
              eleccion2 = sc.nextInt();
              grafica.addEdge(eleccion, eleccion2);

            }catch (InputMismatchException ime) {
              System.out.println(red + "\tNo ingresaste un entero" + white);
              System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
              sc.nextLine();
           
            } catch (IndexOutOfBoundsException ioobe) {
              System.out.println(red+"Ingresa un numeros en el rango valido"+white);
            }  

            
            // grafica.addEdge(2,3);
                // grafica.addEdge(2,1);
                // grafica.addEdge(2,3);
                // grafica.addEdge(2,1);
                // grafica.addEdge(0, 3);

                // grafica.addEdge(1, 2);
                
                // grafica.addEdge(2, 4);
                
                // grafica.addEdge(2, 5);
    
                // grafica.addEdge(5, 7);
                
                // grafica.addEdge(7, 5);
              //  grafica.printGraph();

                break;
            case 2:
              
                try{  
                  System.out.println("Ingresa el vertice de partida de la arista que quieres eliminar (recuerda ingresar un int dado que los vertices van del 0 al "+(grafica.numeroDeVertices - 1));   
                  eleccion = sc.nextInt();
                  System.out.println("Ingresa el vertice de llegada de la arista que quieres eliminar(recuerda ingresar un int dado que los vertices van del 0 al "+(grafica.numeroDeVertices - 1));  
                  eleccion2 = sc.nextInt();
                  grafica.removeEdge(eleccion, eleccion2);
    
                }catch (InputMismatchException ime) {
                  System.out.println(red + "\tNo ingresaste un entero" + white);
                  System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
                  sc.nextLine();
               
                } catch (IndexOutOfBoundsException ioobe) {
                  System.out.println(red+"Ingresa un numeros en el rango valido"+white);
                }  
                break;
            case 3:
            try{
              System.out.println("Ingresa el numero del vertice del que deseas conocer su lista de adyacencias, recuerda que solo puedes poner valores del 0 al "+(grafica.numeroDeVertices - 1));
              eleccion = sc.nextInt();
              System.out.print("La lista de adyacencias es: [");
              grafica.getListOfAdjacencies(eleccion); 
              System.out.print("]");
            }catch (InputMismatchException ime) {
              System.out.println(red + "\tNo ingresaste un entero" + white);
              System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
              sc.nextLine();
           
            } catch (IndexOutOfBoundsException ioobe) {
              System.out.println(red+"Ingresa un numeros en el rango valido"+white);
            }  
            break;
             
            case 4:
                grafica.printGraph();
              break;
            case 5:
              grafica.BFSpath(0);
            

          }
        }while(eleccion != 6);

	
}



}