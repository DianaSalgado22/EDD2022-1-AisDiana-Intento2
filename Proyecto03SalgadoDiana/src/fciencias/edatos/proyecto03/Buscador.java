package fciencias.edatos.proyecto03;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

/**
 * Clase que sirve para realizar un juego 
 * contador de palabras y que tiene los metodos para checar su validez 
 * y puntuación - proyecto 03
 * @version 1.Enero 2022.
 * @author Celic Aislinn Liahut Ley
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */

public class Buscador  {
    static final long serialVersionUID = 1L;
    static String verde = "\033[32m";
    static String blanco = "\u001B[0m";
    static String morado = "\033[35m";
    static String azul = "\033[34m";
    static String yellow= "\033[33m";
	static String rojo =  "\u001B[31m";

  // Cadena con las letras consideradas comunes
  static String comunes="bcdfghjlmnprstv";
  // Cadena con las vocales
  static String vocales="aeiou";
  // Cadena con las vocales con acentos
  static String acentuadas="áéíóú";
  // Cadena con las letras consideradas poco comunes
  static String raras="kñqwxyz";
  // Cadena con todo el abecedario
  static String abc=comunes+vocales+acentuadas+raras;
  
    /**
     * Metodo que convierte a un caracter en un valor
     * dentro del rango [0,28)
     * @param c el caracter que se quiere buscar
     * @return la posicion 
     */
    public int calculaPosArr(char c){
        //Primero obtenemos el valor ascii del caracter
        int codigoAscii=c;
        //Se consideran los acentos para asi evitar colisiones
        switch(codigoAscii){
            //Caso para á
            case 225:   
                codigoAscii=97; //El codigo de a
                break;
            //Caso para é
            case 233:
                codigoAscii=101; //El codigo de e
                break;
            //Caso para í
            case 237:
                codigoAscii=105; //El codigo de i
                break;
            //Caso para ó
            case 243:
                codigoAscii=111; //El codigo de o
            //Caso para ú
            case 250:
                codigoAscii=117; //El codigo de u
                break;

        }
        //Ahora sacamos el modulo 0 y esa ya seria la posición
        return codigoAscii%29;
    }
    

   /** Metodo que crea un arreglo de longitud 29(la cantidad de letras +2 para que sea primo) 
   *  y crea un arbol en cada posicion donde se guardaran todas las palabras 
   *  cada posicion del arreglo corresponde a una letra
   *  para buscar alfabeticamente la palabra.
   */
   public BinarySearchTree<String,String>[] creaContenedor(){
    //Hacemos un arreglo de arboles binarios de busqueda
    BinarySearchTree<String,String> contenedor[]= new BinarySearchTree[29]; 

	try{
	    Reader reader1 = new FileReader("diccionario.txt");
	    BufferedReader lector = new BufferedReader(reader1);
	    String palabra= lector.readLine();
        do{
            //Primero obtenemos a la primera letra de la palabra
            char inicial=palabra.charAt(0);
            // Calculamos a que posición del arreglo corresponde esta letra
            int pos=calculaPosArr(inicial);
            // Checamos si ya hay un arbol en esa posicion
            if(contenedor[pos]==null){
                //Creamos un arbol y lo guardamos en la pos
                contenedor[pos]=new BinarySearchTree();
            }
            //Accedemos al arbol en la posición que se obtuvo
            BinarySearchTree<String,String> arbol=contenedor[pos];
            //Agregamos la palabra al arbol
            arbol.insert(palabra,palabra);
            //System.out.println("La palabra: "+arbol.retrieve(palabra)+"esta en la pos "+pos);
        }
	    while((palabra=lector.readLine())!=null);
	}catch(FileNotFoundException fnfe){
	    System.out.println(rojo+"\tNo se encontró el archivo");
	} catch(Exception e){
	    System.out.println(rojo+"\tOcurrió un error en la lectura");
	}
	return contenedor;
    }

    /**
     * Metodo que busca una palabra ene el mapa de arboles
     * @param palabra  
     * @return true si se encuentra flase si no
     */
    public boolean buscaEnContenedor(String palabra,BinarySearchTree<String,String>[] contenedor){
        //Para evitar errores
        if(palabra==null || palabra.equals("")){
            return false;
        }
        //Obtenemos la primera letra de la palabra
        char inicial= palabra.charAt(0);
        //Vemos en que posición del arreglo podria estar la palabra 
        int pos=calculaPosArr(inicial);
        //Accedemos al arbol en la posición
        BinarySearchTree<String,String> arbol=contenedor[pos];
        //Buscamos a la palabra en el arbol
        return arbol.contains(palabra);
    }

  public static void main(String[] args){
    Buscador p1= new Buscador();
    BinarySearchTree<String,String>[]  con=p1.creaContenedor();
    
    System.out.println("¿genio? "+p1.buscaEnContenedor("genio", con));
    System.out.println("¿papiripapipa? "+p1.buscaEnContenedor("papiripapipa", con));
    
    
  }
}

