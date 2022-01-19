package fciencias.edatos.practica07;


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

    /**
     * 
     */
    public CalculadoraMM(){
        Lector l1= new Lector();
        this.mapaTP=l1.convierteAmapa();
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
        CalculadoraMM p1=new CalculadoraMM();
        //primero accedemos a la lista de elementos con la clave k 
        //DoubleLinkedList lista=mapaTP.get("Na");
       
        System.out.println("Na.O3. "+p1.calculaMM("Na.O3"));
        System.out.println("K2.H3.I. "+p1.calculaMM("K2.H3.I"));
        
        // Nota ya solo falta el menú 
        // y poner un parte ahi en el menu que sea que si el metodo regresa -1 quiere decir que la cadena que se ingreso no es valida
        // también poner en las instrucciones qque entre cada elemento hay que poner un punto.
        
    }
}
