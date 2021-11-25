package fciencias.edatos.practica05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main donde se encuentra un menú
 * para probar la clase BinarySearchTree
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Main {

  // COLORES
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String azul = "\033[34m";
  String yellow = "\033[33m";
  String red = "\u001B[31m";

  // Inicio Menu
  public static void main(String[] args) {
    // COLORES
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String azul = "\033[34m";
    String yellow = "\033[33m";
    String red = "\u001B[31m";
    Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner

    BinarySearchTree a1 = new BinarySearchTree();

    // INICIO DEL MENU
    System.out.println(yellow + "Bienvenido al GenTree ツ" + white + "\n");
    int eleccion = 0;
    int aux = 0;
    String aux2 = "";
    do {
      System.out.println(
        azul + "Elige algunas de las siguientes opciones:" + white
      );

      System.out.print(
        green +
        "[1]" +
        white +
        "Buscar a un familiar de acuerdo a su edad (key) \n" +
        green +
        "[2]" +
        white +
        "Insertar a un nuevo familiar\n" +
        green +
        "[3]" +
        white +
        "Eliminar a un familiar\n" +
        green +
        "[4]" +
        white +
        "Encontrar al familiar con mayor edad\n" +
        green +
        "[5]" +
        white +
        "Encontrar al familiar con menor edad\n" +
        green +
        "[6]" +
        white +
        "Ordenar el árbol con preOrden\n" +
        green +
        "[7]" +
        white +
        "Ordenar el árbol con inOrden\n" +
        green +
        "[8]" +
        white +
        "Ordenar el árbol con postOrden\n" +
        green +
        "[9]" +
        white +
        "Saber si árbol esta vacio\n" +
        green +
        "[10]" +
        white +
        "Salir del menu\n"
      );
      try {
        eleccion = sc.nextInt();
      } catch (InputMismatchException ime) {
        System.out.println(red + "\tNo ingresaste un entero" + white);
        System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
        sc.nextLine();
        continue;
      } catch (Exception e) {
        System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
        System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
        sc.nextLine();
        continue;
      }
      sc.nextLine();
      System.out.println();

      switch (eleccion) {
        case 1:
          try {
            System.out.println("ingresa la edad");
            aux = sc.nextInt();
            if (a1.retrieve(aux) == null) {
              System.out.println(
                red +
                "En el arbol genealogico no existe un familiar con tal edad 😩\n" +
                white
              );
              break;
            }
            System.out.println("Tu familiar es " + a1.retrieve(aux));
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          }
          break;
        case 2:
          try {
            System.out.println("ingresa la edad");
            aux = sc.nextInt();
            sc.nextLine();
            System.out.println("ingresa el nombre");
            aux2 = sc.nextLine();
            a1.insert(aux2, aux);
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          }

          break;
        // opcion 3 (salir)
        case 3:
          try {
            System.out.println(
              "ingresa la edad del familiar que quieres eliminar 🥺"
            );
            aux = sc.nextInt();
            sc.nextLine();
            a1.delete(aux);
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          }

          break;
        case 4:
          if (a1.findMax() == null) {
            System.out.println(
              red +
              "Este arbol genelealogico esta vacio, por lo que no se puede determinar quien es la persona con mas edad :( , F\n" +
              white
            );
            break;
          }
          System.out.println(
            "En el arbol genealogico , la persona con mas edad es \n" +
            a1.findMax()
          );
          break;
        case 5:
          if (a1.findMin() == null) {
            System.out.println(
              red +
              "Este arbol genelealogico esta vacio, por lo que no se puede determinar quien es la persona con menos edad edad :( , F\n" +
              white
            );
            break;
          }
          System.out.println(
            "En el arbol genealogico , la persona con menos edad es \n" +
            a1.findMin()
          );
          break;
        case 6:
          if (a1.root == null) {
            System.out.println("Este arbol esta vacio, F loser 🤪\n");
            break;
          }
          System.out.print("El arbol ordenado en preorden es: ");
          a1.preorden();
          System.out.println();
          // System.out.println(a1.root);
          break;
        case 7:
          if (a1.root == null) {
            System.out.println("Este arbol esta vacio, F loser 🤪\n");
            break;
          }
          System.out.print("El arbol ordenado en inOrden es: ");
          a1.inorden();
          System.out.println();
          //System.out.println(a1.root);
          break;
        case 8:
          if (a1.root == null) {
            System.out.println("Este arbol esta vacio, F loser 🤪\n");
            break;
          }
          System.out.print("El arbol ordenado en postOrden es: ");
          a1.postorden();
          System.out.println();

          //System.out.println(a1.root);
          break;
        case 9:
          if (a1.isEmpty() == true) {
            System.out.println("Este arbol esta vacio, F loser 🤪\n");
            break;
          } else {
            System.out.println("Este arbol no esta vacio 🙊");
          }

          //System.out.println(a1.root);
          break;
      } // final switch principal
      //  System.out.println();

      // System.out.print(white+"\n 🌈 " + red+" Gracias por usar el programa "+ white+ "🌈\n"+white);
    } while (eleccion != 10); //final do .. while principal
    System.out.print(
      white +
      "\n 🌈 " +
      red +
      " Gracias por usar el programa " +
      white +
      "🌈\n" +
      white
    );
  }
}
