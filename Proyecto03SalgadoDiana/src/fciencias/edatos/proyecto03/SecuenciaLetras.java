package fciencias.edatos.proyecto03;
import java.util.Random;
/**
 * Clase que sirve para realizar las operaciones 
 * sobre la secuencia de letras necesaria para
 * el juego del proyecto 03
 * @version 1.Enero 2022.
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */
public class SecuenciaLetras{

  /*
  // COLORES                                                               
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String blue = "\033[34m";
  String yellow= "\033[33m";
  String red =  "\u001B[31m";  
  String black = "\033[30m";
  */

  // Cadena con las letras consideradas comunes
  String comunes="BCDFGHJLMNPRSTV";
  // Cadena con las vocales
  String vocales="AEIOU";
  // Cadena con las letras consideradas poco comunes
  String raras="KÑQWXYZ";
  // Cadena con todo el abecedario
  String abc=comunes+vocales+raras;


  /** Metodo que genera una secuencia
   *  de letras aleatoria.
   *  Considerando las probabilidades de:
   *  50% Vocales, 45% letras comunes, 5% letras raras.
   */
  public String generateRandom9(){
    Random random=new Random();//objeto para usar la clase random
    String secuenciaFinal=""; //Donde se guardara la secuencia
    do{
      //Para controlar las probabilidades de las letras :
      int prob=random.nextInt(101);// Generamos un int entre [0,101)
      // 50% que sean vocales
      if(prob<=50){
        //Generamos otro num random para elegir una letra 
        int posLetra=random.nextInt(vocales.length()); // [0,5)
        //Accedemos a la letra y la guardamos
          secuenciaFinal+=vocales.charAt(posLetra);
      }
      // 45% de que sean letras comunes
      if(prob>51 && prob<=95){
        //Generamos otro num random para elegir una letra 
        int posLetra=random.nextInt(comunes.length()); // [0,15)
        //Accedemos a la letra y la guardamos
          secuenciaFinal+=comunes.charAt(posLetra);
      }
      // 5% de que sean letras raras
      if(prob>95){ 
         //Generamos otro num random para elegir una letra 
        int posLetra=random.nextInt(raras.length()); // [0,7)
        //Accedemos a la letra y la guardamos
          secuenciaFinal+=raras.charAt(posLetra);
      }
    }while(secuenciaFinal.length()!=9); 
    
    return secuenciaFinal;
  }
  
  /** Metodo que checa que una secuencia sea valida
   * @param secuencia que se checara 
   * @return una secuencia de letras sin signos de puntuación
   * o regresa null si la secuencia no completa 9 caracteres validos o tiene más de 9 caracteres.
   */
  public String isValid(String secuencia){
    // Declaramos la string que se regresara
    String secuenciaFinal="";
    // Convertimos la secuencia a mayuscula para evitar errores
    secuencia=secuencia.toUpperCase();
    // Recorremos la cadena buscando caracteres no validos 
    for(int i=0;i<secuencia.length();i++){
      if(secuenciaFinal.length()>9){
        return null;
      }
      // Obtenemos al caracter en la posicion i
      char x=secuencia.charAt(i);
      // si es una letra del alfabeto
      if(contains(x,abc)){
        // Lo agregamos a la secuencia secuenciaFinal
        secuenciaFinal+=x;
      }
    }
    // Por ultimo checamos si la secuencia sin signos ni caracteres invalidos tiene la longitud suficiente
    if(secuenciaFinal.length()<9){
      return null;
    }
    return secuenciaFinal;
  }

  /** Metodo que te dice si una cadena contiene a un caracter
   *  @param c el caracter a buscar
   *  @param s la cadena donde se buscara
   *  @return true si la contien false si no
   */
  private Boolean contains(char c,String s){
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)==c){
        return true;
      }
    }
    return false;
  }
  
   /** Metodo que imprime a una cadena más bonito y con espacios
   *  @param s cadena que se quiere imprimir
   */
  public void toString(String s){
    for(int i=0;i<s.length();i++){
      if(i==s.length()-1){
        System.out.print(s.charAt(i)+"\n");
        break;
      }
      System.out.print(s.charAt(i)+"-");
    }
    
  }
  public static void main(String[] args){
    SecuenciaLetras p1= new SecuenciaLetras();
    //System.out.println(p1.generateRandom9());
    p1.toString(p1.isValid("a-b-c-d-e-f-g-h-i-"));
    //System.out.println("1F 2S 3t 4y 5 r  :  "+p1.isValid("1F 2S 3t 4y 5 r"));
    //System.out.println("abcdefhir  :  "+p1.isValid("abcdefhir"));
  }

  }
