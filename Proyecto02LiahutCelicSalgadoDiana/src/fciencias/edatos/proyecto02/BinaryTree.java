package fciencias.edatos.proyecto02;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Clase que implementa las operaciones sobre un arbol
 * binario que se utilizara especificamente para el 
 * juego de las 20 preguntas.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class BinaryTree implements Serializable{

	/**
	 * Nodo para un árbol binario.
	 */
	public class Node implements Serializable{

		/** Elemento. */
		public String element;

		/** Padre del nodo. */
		public Node parent;

		/** Hijo izquierdo. */
		public Node left;

		/** Hijo derecho. */
		public Node rigth;

		/** Hora y fecha de creación del nodo */
		public String horaFecha;

		/**
		 * Crea un nuevo nodo.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public Node(String element, Node parent){
			this.element = element;
			this.parent = parent;
			this.horaFecha=getHoraFecha();
		}

		/** Metodo para intercambiar el elemento de un nodo.
		 *  @param e elemento por el que se cambiara.
		 */
		public void setElement(String e){
			this.element=e;
		}

		/** Metodo que intercambia los elementos de dos nodos
		 *  @param a nodo a intercambiar con this.
		 */
		public void swap(Node a){
			// Variable auxiliar que guarda al elemento del nodo a.
			String elemA= a.element;
			// Se cambia el elemento  del nodo a por el elemento del nodo con el que se llama.
			a.setElement(this.element);
			// Se cambia el elemento del nodo con el que se llama por el elemento del nodo a.
			this.setElement(elemA);
		}

		/** MEtodo que obtien la fecha y la hora actual
		 *  @return horaFecha */
		public String getHoraFecha(){
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		}


		/** Metodo para saber si un nodo es una hoja o no
		 *  @return un booleano true si es hoja, false en otro caso
		 */
		public boolean isLeaf(){
			return this.left==null && this.rigth==null;
		}
	}

	// COLORES
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String azul = "\033[34m";
  String yellow = "\033[33m";
  String red = "\u001B[31m";

	/** Root */
	public Node root;

	/** Metodo para obtener la el elemento de la raiz
	 *  @return El elemento
	 */
	public String getRootElement(){
		return root.element;
	}

	/** Metodo para obtener a la raiz
	 *  @return regresa a la raiz 
	 */
	public Node getRoot(){
		return root;
	}

	/** Método para insertar la primera pregunta en un arbol.
	 *  @param pregunta la pregunta con la que se iniciara el arbol. 
	 *  @param respuestaSi la nueva hoja (respuesta) que se agregara cuando la resp a la pregunta es sí
	 *  @param respuestaNo la nueva hoja (respuesta) que se agregara cuando la resp a la pregunta es no
	 */
	public void insertFirst(String pregunta, String respuestaSi,String respuestaNo){
		root= new Node(pregunta,null);
		root.left= new Node("¿Es "+respuestaSi+"?",root);
		root.rigth= new Node("¿Es "+respuestaNo+"?",root);
	}


	/** Método para insertar una nueva pregunta en un arbol.
	 *  @param actual el nodo donde se termino la ejecucción 
	 *  (es decir el nodo que se sera el hermano del nuevo)
	 *  NOTA: el nodo que pasa como parametro siempre sera una hoja
	 *  @param pregunta la nueva pregunta que se agregara. 
	 *  @param respuesta la nueva hoja (respuesta) que se agregara ej. ¿es un pez?
	 *  @param siOno true si la respuesta va del lado del si (izq), false si va del lado del no (derecho)
	 */
	public void insert(Node actual, String pregunta, String respuesta,boolean siOno ){
		//Creamos a los nodos nuevos
		Node nPregunta= new Node(pregunta,actual.parent); // el nuevo nodo con la pregunta
		Node nHoja= new Node("¿Es "+respuesta+"?",nPregunta); // El nuevo animal agregado

		// AHORA TENEMOS QUE ACOMODARLOS EN EL ARBOL 

		// Si es hijo Izq
		if(actual.parent.left==actual){ 
			// Entonces se asigna a la nueva pregunta como el nuevo hijo izq del padre de actual
			actual.parent.left=nPregunta;
		}
		else{ // Si es hijo derecho 
			// Entonces se asigna a la nueva pregunta como el nuevo hijo derecho del padre de actual
			actual.parent.rigth=nPregunta;
		}
		// Ahora tenemos que asignar a las respuestas en el lugar correcto
		if(siOno){
		nPregunta.left=nHoja;
		nPregunta.rigth=actual;
		}else{
		nPregunta.left=actual;
		nPregunta.rigth=nHoja;
		}

	}


	/** Metodo que hace el camino en un arbol
	 *  @param 
	 *  @return ultNode el nodo donde termino el camino
	 */
	public void recorrido()throws Exception{
		Node actual= this.root;
		// Mientras actual no sea una hoja
		while(!actual.isLeaf()){
			Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
			String eleccion; 
			// Le preguntamos al usuario
			System.out.println(actual.element);
			// Obtenemos la respuesta del usuario (con scanner)
			try {
				 eleccion = sc.nextLine();
			  } catch (Exception e) {
				System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
				System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
				sc.nextLine();
				continue;
			  }
			  sc.nextLine();
			  System.out.println();
			  // si el usuario respondio true
			  if(eleccion.equals("true")){
				// Pasamos al actual del lado izq
				actual=actual.left;
				continue;
			  }
			  // si el usuario respondio false
			  if(!eleccion.equals("false")){
				// Pasamos al actual del lado derecho
				actual=actual.rigth;
				continue;
			  }
			  // Para cuando el usuario no responde true o false
			  else{
					//avisar al usuario que no contesto como esperaba entonces 
					System.out.println("Recuerda responder true o false, para poder avanzar a la siguiente pregunta ;)");
			  }
		}
	}

	/** Metodo que ordena una lista alfabeticamente
	 * 
	 */ 


	/**
	 * Recorre el árbol en preorden.
	 */
  	public void preorden() {
  	  preOrdenAux(this.root);
  	}

	/** Auxiliar del metodo preOrden
	 *  @param actual El nodo en donde se encuentra el iterador
	 */
  	public void preOrdenAux(Node actual) {
  	  //mientras el nodo actual no sea null
  	  if (actual != null) {
  	    // Primero verifica la raiz
  	    System.out.print(actual.element + " ");
  	    // Aplica preorden al izquierdo
  	    preOrdenAux(actual.left);
  	    // Aplica preorden al derecho
  	    preOrdenAux(actual.rigth);
  	  }
  	}

  	
	/**
	 * Recorre el árbol en inorden.
	 */
  	public void inorden() {
  	  inordenAux(this.root);
  	}
	
	/** Auxiliar del metodo inOrden
	 *  @param actual El nodo en donde se encuentra el iterador
	 */
  	public void inordenAux(Node actual) {
  	  //mientras el nodo actual no sea null
  	  if (actual != null) {
  	    // aplica inorden al  hijo izquierdo
  	    inordenAux(actual.left);
  	    //verifica la raiz
  	    System.out.print(actual.element + " ");
  	    // Aplica inorden al hijo derecho
  	    inordenAux(actual.rigth);
  	  }
  	}
	
	/**
	 * Recorre el árbol en postorden.
	 */
  	public void postorden() {
  	  postOrdenAux(this.root);
  	}
	
	/** Auxiliar del metodo postOrden
	 *  @param actual El nodo en donde se encuentra el iterador
	 */
  	public void postOrdenAux(Node actual) {
  	  //mientras el nodo actual no sea null
  	  if (actual != null) {
  	    // aplica ipostordenal  hijo izquierdo
  	    postOrdenAux(actual.left);
  	    // Aplica postorden al hijo derecho
  	    postOrdenAux(actual.rigth);
  	    //verifica la raiz
  	    System.out.print(actual.element + " ");
  	  }
  	}
	
	
}