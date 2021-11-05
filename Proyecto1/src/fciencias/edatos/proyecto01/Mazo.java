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
    //  public TDAList<Carta> mazoCompleto(){
    //     // Creamos la lista de cartas
    //     TDAList<Carta> mazo= new DoubleLinkedList<>();
    //     //
    //     TDAList<String> agregados= new DoubleLinkedList<>();
    //     // Objetos Random para poder elegir números al azar
    //     Random random1= new Random();
    //     Random random2=new Random();
    //     String palo="";
    //     int valor=0;
    //     String paraBuscar=valor+palo;
    //     // iterador para seguir creando cartas hasta que nuestro mazo este completo
    //     while(mazo.size()!=5){
    //         while(agregados.contains(paraBuscar)){
    //         int paloNum=0; // un numero pra poder usar random y asignar el palo a la cartas
    //         /* Este while es necesario porque nextInt 
    //          * crea valores desde 0 y necesitamos 
    //          * que empiecen en 1. */
    //         while(valor==0 || paloNum==0){ 
    //         valor= random1.nextInt(13); // genera un numero random entre [0,13)
    //         paloNum= random2.nextInt(5); // genera un numero random entre [0,5)
    //         }
    //         /* En este switch asignaremos al numero 
    //          * generado random su determinado valor en String*/
    //         switch(paloNum){
    //             case 1:
    //                 palo= "Picas";
    //                 break;
    //             case 2:
    //                 palo= "Corazones";
    //                 break;
    //             case 3:
    //                 palo= "Diamantes";
    //                 break;
    //             case 4:
    //                 palo= "Treboles";
    //                 break;
    //         }
    //     }
            
    //         Carta carta= new Carta(palo,valor);
    //         mazo.add(0,carta);
    //         agregados.add(0,paraBuscar);
            
    //     }
    //     return mazo; // Se regresa el mazo  ya completo
    // } 

    // FUNCIONA PERO ES LENTISIMO CUANDO PONES 52 CARTAS
    /** Metodo para construir un mazoCompleto,
     *  es decir con las 52 cartas de una baraja
     *  inglesa. Este mazo ya estaria barajeado.
     *  @return Una lista de 52 cartas diferentes.
     */
    //      public TDAList<Carta> mazoCompleto(){
    //     // Creamos la lista de cartas
    //     TDAList<Carta> mazo= new DoubleLinkedList<>();
    //     // En este String se almacenas las cartas ya agregadas
    //     String cartasAgregadas="";
    //     // Objetos Random para poder elegir números al azar
    //     Random random1= new Random();
    //     Random random2=new Random();
    //     // iterador para seguir creando cartas hasta que nuestro mazo este completo
    //     while(mazo.size()!=52){
    //         int valor=0; // el valor que tendra la carta
    //         int paloNum=0; // un numero pra poder usar random y asignar el palo a la cartas
    //         /* Este while es necesario porque nextInt 
    //          * crea valores desde 0 y necesitamos 
    //          * que empiecen en 1. */
    //         while(valor==0 || paloNum==0){ 
    //         valor= random1.nextInt(13); // genera un numero random entre [0,13)
    //         paloNum= random2.nextInt(5); // genera un numero random entre [0,5)
    //     }
    //         String palo=""; 
    //         /* En este switch asignaremos al numero 
    //          * generado random su determinado valor en String*/
    //         switch(paloNum){
    //             case 1:
    //                 palo= "Picas";
    //                 break;
    //             case 2:
    //                 palo= "Corazones";
    //                 break;
    //             case 3:
    //                 palo= "Diamantes";
    //                 break;
    //             case 4:
    //                 palo= "Treboles";
    //                 break;
    //         }
    //         // Ver si la carta ya esta en el mazo
    //         String paraBuscar=valor+palo;
    //         // si ya esta se continua a la sig iteracion
    //         if(cartasAgregadas.contains(paraBuscar)){
    //             continue;
    //         }
    //         // si no se crea la carta y se agrega al mazo
    //         Carta carta= new Carta(palo,valor);
    //         mazo.add(0,carta);
    //         cartasAgregadas+=","+valor+palo; // tambien al string 
    //     }
    //     return mazo; // Se regresa el mazo  ya completo
    // } 

    /** Metodo para construir un mazoCompleto (SIN BARAJEAR),
     *  es decir con las 52 cartas de una baraja
     *  inglesa.
     * **/
    public TDAList<Carta> mazoCompleto(){
         // Creamos la lista de cartas
         TDAList<Carta> mazo= new DoubleLinkedList<>();
         String palo="Picas";

        //los siguientes fors son para agregar todas las cartas de cada palo

         for(int i=1;i<=13;i++){
           
             Carta carta = new Carta(palo,i);
             mazo.add(0,carta);
         }


          palo= "Treboles";
         for(int i=1;i<=13;i++){
            
             Carta carta = new Carta(palo,i);
             mazo.add(0,carta);
         } 
         palo= "Corazones";
         for(int i=1;i<=13;i++){
           
             Carta carta = new Carta(palo,i);
             mazo.add(0,carta);
         }
         
         palo= "Diamantes";
         for(int i=1;i<=13;i++){
           
             Carta carta = new Carta(palo,i);
             mazo.add(0,carta);
         } 


         //Dianis no se xq no lo pude hacer en un solo for como que intentaba ir cambiando el valor de palo pero no se xq no me cambiaba el valor que raro :(.🥺
         return mazo;
    }
         
    /**Método para barajear el mazo completo 
     * se creara una nueva lista donde pondremos las cartas en un orden aleatorio
     */
    public TDAList<Carta> mazoCompletoBarajeado(){
        //lista no barajeada
        TDAList<Carta> mazo = mazoCompleto(); 
        //Creamos lista que sera la barajeada
        TDAList<Carta> mazoCompletoBarajeado= new DoubleLinkedList<>();
        // cresamos el objeto random
        Random random1= new Random();
        // el valor random
        int valor;
        for(int i=0;i<52;i++){

            //generemos un valor random entre [0,size) 
            valor= random1.nextInt(mazo.size());
           

            //este caso es por al llegar a la iteración numero 51 es decir a la ultima me mandaba una excepción si quieres pruebalo comentando todo ese if ,
            // y funfionaba pero no daba la ultima carta, la vdd no se muy bien a que se deba como que el problema era en el remove cuando la lista del mazo
            //  era igual a 1 su size
            if(mazo.size()==1){
               // System.out.println(mazo.get(0));
                mazoCompletoBarajeado.add(0,mazo.get(0));
                break;
            }
            //agregamos en la primera posicion algun elemento aleatorio de la lista mazo completa ya que remueve de valor devuelve un elemento aleatorio.
            mazoCompletoBarajeado.add(0,mazo.remove(valor));
           // System.out.println(mazo.size());
        }
        
        //System.out.println(mazoCompletoBarajeado.size());
        return mazoCompletoBarajeado;    
    }
    public static void main(String[] args){
        Mazo p1=new Mazo();
        System.out.println(p1.mazoCompleto()+ "\n");   
        System.out.println(p1.mazoCompletoBarajeado());      
    }

}
