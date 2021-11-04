package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Mazo{
    // Un mazo es una lista de cartas
    // Un mazo tiene 52 cartas

    //INTENTO DE OPTIMIZACIÓN FALLIDO
    /** Metodo para construir un mazoCompleto,
     *  es decir con las 52 cartas de una baraja
     *  inglesa. Este mazo ya estaria barajeado.
     *  @return Una lista de 52 cartas diferentes.
     */
    public TDAList<Carta> mazoCompleto(){
        // Creamos la lista de cartas
        TDAList<Carta> mazo= new DoubleLinkedList<>();
        //
        TDAList<String> agregados= new DoubleLinkedList<>();
        // Objetos Random para poder elegir números al azar
        Random random1= new Random();
        Random random2=new Random();
        String palo="";
        int valor=0;
        String paraBuscar=valor+palo;
        // iterador para seguir creando cartas hasta que nuestro mazo este completo
        while(mazo.size()!=52){
            while(agregados.contains(paraBuscar)){
            int paloNum=0; // un numero pra poder usar random y asignar el palo a la cartas
            /* Este while es necesario porque nextInt 
             * crea valores desde 0 y necesitamos 
             * que empiecen en 1. */
            while(valor==0 || paloNum==0){ 
            valor= random1.nextInt(13); // genera un numero random entre [0,13)
            paloNum= random2.nextInt(5); // genera un numero random entre [0,5)
            }
            /* En este switch asignaremos al numero 
             * generado random su determinado valor en String*/
            switch(paloNum){
                case 1:
                    palo= "Picas";
                    break;
                case 2:
                    palo= "Corazones";
                    break;
                case 3:
                    palo= "Diamantes";
                    break;
                case 4:
                    palo= "Treboles";
                    break;
            }
        }
            
            Carta carta= new Carta(palo,valor);
            mazo.add(0,carta);
            agregados.add(0,paraBuscar);
            
        }
        return mazo; // Se regresa el mazo  ya completo
    }

    // FUNCIONA PERO ES LENTISIMO CUANDO PONES 52 CARTAS
    /** Metodo para construir un mazoCompleto,
     *  es decir con las 52 cartas de una baraja
     *  inglesa. Este mazo ya estaria barajeado.
     *  @return Una lista de 52 cartas diferentes.
     */
    /*public TDAList<Carta> mazoCompleto(){
        // Creamos la lista de cartas
        TDAList<Carta> mazo= new DoubleLinkedList<>();
        // En este String se almacenas las cartas ya agregadas
        String cartasAgregadas="";
        // Objetos Random para poder elegir números al azar
        Random random1= new Random();
        Random random2=new Random();
        // iterador para seguir creando cartas hasta que nuestro mazo este completo
        while(mazo.size()!=52){
            int valor=0; // el valor que tendra la carta
            int paloNum=0; // un numero pra poder usar random y asignar el palo a la cartas
            /* Este while es necesario porque nextInt 
             * crea valores desde 0 y necesitamos 
             * que empiecen en 1. *s/
            while(valor==0 || paloNum==0){ 
            valor= random1.nextInt(13); // genera un numero random entre [0,13)
            paloNum= random2.nextInt(5); // genera un numero random entre [0,5)
        }
            String palo=""; 
            /* En este switch asignaremos al numero 
             * generado random su determinado valor en String*s/
            switch(paloNum){
                case 1:
                    palo= "Picas";
                    break;
                case 2:
                    palo= "Corazones";
                    break;
                case 3:
                    palo= "Diamantes";
                    break;
                case 4:
                    palo= "Treboles";
                    break;
            }
            // Ver si la carta ya esta en el mazo
            String paraBuscar=valor+palo;
            // si ya esta se continua a la sig iteracion
            if(cartasAgregadas.contains(paraBuscar)){
                continue;
            }
            // si no se crea la carta y se agrega al mazo
            Carta carta= new Carta(palo,valor);
            mazo.add(0,carta);
            cartasAgregadas+=","+valor+palo; // tambien al string 
        }
        return mazo; // Se regresa el mazo  ya completo
    }*/
    public static void main(String[] args){
        Mazo p1=new Mazo();
        System.out.println(p1.mazoCompleto());        
    }

}
