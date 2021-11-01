package fciencias.edatos.practica03;
import java.util.Scanner;
import java.util.Iterator;

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

    /** Metodo para saber si el laberinto esta resuelto
     *  @return true si ya esta resuleto,false si no.
     */
    public boolean isSolution{
        // Si son iguales significa que encontramos un camino
        if(actual==fin)
           return isExtensible();
        // De otra manera aún no se encuentra una solución
        return false
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    
        // INICIO DEL MENU
        
        System.out.println(verde+"Antes de comenzar: \n"+azul+
          " Este es un programa que utiliza archivos,"
          +"\n asi que tenemos algunas recomendaciones para ti"+red" 🚩\n"
          +azul+"\n\t-- "+blanco+"Si los archivos que quieres leer 
          se encuentran en la misma carpeta que este programa, 
          \n\tsolo ingresa su nombre"+morado+ " (Recuerda incluir el .txt)\n"
          +azul+"\n\t-- "+blanco+"Si tu caso no es el anterior 
          tendras que incluir la ruta completa donde se encuentra 
          el archivo \n\t"+morado+"Por ejemplo: 
          /Documentos/ICC/carpetita/Archivo.txt\n\n");
          
        System.out.println(morado+"Bienvenido al buscador 
        de soluciones de laberintosツ\n");
        int eleccion= 0;
        do{
            System.out.println(azul+"Elige algunas de las siguientes opciones:");
    
            System.out.print(verde+ "[1]"+blanco+" Resolver laberinto 🌟 \n" +
                             verde + "[2]"+blanco+" Cerrar el programa 😞\n"+azul);
            try {
                eleccion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(red + "\tNo ingresaste un entero" + white);
                System.out.print(verde+"\n\tIntenta de nuevo:)");
                continue;
              }catch(Exception e){
                System.out.print(rojo+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(verde+"\n\tIntenta de nuevo:)");
                }
            sc.nextLine();
            System.out.println();
    
            switch(eleccion){
            // opcion 1 (resolver Laberinto)
            case 1:
            System.out.println(blanco+"Ingresa el nombre del archivo 
                                donde esta la representación del laberinto\n");
            try {
                String archivo=sc.nextLine();
            } catch(InputMismatchException ime){
                System.out.println(red + "\tNo ingresaste un archivo valido" + white);
                sc.nextLine();
                continue;
            } catch (Exception e){
                System.out.println(red+"Hubo un error "+white);
            }
            break; // del case 1 del menu principal
    
            // opcion 2 (salir)
            case 2:
            System.out.println(rojo+"\n\t🌈 Gracias por usar el programa 🌈\n");
            break;
            //
            default:
            System.out.println(rojo+"\nINGRESA UNA OPCION VALIDA\n");
            break;
    
            } // final switch principal 
           
            System.out.println();
            
        } //final do .. while principal
        while(eleccion!=2);
      }


}