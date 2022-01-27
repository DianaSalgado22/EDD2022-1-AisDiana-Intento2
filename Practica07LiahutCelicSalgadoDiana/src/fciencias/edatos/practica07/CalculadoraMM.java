package fciencias.edatos.practica07;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que contiene las operaciones para
 * calcular la masa molecular de elementos quimicos.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */


public class CalculadoraMM {

    //Colores
    static String verde = "\033[32m";
    static String blanco = "\u001B[0m";
    static String morado = "\033[35m";
    static String azul = "\033[34m";
    static String yellow= "\033[33m";
	static String rojo =  "\u001B[31m";

    // El mapa con la info
    public static AbstractHashMap<String,DoubleLinkedList<Elemento>> mapaTP;

    // Arreglo aux con los num 
    public static String num="0123456789";

    public String cadenaDeSimbolos="";

    /**
     * 
     */
    public CalculadoraMM(){
        Lector l1= new Lector();
        this.mapaTP=l1.convierteAmapa();
        this.cadenaDeSimbolos = l1.cadenaDeSimbolos();

    }

    /** Metodo que calcula la 
     *  masa molecular total de un fragmento
     *  de cadena.
     *  @param k la llave del elemento (simbolo)
     *  @param c la cantidad de moleculas
     *  @return la multiplicación del peso del eleemnto por la cant de molecula
     */
    public double calculaMMind(String k,double c){
        //primero accedemos a la lista de elementos con la clave k 
        DoubleLinkedList lista=mapaTP.get(k);
        if(lista==null){ // quiere decir que no existe el elemento con esa llave
            return -1;
        }
        //Ahora tenemos que buscar al eleemento que queremos en la lista
        Elemento elem=search(lista,k);
        
        if(elem==null){ // quiere decir que no existe el elemento con esa llave
            return -1;
        }
        // calculamos el total individual del fragmento
        double total=(elem.getPeso()*c);
        return total;
    }

    /**
     * Metodo que busca a un elemento con clave k en la lista
     * @param k la clave del elemento 
     * @param lista la lista donde se quiere buscar
     * @return null si no se encuentra o al elemento si sí.
     */
    public Elemento search(DoubleLinkedList<Elemento> lista,String k){
        DoubleLinkedList<Elemento>.IteradorLista it=lista.listIterador();
        while(it.hasNext()){
            Elemento elem=it.next();
            if(elem.getSimbolo().equals(k)){
                return elem;
            }    
        }
        return null;
    }

    /** Metodo que dice si un caracter aparece 
     *  en una cadena o no.
     *  @param c char que se quiere contar.
     *  @param s la cadena donde se busca
     *  @return true si aparece, false en otro caso.
     */
    private boolean contains(char c,String s){
        for(int i=0;i<s.length();i++){
          if(s.charAt(i)==c){
            return true;
          }
        }
        return false;
    }

    /** Metodo que procesa la cadeena de elementos
     *  dada por el usuario
     *  @param inicial cadena compuesta por numeros y letras
     *  @return la masa molecular total o -1 si la cadena no es valida
     */
    public double calculaMM(String inicial){
        // Variable donde se guardara el resultado
        double total=0;
        // Variables aux donde se guardaran los fragmentos de info
        String simbolo="";
        String cantCad="";
        //Empezamos a recorrerla para obtener los fragmentos.
        for(int i=0;i<=inicial.length();i++){
            char caracter;
            //Si aún no llegamos al final de la cadena accedemos al caracter en la posicion i
            if(i!=inicial.length()){
                caracter=inicial.charAt(i);
            }
            // Si ya es el final convertimos al caracter en un punto para que entre en el caso donde se procesa el fragmento
            else{
                caracter='.';
            }
        
            // Si es un punto quiere decir que en la variables aux ya tenemos un fragmento completo
            if(caracter=='.'){
                // Convertimos a la cadena en un numero
                int cant=0;
                //System.out.println(verde+cantCad+"  "+azul+simbolo+blanco);
                if(cantCad.equals("")){
                    cant=1;
                }else{
                    cant=Integer.parseInt(cantCad);
                }
                // Si la cant de moleculas es negativa o 0,se introdujo una cadena inicial que no es valida
                if(cant<=0){
                    return -1;
                }
                // Calculamos la masa molecular individual y la sumamos al total
                double ind=calculaMMind(simbolo, cant);
                // si no se encuentra el simbolo en el mapa el metodo regresa -1 y quiere decir que el usuario introdujo una cadena inicial no valida
                if(ind==-1){
                    return ind;
                }
               // System.out.println(simbolo+"\t"+ind+"\t"+cant);
                total+= ind;
                // Volvemos a incializar las variables aux para continuar con el siguiente fragmento
                simbolo="";
                cantCad="";
               
            }else{
                // si no guardamos la letra o el numero
                if(contains(caracter,num)){
                    cantCad+=caracter;
                }else{
                    simbolo+=caracter;
                }  
            }   
        }
        return total;
       
    }


    public static void main(String[] args) {
        // static String verde = "\033[32m";
        // static String blanco = "\u001B[0m";
        // static String morado = "\033[35m";
        // static String azul = "\033[34m";
        // static String yellow= "\033[33m";
        // static String rojo =  "\u001B[31m";
        CalculadoraMM p1=new CalculadoraMM();
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
        //primero accedemos a la lista de elementos con la clave k 
        //DoubleLinkedList lista=mapaTP.get("Na");
        int aux=0;
        int eleccion=0;
        do{
        System.out.println(morado+"Bievenido a la calculadora de masa moleculares🤓\nLos simbolos de la tabla periodica son los siguientes:"+blanco);


        
        System.out.println(p1.cadenaDeSimbolos+"\n");
            

    
        System.out.println(azul+"Ingresa el elemento quimico del que quieres calcular su masa molecular:\n"+rojo+"(Recuerda poner entre elementos quimicos un punto" + '\u0022' +"." + '\u0022'+ "para el buen fundionaiento del programa)"+blanco);
        try{
            String cadena = sc.nextLine();
            double resultado= p1.calculaMM(cadena);
            if(resultado<0){
                // System.out.println(red+"No ingresaste una cadena valida, recuerda las intruscciones 🤬\n"+blanco+"Te daremos otra oportunidad:p\n");
                // continue;
                aux= 1;
                throw new IndexOutOfBoundsException("No ingresaste una cadena valida, recuerda las intruscciones 🤬\n"+blanco+"Te daremos otra oportunidad:p\n");
               
            }
            System.out.println("La masa molecular de"+cadena+" es "+resultado+"\n");
            
        }catch (InputMismatchException ime) {
            System.out.println(rojo + "\tNo ingresaste uuna cadena\n" + blanco);
            System.out.print(verde + "\tIntenta de nuevo:)" + blanco + "\n\n");
            aux=1;
            sc.nextLine();
            continue;

        }catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
              rojo + "Ingresa algo valido porfavor 🤬\n" + blanco
            );
            aux=1;
            continue;
          }

        aux=0;

        do{
          System.out.println("¿Qué deseeas hacer?\n[1]Volver a usar el programa\n[2]Salir del progrma ");
          try{
          eleccion = sc.nextInt();
          if(eleccion == 2){
              return;
          }
          if(eleccion == 1){
              aux =1;
          }
          if(eleccion != 1 && eleccion != 2){
            throw new IndexOutOfBoundsException("No ingresaste valores validos 🤬\n"+blanco+"");
          }
        }catch(InputMismatchException ime){
            System.out.println(
                rojo + "Ingresa algo valido porfavor 🤬\n" + blanco
              );
              aux =2;
              sc.nextLine();
          }catch(IndexOutOfBoundsException ioobe){
              System.out.println("No ingresaste valores validos 🤬\n"+blanco+"\n");
              aux = 2;
              sc.nextLine();
          }
          //aux=0;
        }while(aux ==2);

        }while(aux == 1);
    
        
    }
}
