package fciencias.edatos.proyecto02;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
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
	static final long serialVersionUID = 1L;

	// COLORES
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String blue = "\033[34m";
  String yellow = "\033[33m";
  String red = "\u001B[31m";

	/** Root */
	public Node root;


	public String listOfQuestions = " ";
	
 	int numeroDeNodosSinHojas;

	 int numeroDeNodos;

	 int numeroDeHojas;
	TDAList<Node> listaDeNodosEnOrdenEnQueLlegaron= new DoubleLinkedList<>();

	

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
		listaDeNodosEnOrdenEnQueLlegaron.add(0,root);
		//long inicio = System.currentTimeMillis();
		root.left= new Node(respuestaSi,root);
		//root.left= new Node("¿Es "+respuestaSi+"?",root);
		listaDeNodosEnOrdenEnQueLlegaron.add(0,root.left);
		root.rigth= new Node(respuestaNo,root);
		//root.rigth= new Node("¿Es "+respuestaNo+"?",root);
		listaDeNodosEnOrdenEnQueLlegaron.add(0,root.rigth);
		numeroDeNodos = numeroDeNodos + 3;
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
		Node nHoja= new Node(respuesta,nPregunta); // El nuevo cantante agregado
		//Node nHoja= new Node("¿Es "+respuesta+"?",nPregunta); // El nuevo cantante agregado
		numeroDeNodos = numeroDeNodos + 2;
		// AHORA TENEMOS QUE ACOMODARLOS EN EL ARBOL 

		// Si es hijo Izq
		if(actual.parent.left==actual){ 
			// Entonces se asigna a la nueva pregunta como el nuevo hijo izq del padre de actual
			actual.parent.left=nPregunta;
			listaDeNodosEnOrdenEnQueLlegaron.add(0,actual.parent.left);
			// System.out.println("SE ASIGNO A "+nPregunta.element+" COMO HIZQ DE  "+actual.parent.element);
			// System.out.println("Hijo derecho de "+actual.parent.element+" es  "+actual.parent.rigth.element);
		}
		if(actual.parent.rigth==actual){ // Si es hijo derecho 
			// Entonces se asigna a la nueva pregunta como el nuevo hijo derecho del padre de actual
			actual.parent.rigth=nPregunta;
			listaDeNodosEnOrdenEnQueLlegaron.add(0,actual.parent.rigth);
		}
		// hacemos que el padre del actual sea el nuevo nodo 
		actual.parent=nPregunta;
		// Ahora tenemos que asignar a las respuestas en el lugar correcto
		if(siOno){
		nPregunta.left=nHoja;
		listaDeNodosEnOrdenEnQueLlegaron.add(0,nPregunta.left);
		nPregunta.rigth=actual;
		}else{
		nPregunta.left=actual;
		nPregunta.rigth=nHoja;
		listaDeNodosEnOrdenEnQueLlegaron.add(0,nPregunta.rigth);
		}

	}

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

	
	/** Método para imprimr las preguntas alfabeticamente.
	 */
	public void AlphabetizeTheQuestions() {
		listOfQuestions = " ";
	  numeroDeNodosSinHojas=numeroDeNodos;
	  //String[] listOfQuestionsOrdenada = new String[]
  	  postOrdenAuxSave(this.root);
		
		//Quitamos los espacios del inicio y al final
		listOfQuestions = listOfQuestions.trim();
		
		//creamos un arreglo el cual contenga las diviciones de cada que se encuentre un "¿"
		String[] listOfQuestionsOrdenada = listOfQuestions.split("¿");
		// Uh detallido de usar spli es que divide el arreglo en partes iguales pero crea uno de mas por como divide,
		// entonces por ejemplo si son 5 preguntas en lugar de que el array sea de 5 sera de 6 
		Arrays.sort(listOfQuestionsOrdenada);
		//System.out.println(listOfQuestionsOrdenada[1]);
		
		//System.out.println(listOfQuestionsOrdenada.length+"holis");
		String preguntasOrdenadas="";
		//para darle formato al String
		for(int i=1;i<listOfQuestionsOrdenada.length;i++){
			
			preguntasOrdenadas= ""+preguntasOrdenadas+green+"- "+white+ "¿"+listOfQuestionsOrdenada[i] + "\n";
		}
		System.out.println(preguntasOrdenadas);
		
  	}
	
	/** Auxiliar del metodo AlphabetizeTheQuestions, va recorriendo el árbol en
	 * postorden para asi guadar las preguntas unicamente las que no son hojas
	 *  @param actual El nodo en donde se encuentra el iterador
	 */
  	public void postOrdenAuxSave(Node actual) {
		  
  	  //mientras el nodo actual no sea null
  	  if (actual != null) {
  	    // aplica postordenal  hijo izquierdo
  	    postOrdenAuxSave(actual.left);
  	    // Aplica postorden al hijo derecho
  	    postOrdenAuxSave(actual.rigth);
  	    //verifica la raiz
		  if(actual.left != null && actual.rigth!= null){
		  //System.out.println(listOfQuestions);
		  listOfQuestions += actual.element + " ";

		  }else{
			 // System.out.println("p");
			  numeroDeNodosSinHojas--;
			//  System.out.println("p");
		  }
		
		 
  	  }
  	}

	  /** Metodo que imprime las preguntas sin hojas en orden en como llegaron */
	  public void imprimirEnOrdenEnQueLlegaronSinHojas(){
	  String aux="";
	  Node actual;
	  for(int i = listaDeNodosEnOrdenEnQueLlegaron.size()-1 ; i >= 0;i--){
	
		actual = listaDeNodosEnOrdenEnQueLlegaron.get(i);
	   // aux = get
		if(actual.left != null && actual.rigth!= null){
			System.out.println(green+"- "+white+actual.element+"\t\t"+purple+actual.horaFecha+white);
		}
	  }
	  System.out.println("\n");
	}


	/**
	 * Método que imprime las hojas en el orden en que llegaron
	 */
	public void imprimirHojasEnOrdenEnQueLlegaron(){
		String aux="";
		Node actual;
		for(int i = listaDeNodosEnOrdenEnQueLlegaron.size()-1 ; i >= 0;i--){
			actual = listaDeNodosEnOrdenEnQueLlegaron.get(i);
		 // aux = get
		  if(actual.left == null && actual.rigth== null){
			  System.out.println(green+"- "+white+actual.element+"\t\t"+purple+actual.horaFecha+white);
		  }
		  
		}
		System.out.println("\n");
		//System.out.println("\n");
	  }
	
	

	public void AlphabetizeTheAnswers() {
	//numeroDeNodosSinHojas=numeroDeNodos;
	//String[] listOfQuestionsOrdenada = new String[]
	listOfQuestions = " ";
	//System.out.println(listOfQuestions);
	  postOrdenAuxAlphabetizeTheAnswers(this.root);
	  //System.out.println(listOfQuestions);
	  
	  //Quitamos los espacios del inicio y al final
	  listOfQuestions = listOfQuestions.trim();
	  
	  //creamos un arreglo el cual contenga las diviciones de cada que se encuentre un "¿"
	  String[] listOfQuestionsOrdenada = listOfQuestions.split(",");
	  // Uh detallido de usar spli es que divide el arreglo en partes iguales pero crea uno de mas por como divide,
	  // entonces por ejemplo si son 5 preguntas en lugar de que el array sea de 5 sera de 6 
	  Arrays.sort(listOfQuestionsOrdenada);
	  //System.out.println(listOfQuestionsOrdenada[1]);
	  
	  //System.out.println(listOfQuestionsOrdenada.length+"holis");
	  String preguntasOrdenadas="";
	  //para darle formato al String
	  for(int i=1;i<listOfQuestionsOrdenada.length;i++){
		  
		  preguntasOrdenadas= white+preguntasOrdenadas+green+"- "+white+listOfQuestionsOrdenada[i] + "\n";
	  }
	  System.out.println(preguntasOrdenadas);
	  
	}
  
  /** Auxiliar del metodo AlphabetizeTheQuestions, av recorriendo el árbol en
   * postorden para asi guadar las preguntas unicamente las que no son hojas
   *  @param actual El nodo en donde se encuentra el iterador
   */
	public void postOrdenAuxAlphabetizeTheAnswers(Node actual) {
		
	  //mientras el nodo actual no sea null
	  if (actual != null) {
		// aplica postordenal  hijo izquierdo
		postOrdenAuxAlphabetizeTheAnswers(actual.left);
		// Aplica postorden al hijo derecho
		postOrdenAuxAlphabetizeTheAnswers(actual.rigth);
		//verifica la raiz
		if(actual.left == null && actual.rigth== null){
		//System.out.println(listOfQuestions);
		//System.out.println("p");
		listOfQuestions +=  ","+actual.element;


	}
	  
	   
	  }
	}
 } 
