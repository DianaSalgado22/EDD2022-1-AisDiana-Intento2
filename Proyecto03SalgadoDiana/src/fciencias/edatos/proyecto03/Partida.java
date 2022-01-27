package fciencias.edatos.proyecto03;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Path;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


/**
 * Clase que ejecuta el main de una competencia de escritura - proyecto 03
 * @version 1.Enero 2022.
 * @author Celic Aislinn Liahut Ley
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */
public class Partida extends Thread{


    // COLORES:
    String blue = "\033[34m";
    String green = "\033[32m";
    String yellow = "\033[33m";
    String red = "\033[31m";
    String purple = "\033[35m";
    String cyan = "\033[36m";
    String white = "\u001B[0m";

    // Atributos:
    private Scanner sc = new Scanner(System.in);
    private SecuenciaLetras sl=new SecuenciaLetras();
    private Checador ch=new Checador();
    private PedirPalabras pp=new PedirPalabras();
    public DoubleLinkedList<String> listaCorrectas=new DoubleLinkedList();
        /**
         * Metodo que da inicio a los hilos del cronometro y el pedirle las respuestas al usuario
         */
        public void comienza(){
		pp.start();
        this.delay70Segundos();
	    }

        public void delay70Segundos(){
            try {
                Thread.sleep(70000);
            } catch (Exception e) {
                
            }
        }
		

        /**
         * Metodo que separa las palabras validas de ls que no
         */
        public void filtra(){
            //Recorremos la lista con las palabras mientras no este vacia
            while (!this.pp.listaTodas.isEmpty()) {
                // Obtenemos la palabra en la pos 0 y la eliminamos
                String palabra=this.pp.listaTodas.remove(0);
                // Verificamos si la palabra en valida o no
                if(ch.wordIsValid(this.pp.secuencia,palabra)){
                    // Si es una palabra valida y además no esta en la lista, la agregamos 
                    if(!listaCorrectas.contains(palabra)){
                        listaCorrectas.add(0, palabra);
                    }  
                }
                //si no es correcta o ya esta solo continuamos.  
            }
        }

        /**
         * Metodo que imprime los puntajes de una secuencia en especifico.
         * @param secuencia a la que se le imprimira el puntajes
         */
        public void toStringInd(String secuencia)throws FileNotFoundException,IOException,ClassNotFoundException{
            try{
              // Guardamos al arbol 
              BinarySearchTree<String,Jugador[]> arbolP=leeArchivo();
              //Primero obtenemos el arreglo que tiene como llave esa secuencia
              Jugador[] arr=arbolP.retrieve(secuencia);
              for(int i = 0; i < arr.length; i++) {
                  Jugador j=arr[i];
                  switch (i) {
                      case 0:
                        if(j==null){
                          System.out.println(yellow+"🏆"+blue+" 𝟭 .- "+white);
                        }else{
                          System.out.println(yellow+"🏆"+blue+" 𝟭 .- "+purple+j.nombre+" : "+white+j.puntos+" puntos.");
                        }
                        break;
                      case 1:
                        if(j==null){
                          System.out.println(yellow+"🏆"+blue+" 𝟮 .- "+white);
                        }else{
                          System.out.println(blue+"  𝟮 .- "+purple+j.nombre+" : "+white+j.puntos+" puntos.");
                        }
                        break;
                      case 2:
                        if(j==null){
                          System.out.println(yellow+"🏆"+blue+" 𝟯 .- "+white);
                        }else{
                          System.out.println(blue+"  𝟯 .- "+purple+j.nombre+" : "+white+j.puntos+" puntos.");
                        }
                        break;
                  }
              }
              
            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException e){
              e.printStackTrace();
            }
            
        }
        
        public void toStringTodos()throws FileNotFoundException,IOException,ClassNotFoundException{
            try{
                // Guardamos al arbol 
                BinarySearchTree<String,Jugador[]> arbolP=leeArchivo();
                preorden(arbolP);
                
              }catch(FileNotFoundException e){
                e.printStackTrace();
              }catch(IOException e){
                e.printStackTrace();
              }catch(ClassNotFoundException e){
                e.printStackTrace();
              }
        }

        public void preorden(BinarySearchTree<String,Jugador[]> arbol) {
            
            System.out.println(blue+"\t\t🅴 🆂 🆃 🅰 🅳 🅸 🆂 🆃 🅸 🅲 🅰 🆂  🅳 🅴 🅻  🅹 🆄 🅴 🅶 🅾"+white);
            // Aplica preorden al derecho
            try {
                preOrdenAux(arbol.root);
            } catch (Exception e) {
                //TODO: handle exception
            }
          }
        
          public void preOrdenAux(BinarySearchTree<String,Jugador[]>.BinaryNode actual)throws FileNotFoundException,IOException,ClassNotFoundException {
            //mientras el nodo actual no sea null
            try{
                if (actual != null) {
                    System.out.println(actual.key);
                    // Primero obtenemos la secuencia y aplicamos el to string ind
                    toStringInd(actual.key);
                    // Aplica preorden al izquierdo
                    preOrdenAux(actual.left);
                    // Aplica preorden al derecho
                    preOrdenAux(actual.rigth);    
                }
                
              }catch(FileNotFoundException e){
                e.printStackTrace();
              }catch(IOException e){
                e.printStackTrace();
              }catch(ClassNotFoundException e){
                e.printStackTrace();
              }
              
            
          }


        /**
         * Método para agregar un nuevo puntaje 
         */
        public void addPuntaje(String nombre,int pts,String secuencia)throws FileNotFoundException,IOException,ClassNotFoundException{
            try{
              // Obtenemos el arbol 
              BinarySearchTree<String,Jugador[]> arbolP= leeArchivo();
              // Checamos si el arbol ya tiene un arreglo con la clave secuencia
              Jugador[] arr=arbolP.retrieve(secuencia);
              //si no existe el arreglo
              if(arr==null){
                //Creamos un arreglo de Jugadores de longitud 3 
                Jugador arreglo[]= new Jugador[3];
                //Creamos un Jugador 
                Jugador j1=new Jugador(nombre, pts);
                // Como es el primer jugador que juega con esta secuencia pues es el lugar num.1
                arreglo[0]=j1;
                //agregamos el arreglo al arbol
                arbolP.insert(arreglo,secuencia);
              }else{
                // Si la secuencia ya se encuentra tenemos que checar si algún lugar cambia 
                for (int i=0;i<arr.length;i++){
                    if(arr[i].puntos<pts){
                      //Creamos un Jugador 
                      Jugador j1=new Jugador(nombre, pts);  
                      arr[i]=j1;
                    }   
            }
              }
              //Como se hicieron cambios guardamos el archivo
              serializar(arbolP);
            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException e){
              e.printStackTrace();
            }
          }
        
          
        /**
         * Metodo que genera la ruta para llegar al archivo serializado
         * @return una cadena con la ruta.
         */
        public static String path(){
            //S.O
            String so=System.getProperty("os.name");
            //ruta
            String filePath=System.getProperty("user.dir");
            // dependiendo si es linux o windows
            if(so.contains("Windows")){
                filePath+="\\src\\fciencias\\edatos\\proyecto03\\";
            }
            if(so.contains("Linux")){
                filePath+="/src/fciencias/edatos/proyecto03/";
            }
            return filePath;
        }
        /**
         * Metodo para serializar un arbol de arreglos
         * @param arbol
         * @throws FileNotFoundException
         * @throws IOException
         */
        public static void serializar(BinarySearchTree<String,Jugador[]> arbol)throws FileNotFoundException,IOException{
          try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path()+"ArbolPuntajes.ddr"))){
            // Aqui en el write es donde se cicla pq sí me crea el archivo
            os.writeObject(arbol);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.close();//Hay que cerrar siempre el archivo
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
          }
        }
        /**
         * Metodo para leer un archivo serializado
         * @throws FileNotFoundException
         * @throws IOException
         */
        public BinarySearchTree<String,Jugador[]> leeArchivo()throws ClassNotFoundException,FileNotFoundException,IOException{
            //Creamos el arbol que regresaremos 
            BinarySearchTree<String,Jugador[]> arbolP=null;
            try{
              // Creamos a un objeto que tenga al aarchivo de nuestr arbol
              FileInputStream fileIn=new FileInputStream(path()+"ArbolPuntajes.ddr");
              // Este es el que procesa los datos
              ObjectInputStream entrada=new ObjectInputStream(fileIn);
              // Guardamos al arbol 
               arbolP=(BinarySearchTree<String,Jugador[]>)entrada.readObject();
               entrada.close();
            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException cnfe){
                cnfe.printStackTrace();
            }
            return arbolP;
          }
        
        
       

        
        public static void main(String[] args){
        
        // COLORES
        String green = "\033[32m";
        String white = "\u001B[0m";
        String purple = "\033[35m";
        String blue = "\033[34m";
        String yellow = "\033[33m";
        String red = "\u001B[31m";
        // Empieza el menú
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
        SecuenciaLetras sl=new SecuenciaLetras() ;   
        Partida p1=new Partida();
        
    
        
        // INICIO DEL MENU
        System.out.println(white + "Bienvenido a The cheetah game"+yellow+" 🐆 " + white + "\n");
        int eleccion = 0;
        
        do {
          System.out.println("\n"+
            blue + "Elige algunas de las siguientes opciones:" + white
          );
        
          System.out.print( 
            green +"[1]" +white +"Jugar\n" +
            green +"[2]" +white +"Instrucciones\n" +
            green +"[3]" +white +"Estadisticas del juego\n" +
            green +"[4]" +white +"Salir\n" );
          try {
            eleccion = sc.nextInt();
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          }
          sc.nextLine();
          System.out.println();
        
          switch (eleccion) {
            case 1:  // Jugar
            boolean aux=true;
            // Creamos la secuencia
            while(aux){
                System.out.println("¿Quieres una secuencia de letras random?");
                String resp=sc.nextLine();
                resp=resp.toLowerCase();
                if(resp.equals("true")|| resp.equals("sí") || resp.equals("si")){
                    p1.pp.secuencia=sl.generateRandom9();
                    aux=false;
                    
                }else{
                    if(resp.equals("false")|| resp.equals("no")){
                        while(aux){
                            System.out.println("Ingresa una secuencia de 9 letras:");
                            p1.pp.secuencia=sc.nextLine();
                            p1.pp.secuencia=sl.isValid(p1.pp.secuencia);
                            if(p1.pp.secuencia!=null){
                                aux=false;
                            }
                            else{
                                System.out.println("\n"+red+"Secuencia invalida"+white+"\n");
                            }
                        }
                    }else{
                        System.out.println(red+"Por favor responde con si o no ;)"+white);
                    }
                }
                
            }
            // Empezamos la partida como tal (es decir el tiempo y el pedir las palabras
            p1.comienza();
            // Ahora checamos que palabras son validas y cuales no
            p1.filtra();
            // Caculamos el total de puntos
            int puntaje=p1.ch.calcularPuntajeTotal(p1.listaCorrectas);
            // Le decimos el puntaje al jugador
            System.out.println(yellow+"\t Tu puntaje fue de: "+green+puntaje+white);
            System.out.println();
            //Preguntamos el nombre del jugador
            System.out.println(purple+"¿Cuál es tu nombre?"+white);
            String nombre=sc.nextLine();
            try{

                //Agregamos el puntaje del jugador
                p1.addPuntaje(nombre, puntaje,p1.pp.secuencia);
                //Imprimimos el ranking de esta secuencia en especifico
                p1.toStringInd(p1.pp.secuencia);
  
              }catch(FileNotFoundException e){
                e.printStackTrace();
              }catch(IOException e){
                e.printStackTrace();
              }catch(ClassNotFoundException e){
                e.printStackTrace();
              }catch(IllegalThreadStateException ite){
                System.out.println(red+"Lo sentimos ocurrio un error innesperado"+white);
              }catch(Exception e){
                System.out.println(red+"Lo sentimos ocurrio un error innesperado"+white); 
              }
            
            break;

            case 2: // Instrucciones
              System.out.println(blue+"\t\t\t--- I N S T R U C C I O N E S ---"+white);
              System.out.print(
              "A partir de una secuencia aleatoria de 9 letras, escribe la  mayor cantidad de palabras.\n"+
              "Mientras más larga la palabra, más puntos vale, de tal forma que al final de un minuto,\n"+ 
              "el que tenga la puntuacion más alta sera coronado como el primer lugar en la tabla de estadisticas.");
              break;
            
            case 3: // Estadisticas del juego
               
                try{

                    //Imprimimos todos los puntajes
                    p1.toStringTodos();
                
                }catch(FileNotFoundException e){
                  e.printStackTrace();
                }catch(IOException e){
                  e.printStackTrace();
                }catch(ClassNotFoundException e){
                  e.printStackTrace();
                }
                break;

            
          } // final switch principal

        } while (eleccion != 4); //final do .. while principal
        System.out.print(
          white +
          "\n 🌈 " +
          yellow +
          " Gracias por jugar The cheetah game" +
          white +
          "🌈\n" +
          white);
  }

}
