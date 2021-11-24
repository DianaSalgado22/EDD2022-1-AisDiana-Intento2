package fciencias.edatos.practica05;
import java.util.Scanner;

/**
 * Clase Main donde se encuentra un menú 
 * para probar la clase BinarySearchTree
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

 public class Main{
    // COLORES                                                               
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String blue = "\033[34m";
    String yellow= "\033[33m";
    String red =  "\u001B[31m"; 
    // Inicio Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner

        // INICIO DEL MENU
        System.out.println(yellow+"Bienvenido al GenTree ツ"+white+"\n");
        int eleccion= 0;
        do{
            System.out.println(azul+"Elige algunas de las siguientes opciones:"+white);
    
            System.out.print(green+ "[1]"+white+"Empezar un nuevo árbol genealógico\n" +
                            green+ "[2]"+white+"Buscar a un familiar de acuerdo a su edad (key) \n" +
                             green + "[3]"+white+"Insertar a un nuevo familiar\n"+
                             green + "[4]"+white+"Eliminar a un familiar\n"+
                             green + "[5]"+white+"Encontrar al familiar con mayor edad\n"+
                             green + "[6]"+white+"Encontrar al familiar con menor edad\n"+
                             green + "[7]"+white+"Ordenar el árbol con preOrden\n"+
                             green + "[8]"+white+"Ordenar el árbol con inOrden\n"+
                             green + "[9]"+white+"Ordenar el árbol con postOrden\n"+
                             green + "[10]"+white+"Saber si árbol esta vacio\n"
                             );
            try {
                eleccion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(red+ "\tNo ingresaste un entero" + white);
                System.out.print(green+"\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
              }catch(Exception e){
                System.out.print(red+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(green+"\n\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
                }
            sc.nextLine();
            System.out.println();
    
            switch(eleccion){
            // opcion 1 (resolver Laberinto)
            case 1:
            
            break;

            //opcion 2 (Para no tener que escribir la ruta completa al probar ejemplos)
            case 2:
            
            break;
            
            // opcion 3 (salir)
            case 3:
            System.out.println(white+"\n 🌈 " + red+" Gracias por usar el programa "+ white+ "🌈\n"+white);
            break;
    
            } // final switch principal 
           
            System.out.println();
            
        } //final do .. while principal
        while(eleccion!=3);

    }
 }