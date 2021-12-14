package fciencias.edatos.proyecto02;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que implementa el juego de las 20 preguntas.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class Partida20Q{

  // COLORES                                                               
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String blue = "\033[34m";
  String yellow= "\033[33m";
  String red =  "\u001B[31m";  
  String black = "\033[30m";

  // Atributo que dice si una partida ya termino
  boolean terminada=false;

  /** Metodo para volver a guardar el arbol.
   *  @param arbol que se guardara
   */
  public void actualizarArchivo(BinaryTree arbol)throws FileNotFoundException,IOException{
    try{
      FileOutputStream fs = new FileOutputStream("ArbolCantantes.ser");//Creamos el archivo
      ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
      os.writeObject(arbol);//El método writeObject() serializa el objeto y lo escribe en el archivo
      os.close();//Hay que cerrar siempre el archivo
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  /** Metodo que hace el camino en un arbol (La partida basicamente)
	 *  @param 
	 *  @return ultNode el nodo donde termino el camino
	 */
	public Node recorrido(BinaryTree arbol)throws Exception{
		Node actual= arbol.root;
		String eleccion=""; 
		Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
		int contador=1; // Cuenta cuantas preguntas se han hecho
		// Mientras actual no sea una hoja
		while(!actual.isLeaf()){
      // Si ya llegamos a las 20 preguntas rompemos el ciclo y avisamos al jugador.
      if(contador==20){
        System.out.println("No puede ser 😭, lo siento pero no tengo idea en quien piensas lo siento");
        this.terminada=true; // La partida ya termino pues no se logro adivinar
        return actual;
      }
			// Le preguntamos al usuario
			System.out.println(actual.element);
			// Obtenemos la respuesta del usuario (con scanner)
			try {
				 eleccion = sc.nextLine();
			  } catch (Exception e) {
				System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
				System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
				continue;
			  }
			  System.out.println();
			  // si el usuario respondio true
			  if(eleccion.equals("true")){
				// Pasamos al actual del lado izq
				actual=actual.left;
        // Aumentamos el contador pues nos movimos de nodo
        contador++;
				continue;
			  }
			  // si el usuario respondio false
			  if(eleccion.equals("false")){
				// Pasamos al actual del lado derecho
				actual=actual.rigth;
        // Aumentamos el contador pues nos movimos de nodo
        contador++;
				continue;
			  }
			  // Para cuando el usuario no responde true o false
			  else{
					//avisar al usuario que no contesto como esperaba entonces 
					System.out.println("Recuerda solo responder true o false, para poder avanzar a la siguiente pregunta ;)");
			  }
		}
		// Cuando ya llegamos a una hoja preguntamos si adivinamos
    boolean aux=true;
    while(aux){
      System.out.println(actual.element);
      try {
        eleccion = sc.nextLine();
       } catch (Exception e) {
         System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
         System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
       }
       System.out.println();
       // si el usuario respondio true
       if(eleccion.equals("true")){
        // Ya se adivino en quien piensa y celebramos 
        System.out.println(green+"Yeii Adivinator adivino en quien estabas pensando "+purple+"🔮"+white);
        return actual;
        }
        // si el usuario respondio false
        if(eleccion.equals("false")){
          //La pregunta nueva
          String pregunta;
          // cantante
          String cantante;
          // siOno
          boolean siOno;
  
          // No se pudo adivinar quien es entonces hay que agregar un nuevo nodo
          System.out.println("oh oh creo que no sé en quien piensas 😥 \n Ayudame a mejorar 🙏");
          // Obtenemos en quien pensaba
          System.out.println("¿En quién estabas pensando?");
          cantante= sc.nextLine();
          // Pedimos la pregunta
          System.out.println("Ingresa una pregunta que pueda identificar a "+cantante+
           " y que se pueda responder con true o false: ");
          pregunta=sc.nextLine();
          System.out.println("Ahora ayudame respondiendo la siguiente pregunta con true o false:\n"+cantante+
          " cumple que "+pregunta);
          siOno=Boolean.parseBoolean(sc.nextLine());
          // Ahora insertamos la nueva pregunta
          arbol.insert(actual,pregunta,cantante,siOno);
        }
        // Para cuando el usuario no responde true o false
        else{
          //avisar al usuario que no contesto como esperaba entonces 
          System.out.println("Recuerda solo responder true o false, para poder avanzar");
          continue;
        }
        aux=false;
    }

      return actual;
	}
    
    public static void main(String[] args){
        // creamos una partida
        Partida20Q p1=new Partida20Q();
      // esto es como para escribir en el doc y lo que use para crearlos
       /* 
        // Creamos al nuevo arbol
        BinaryTree a1= new BinaryTree();
        // Insertamos 
        a1.insertFirst("¿La persona en la que estas pensando forma parte de un grupo o banda?","Tyler Joseph","Ariana Grande");
        a1.insert(a1.root.rigth,"¿Canta pop?","Bad buny",false);
        a1.insert(a1.root.left,"¿Es mujer?","Lisa (Blackpink)",true);
        a1.insert(a1.root.rigth.left,"¿Tiene más de 21 años?","Olivia Rodrigo",false);
        a1.insert(a1.root.left.left,"¿Canta en español?","Melissa Robles",true);
        // System.out.println("La raiz es  "+a1.root.element);
        // System.out.println("El hijo derecho de la raiz  "+a1.root.rigth.element);
        // System.out.println("El hijo derecho de   "+a1.root.rigth.element+" es"+a1.root.rigth.rigth.element);
        // System.out.println("El hijo izq de   "+a1.root.rigth.element+" es"+a1.root.rigth.left.element);
        a1.preorden();
       // a1.postorden();
        try{
            FileOutputStream fs = new FileOutputStream("ArbolCantantes.ser");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            os.writeObject(a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.close();//Hay que cerrar siempre el archivo
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
          }
       */
       ///*
      // aqui es ya donde se pueden hacer cosas
        try{
            // Creamos a un objeto que tenga al aarchivo de nuestr arbol
            FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
            // Este es el que procesa los datos
            ObjectInputStream entrada=new ObjectInputStream(fileIn);
            // Guardamos al arbol 
            BinaryTree a1=(BinaryTree)entrada.readObject();
            // Hacemos las operaciones que queremos
            
            System.out.println();
            try{
             p1.recorrido(a1);
             }catch (Exception e) { }
             a1.preorden();
             // Volvemos a escribir el archivo 
              p1.actualizarArchivo(a1);
           
            
            // Cerramos 
            entrada.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
          }catch(ClassNotFoundException e){
            e.printStackTrace();
          }
        // */
    }
}