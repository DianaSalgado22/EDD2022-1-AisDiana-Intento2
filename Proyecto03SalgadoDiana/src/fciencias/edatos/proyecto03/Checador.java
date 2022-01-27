package fciencias.edatos.proyecto03;

import java.io.Serializable;

/**
 * Clase que sirve para realizar un juego 
 * contador de palabras y que tiene los metodos para checar su validez 
 * y puntuación - proyecto 03
 * @version 1.Enero 2022.
 * @author Celic Aislinn Liahut Ley
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */
public class Checador  {
    Buscador c1= new Buscador();
    BinarySearchTree<String,String> contenedor[];
    static final long serialVersionUID = 1L;
    public Checador(){
        //Creamos al contenedor donde se buscara
        this.contenedor=c1.creaContenedor(); 
    }

    /** Metodo que cuenta cuantas veces aparece un 
     *  caracter en una secuencia (con solo letras sin acentos ) .
     *  @param c char que se quiere contar.
     *  @param s la cadena donde se busca
     *  @return la cantidad de veces.
     */
    private int howManySec(char c,String s){
        int contador=0;
        // Para considerar los casos de los acentos
        // convertimos los acentos en letra normal pq en la secuencia no hay acentos
        switch(c){
            case 'á':
                c='a';
                break;
            case 'é':
                c='e';
                break;
            case 'í':
                c='i';
                break;
            case 'ó':
                c='o';
                break;
            case 'ú':
                c='u';
                break;
        }
        //Ahora sí recorremos la palabra y hacemos cooperaciones
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                contador++;
          }
        }
        return contador;
    }

    /** Metodo que cuenta cuantas veces aparece un 
     *  caracter en una palabra.
     *  @param c char que se quiere contar.
     *  @param s la cadena donde se busca
     *  @return la cantidad de veces.
     */
    private int howManyPa(char c,String s){
        int contador=0;
        //Aqui no necesitamos hacer la conversión porque en la palabra sí hay acentos
        for(int i=0;i<s.length();i++){
            char actual=s.charAt(i);
            switch (actual) {
                case 'á':
                case 'a':
                    if('á'==c||'a'==c)
                        contador++;
                    break;
                case 'é':
                case 'e':
                    if('é'==c||'e'==c)
                        contador++;
                    break;
                case 'í':
                case 'i':
                    if('í'==c||'i'==c)
                        contador++;
                    break;
                case 'ó':
                case 'o':
                    if('ó'==c||'o'==c)
                        contador++;
                    break;
                case 'ú':
                case 'u':
                    if('ú'==c||'u'==c)
                        contador++;
                    break;
                default:
                    if(actual==c){
                        contador++;
                    }
                    break;
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
            int cantSec= howManySec(ci,secuencia);
            // cantidad de veces que aparece el caracter i en palabra
            int cantPa= howManyPa(ci,palabra);
            // si la cantidad de veces que aparece i en ambas palabras es igual
            if(cantSec==cantPa || cantPa<cantSec){
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
        // CHECAR SI LA PALABRA SE ESCUENTRA EN EL DICCIONARIO (CONTENEDOR)
        return c1.buscaEnContenedor(palabra,this.contenedor);
        
    }

    /**
     * Metodo que calcula el puntaje de una palabra
     * @param palabra a la que se le quiere calcular el puntaje
     * @return La longitud de la palabra al cuadrado
     */
    public int calcularPuntajeInd(String palabra){
        int longitud=palabra.length();
        return (longitud*longitud);
    }
    
    /**
     * Metodo que calcula una el puntaje de un jugador
     * @param lista donde solo hay palabras VALIDAS
     * @return la suma total de todos los puntajes de las palabras en la lista
     */
    public int calcularPuntajeTotal(DoubleLinkedList<String> lista){
        int total=0;
        while(!lista.isEmpty()){
            // Calculamos el puntaja de la palabra en la posición 0
            total+= calcularPuntajeInd(lista.get(0));
            // Eliminamos esa palabra de la lista
            lista.remove(0);
        }
        return total;
    }


    public static void main(String[] args) {
        Checador p1=new Checador();
        SecuenciaLetras sc1=new SecuenciaLetras();
        //String x=sc1.generateRandom9();
        //System.out.println(x);
        //System.out.println(p1.wordIsValid("FOHEIGENY","genio"));
        //System.out.println(p1.wordIsValid("FOHEIGENY","diana"));
        //System.out.println(p1.wordIsValid("FOHEIGENY","gen"));
        System.out.println(p1.howManySec('s', "OFIARASEJ".toLowerCase()));
        System.out.println(p1.howManyPa('s', "fresas"));
    }
}
