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

    // No se bien si deshacer esta clase o cambiarla un poco 


    

    /** Metodo para contruir la estructura de un mazo
     *  es decir un lista de tipo carta pero vacia.
     */
    public Mazo(){
        TDAList<Carta> mazo= new DoubleLinkedList<>();
    }
   

    // PORQUE POR EJEMPLO EN ESTOS DOS METODOS LO QUE REGRESA ES ALGO TIṔO LISTA
    // PERO EN LAS OTRAS CLASE QUEDA MEJOR SI LO QUE SE REGRESA ES ALGO TIPO MAZO
    // POR ESO MANDA EL ERROR

    
    /** Metodo para construir un mazoCompleto (SIN BARAJEAR),
     *  es decir con las 52 cartas de una baraja
     *  inglesa.
     * **/
    public TDAList<Carta> mazoCompleto(){
        // Creamos la lista de cartas
        TDAList<Carta> mazo= new DoubleLinkedList<>();
        int numPalo=0;
        String[] posiblesPalosArr= {"Picas","Corazones","Diamantes","Treboles"};

        while(numPalo<4){  // Para que haga los distintos palos (0-3)
            for(int i=1;i<=13;i++){ // para que se hagan los distintos valores (1-13)
                Carta carta= new Carta(posiblesPalosArr[numPalo],i);
                mazo.add(0,carta);
            }
            numPalo++; // Ya que creo todas las cartas del palo actual pasa al siguiente.        
        
        }
        return mazo; //Regresamos el mazo ya completo 
    }
   
         
    /** Método para barajear el mazo completo 
     *  se creara una nueva lista donde pondremos las cartas en un orden aleatorio
     */
    public TDAList<Carta>  mazoCompletoBarajeado(){
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
            /*agregamos en la primera posicion algun elemento aleatorio
             *de la lista mazo completa.
             * usamos remove ya que removemos el valor de mazo(para que no se repitan) 
             *  y se devuelve el elemento eliminado en la posicion aleatoria.*/
            mazoCompletoBarajeado.add(0,mazo.remove(valor));
           
        }
        return mazoCompletoBarajeado;    
    }

    /** Metodo para agregar una carta a un mazo
     *  @param carta la nueva carta que se añade al mazo
     */
    public void add(Carta carta){
        this.add(0,carta);
    }

    public static void main(String[] args){
        Mazo p1=new Mazo();
        System.out.println(p1.mazoCompleto()+ "\n");   
        System.out.println(p1.mazoCompletoBarajeado());      
    }

}
