package fciencias.edatos.proyecto03;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que sirve para realizar un juego 
 * contador de palabras y que tiene los metodos para checar su validez 
 * y puntuación - proyecto 03
 * @version 1.Enero 2022.
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */

public class Buscador {

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

    /* NOTA: lo proximo por hacer es hacer un metodo que 
    te diga a que numero corresponde una letra ,
    por ejemplo si tengo la c que la busque en el alfabeto y regrese el int
    */
    /** Metodo que regresa el número al que corresponde una letra
     *  @param c el char que se quiere buscar
     *  @return el numero que corresponde a la letra o -1 si no se encuentra.
     */
    public static int getNum(char c){
        for(int contador=0;contador<abc.length();contador++){
            // si es igual se regresa al contador
            if(abc.charAt(contador)==c){
                return contador;
            }
        }
        return -1;
    }   
    
    
  /** Metodo que crea un arreglo de longitud 31 (la cantidad de letras) 
   *  y crea un arbol en cada posicion donde se guardaran todas las palabras 
   *  cada posicion del arreglo corresponde a una letra
   *  para buscar alfabeticamente la palabra.
   */
  public static void convierteArbol(){
    String cadena = "";
	int contador;
	String resultado = "";

	try{
	    Reader reader1 = new FileReader("diccionario.txt");
	    BufferedReader lector1 = new BufferedReader(reader1);
	    String linea1 = null;
        do{
            linea1 = lector1.readLine();
            System.out.println(linea1);
        }
	    while(linea1.charAt(0)=='a'||linea1.charAt(0)=='á');
	}catch(FileNotFoundException fnfe){
	    System.out.println(rojo+"\tNo se encontró el archivo");
	} catch(Exception e){
	    System.out.println(rojo+"\tOcurrió un error en la lectura");
	}
	
    }


  public static void main(String[] args){
    Buscador p1= new Buscador();
    convierteArbol();
  
  }
}

