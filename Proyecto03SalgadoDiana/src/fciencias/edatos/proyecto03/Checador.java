package fciencias.edatos.proyecto03;

/**
 * Clase que sirve para realizar un juego 
 * contador de palabras y que tiene los metodos para checar su validez 
 * y puntuación - proyecto 03
 * @version 1.Enero 2022.
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */
public class Checador{


    /** Metodo que recolecta las palabras
     * 
     */

    /** Metodo que cuenta cuantas veces aparece un }
     *  caracter en una cadena.
     *  @param c char que se quiere contar.
     *  @param s la cadena donde se busca
     *  @return la cantidad de veces.
     */
    private int howMany(char c,String s){
        int contador=0;
        for(int i=0;i<s.length();i++){
          if(s.charAt(i)==c){
            contador++;
          }
        }
        return contador;
    }

    /** Metodo que checa si una palabra es valida o no
     *  @param secuencia que se mostro al usuario para que hicera palabras
     *  @param palabra que se quiere verificar
     *  @return true si es cvalida , false en otro caso
     */
    public boolean wordIsValid(String secuencia,String palabra){
        // si la palabras tiene más de 9 caracteres entoces no es valida
        if(palabra.length()>9){
            return false;
        }
        // Primero convertimos a minuscula la palabra y la secuencia para no tener conflictos
        palabra=palabra.toLowerCase();
        secuencia=secuencia.toLowerCase();
        // Si la palbra tiene menos o 9 caracteres
        // tenemos que recorrerla 
        for(int i=0;i<palabra.length();i++){
            // Caracter que se esta buscando
            char ci=palabra.charAt(i);
            // cantidad de veces que aparece el caracter i en secuencia
            int cantSec= howMany(ci,secuencia);
            // cantidad de veces que aparece el caracter i en palabra
            int cantPa= howMany(ci,palabra);
            // si la cantidad de veces que aparece i en ambas palabras es igual
            if(cantSec==cantPa){
                // se pasa a la siguiente letra 
                continue;
            }
            /* si no , quiere decir que la letra 
             * en la posicion "i"de la palabra no aparece
             * o que aparece más veces que las validas(las que aparece en secuencia)
             * por lo tanto la palabra automaticamente no es valida.
             */
            return false;
        }
        /* si se sale del for sin terminar la ejecucion del metodo
         * es pq todos los caracteres de la palabra fueron validos
         * (aparecen en la secuencia y se repiten solo las veces validas)
         */
        // AQUI FALTA CHECAR SI LA PALABRA SE ESCUENTRA EN EL DICCIONARIO
        //si sí true , false de lo contrario
        return true;
    }
}
