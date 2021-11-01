package fciencias.edatos.practica03;
import java.util.Scanner;
import java.util.Iterator;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Maze{

    // COLORES                                                               
    String verde = "\033[32m";
    String blanco = "\u001B[0m";
    String morado = "\033[35m";
    String azul = "\033[34m";
    String yellow= "\033[33m";
    String rojo =  "\u001B[31m";   

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

    public static void main(String[] args){
        
        // COLORES                                                               
        String verde = "\033[32m";
        String blanco = "\u001B[0m";
        String morado = "\033[35m";
        String azul = "\033[34m";
        String yellow= "\033[33m";
        String rojo =  "\u001B[31m"; 

        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
        ArrayReader arre= new ArrayReader(); //Objeto para usar la clase ArrayReader
    
        //	Maze laberinto = new Maze();
        
        // INSTRUCCIONES PARA EL USUARIO
        System.out.println(verde+"Antes de comenzar:" +blanco+"\n"+azul+
          " Este es un programa que utiliza archivos,"
          +" asi que tenemos algunas recomendaciones para ti"+rojo+" 🚩" +blanco+"\n"+
          "\n"+azul+"\t-- "+blanco+"Si los archivos que quieres leer"+
          " se encuentran en la misma carpeta que este programa," + blanco+"\n"+
          "\tsolo ingresa su nombre"+morado+ " (Recuerda incluir el .txt)"+blanco+"\n\n"
          +azul+"\t-- "+blanco+"Si tu caso no es el anterior"+ 
          " tendras que incluir la ruta completa \n\tdonde se encuentra" +
          " el archivo "+morado+"Por ejemplo:" + 
          "/Documentos/ICC/carpetita/Archivo.txt"+blanco+"\n\n");
          
        // INICIO DEL MENU
        System.out.println(yellow+"Bienvenido al buscador de soluciones de laberintos ツ"+blanco+"\n");
        int eleccion= 0;
        do{
            System.out.println(azul+"Elige algunas de las siguientes opciones:"+blanco);
    
            System.out.print(verde+ "[1]"+blanco+" Resolver laberinto 🌟\n" +
                            verde+ "[2]"+blanco+" Probar ejemplos 🌟\n" +
                             verde + "[3]"+blanco+" Cerrar el programa 😞\n");
            try {
                eleccion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(rojo+ "\tNo ingresaste un entero" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                sc.nextLine();
                continue;
              }catch(Exception e){
                System.out.print(rojo+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(verde+"\n\tIntenta de nuevo:)"+blanco+"\n\n");
                sc.nextLine();
                continue;
                }
            sc.nextLine();
            System.out.println();
    
            switch(eleccion){
            // opcion 1 (resolver Laberinto)
            case 1:
            System.out.println(morado+"Ingresa el nombre del archivo donde esta la representación del laberinto"+blanco+"\n");
            String archivo=sc.nextLine();
            Box[][] tablero1= arre.readMatrix(archivo);
            System.out.println("\n"+morado+"El laberinto del archivo se ve de la siguiente manera:");
            //tablero1.toString();
            break; 

            //opcion 2 (Para no tener que escribir la ruta completa al probar ejemplos)
            case 2:
            System.out.println(morado+"Ingresa solo la letra del laberinto de ejemplo (A o B)"+blanco+"\n");
            String archivoInc=sc.nextLine(); // La letra que el usuario ingrese
            String archivoCom="Laberintos/Laberinto"+archivoInc+".txt"; //La ruta de acuerdo a como esta implementada la gráfica
            Box[][] tablero2= arre.readMatrix(archivoCom);
            System.out.println();
            break;
            
            // opcion 3 (salir)
            case 3:
            System.out.println(blanco+"\n 🌈 " + rojo+" Gracias por usar el programa "+ blanco+ "🌈\n"+blanco);
            break;
    
            } // final switch principal 
           
            System.out.println();
            
        } //final do .. while principal
        while(eleccion!=3);
      }


}