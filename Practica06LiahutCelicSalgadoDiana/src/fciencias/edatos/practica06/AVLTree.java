package fciencias.edatos.practica06;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

/**
* Implementación de árbol AVL
 * @version 1.0 Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class AVLTree<K extends Comparable, T> implements TDABinarySearchTree<K, T>{

	// COLORES
	String green = "\033[32m";
	String white = "\u001B[0m";
	String purple = "\033[35m";
	String azul = "\033[34m";
	String yellow = "\033[33m";
	String red = "\u001B[31m";
	/**
	 * Nodo de un arbol AVL.
	 */
	public class AVLNode{

		/** Altura del nodo. */
		public int altura;

		/** Hijo izquierdo. */
		public AVLNode izquierdo;

		/** Hijo derecho. */
		public AVLNode derecho;

		/** Padre del nodo. */
		public AVLNode padre;

		/** Elemento almacenado en el nodo. */
		public T elemento;

		/** Clave del nodo. */
		public K clave;

		/**
		 * Crea un nuevo nodo AVL
		 * @param element el elemento a almacenar.
		 * @param key la clave del nodo.
		 * @param padre el padre del nodo
		 */
		public AVLNode(T element, K key, AVLNode padre){
			elemento = element;
			clave = key;
			this.padre = padre;
			altura = this.getAltura();
		}

		/**
		 * Calcula la altura del nodo.
		 */
		public int getAltura(){
			// Si este nodo es hoja
			if(izquierdo == null && derecho==null){
				return 0;
			} else if(izquierdo != null && derecho != null){ // Dos hijos
				int max = izquierdo.getAltura() > derecho.getAltura() ? izquierdo.getAltura() : derecho.getAltura();
				return 1 + max;
			} else{ // Tiene solo un hijo
				boolean tieneIzquierdo = izquierdo!=null;
				return 1 + (tieneIzquierdo ? izquierdo.getAltura() : derecho.getAltura());
			}
		}

		/**
		 * Actualiza la altura del nodo.
		 */
		public void actualizaAltura(){
			this.altura = this.getAltura();
		}
	}

	private AVLNode raiz;


	/**Metodo que balancea desde un nodo hasta la raiz con las reglas de un arbol AVL
	 * @param actual el nodo apartir del cual se realizara el balanceo
	 * @return el nodo balanceado
	 */
	 public AVLNode rebalancear(AVLNode actual){

	//	System.out.print("pruebita");
		actual.actualizaAltura();

		if(actual.altura< 2){
			if(actual.padre == null){
			 
				//this.raiz= actual;
				//System.out.println("prueba");
				return actual;
			}
			

		return rebalancear(actual.padre);
			
		}



		//En caso en que este desbalanceador entra al if para balancearlo
		if( Math.abs(actual.izquierdo.getAltura() - actual.derecho.getAltura())> 1){
			AVLNode nuevo=null;
			//desbalance a la izquierda
			if(actual.izquierdo.getAltura() - actual.derecho.getAltura() > 1){

				//caso 1
				//desbalance a la izquierda caso 1(linea recta)
				if(actual.izquierdo.izquierdo.getAltura() >= actual.izquierdo.derecho.getAltura()){
					//  se gira actual a la derecha
				    nuevo= rotarALaDerecha(actual);
					System.out.println("a");
				
							
				}
				//caso 2 
				//if(getAltura(actual.izquierdo.izquierdo) < getAltura(actual.left.right)
				else{
					actual.izquierdo= rotarALaIzquierda(actual.izquierdo);
					rotarALaDerecha(actual);
					nuevo=actual;
					System.out.println("b");
					//rebalancear(actual.padre);
				}

			}

			//desbalance a la derecha
			if (actual.derecho.getAltura() - actual.izquierdo.getAltura() > 1){

				//caso 3
				//desbalance a la derecha caso 1 (linea recta)
				if(actual.derecho.derecho.getAltura() >= actual.derecho.izquierdo.getAltura()){
					rotarALaIzquierda(actual);
					nuevo = actual;
					System.out.println("c");
					//rebalancear(actual.padre);
				}

				else{
                    actual.derecho=rotarALaDerecha(actual.derecho);
					rotarALaIzquierda(actual);
					nuevo= actual;
					System.out.println("d");
					//rebalancear(actual.padre);
				}

			}
			


			//rebalancear(actual.padre);
			//return;
			if(actual.padre == null)
					{
						this.raiz = nuevo;
						return raiz;
					}

		}


		 if(actual.padre == null){

		System.out.print("prueba2\n");
			return actual;
		} 
	
		return rebalancear(actual.padre);
		

	}  

	/**Método que rota a la izquierda un nodo
	 * @param actual el nodo que que rotara
	 * @return el nodo rotado 
	 */
	public AVLNode rotarALaIzquierda(AVLNode actual){
		AVLNode nuevo = actual.derecho;
        actual.derecho = nuevo.izquierdo;
        nuevo.izquierdo = actual;
		actual.actualizaAltura();
		nuevo.actualizaAltura();
		actual= nuevo;
		return actual;
		// System.out.println(green+"");
		// preorden(actual);
		// System.out.println(white+"");
	} 
	
	

	/**Método que rota a la derecha un nodo
	 * @param actual el nodo que que rotara
	 * @return el nodo rotado 
	 */
	public AVLNode rotarALaDerecha(AVLNode actual){
		// Guardamos al papá del nodo actual
		AVLNode aux=actual.padre;
		// Definimos a y b
		AVLNode a=actual.izquierdo;
		AVLNode b=actual;
		// Caso donde a es null (es decir el arbol quedaria igual)
		if(a==null){
			return actual;
		}
		// Convertimos a  en padre de b}
		b.padre=a;
		// Ahora el subarbol derecho de a es el subarbol izq de actual(b)
		b.izquierdo=a.derecho;
		// Falta decirle a el subarbol derecho que su padre ahora es b
		// Para esto checamos si el subarbol derecho es null ya que de ser asi no se puede acceeder al padre de algo null
		if(a.derecho!=null){
			a.derecho.padre=b;
		}
		// Luego le tenemos que decir a que su hijo derecho es b
		a.derecho=b;
		
		// Por ultimo tenemos que reconectar a la rotacion con el resto del arbol o en su defecto asignar a la nueva raiz
		if(aux==null){ // Entonces b era la raiz
			this.raiz=a; // cambiamos a como la nueva raiz
			// Como ahora a es la raiz su padre tiene que ser null
			a.padre=null;
		}
		// Este es el caso cuando no se hizo una rotación en la raiz
		else{
			// el padre de b ahora es el padre de a
			a.padre=aux;
			// si actual era hijo derecho
			if(aux.derecho==actual){
				// entonces ahora su nuevo hijo derecho es a
				aux.derecho=a;
			}else{ // si acual era hijo izquierdo
				// entonces ahora su nuevo hijo izq es a
				aux.izquierdo=a;
			}
		}
		return a; // La verdad no estoy segura de que es lo que se tendria que devolver en este
		//Tampoco sé muy bien que onda con las alturas si se cambian aqui o no 

	
	} 
	
/* 	public AVLNode rotarALaDerecha(AVLNode actual){
		AVLNode nuevo = actual.izquierdo;
        actual.izquierdo = nuevo.derecho;
        nuevo.derecho= actual;
		actual.actualizaAltura();
		nuevo.actualizaAltura();
		actual= nuevo;
		System.out.println("\n");
		//preorden(actual);
		return actual;
	
	}  */

	public void printTree(){
        if(raiz == null){
                         System.out.println ("árbol vacío");
        } else {
            printTree(raiz);
        }
    }

    public void printTree(AVLNode t){
        if(t != null){
            printTree(t.izquierdo);
            System.out.print(t.elemento + " ");
            printTree(t.derecho);
        }
    }

	@Override
	public T retrieve(K k){
		
		AVLNode aux =retrieve(k,raiz);
		if(aux ==null){
			return null;
		}else{
			return aux.elemento;
		}

	}

	public AVLNode retrieveNodo(K k){
		
		AVLNode aux =retrieve(k,raiz);
		if(aux ==null){
			return null;
		}else{
			return aux;
		}

	}

	/**
	 * Obtenia el nodo con una clave específica.
	 * @param k la clave a buscar
	 * @param actual el nodo actual
	 * @return el nodo con clave k o null si no existe.
	 */
	private AVLNode retrieve(K k, AVLNode actual){
		// Verificamos que actual es null
		if(actual == null){
			return null;
		}

		int compare = k.compareTo(actual.clave);

		// Si existe el elemento
		if(compare == 0){
			return actual;
		}

		if(compare < 0){ // Caso del hijo izquiero
			return retrieve(k, actual.izquierdo);
		} else { // Caso del hijo derecho
			return retrieve(k, actual.derecho);
		}
	}

	@Override
	public void insert(T e, K k){
		if(raiz == null){ // Arbol vacío
			raiz = new AVLNode(e, k, null);
			return;
		}
		AVLNode v = insert(e, k, raiz);


		// Rebalancear a partir de v hasta raiz
		//rebalancear(v);
		
	
	}

	/**
	 * Inserta un nodo de forma recursiva.
	 * @param e el elemento a insertar
	 * @param k es la clave del nodo a insertar
	 * @param actual el nodo actual
	 * @return 
	 */
	public AVLNode insert(T e, K k, AVLNode actual){
		if(k.compareTo(actual.clave)<0){ // Verificamos sobre el izquierdo
			if(actual.izquierdo == null){ // Insertamos en esa posición
				actual.izquierdo = new AVLNode(e, k, actual);
				return actual.izquierdo;
			} else { // Recursión sobre el izquierdo
				return insert(e, k, actual.izquierdo);
			}
		} else{ // Verificamos sobre la derecha
			if(actual.derecho == null){ // Insertamos en esa posición
				actual.derecho = new AVLNode(e, k, actual);
				return actual.derecho;
			} else { // Recursión sobre el derecho
				return insert(e, k, actual.derecho);
			}
		}
	}

	@Override
	public T delete(K k){
		AVLNode v = retrieve(k, raiz);

		// El elemento que queremos eliminar no está en el árbol
		if(v == null){
			return null;
		}

		T eliminado = v.elemento;

		// Eliminar con auxiliar
		AVLNode w = delete(v);

		// Rebalancear
		//rebalancea(w);
		//rebalancear(w);

		return eliminado;
	}


	private AVLNode delete(AVLNode v){
		if(v.izquierdo!=null && v.derecho!=null){ // Tiene dos hijos
			AVLNode menor = findMin(v.derecho);
			swap(menor, v);
			return delete(menor);
		} else if(v.izquierdo==null && v.derecho==null){ // No tiene hijos
			boolean esIzquierdo = v.padre.izquierdo==v;
			if(esIzquierdo){
				v.padre.izquierdo = null;
			} else{
				v.padre.derecho = null;
			}
			return v.padre;
		} else{ // Sólo tiene un hijo
			boolean hijoIzquierdo = v.izquierdo!=null;
			if(hijoIzquierdo){
				swap(v, v.izquierdo);
				return delete(v.izquierdo);
			} else{
				swap(v, v.derecho);
				return delete(v.derecho);
			}
		}
	}

	@Override
	public T findMin(){

		// if (this.raiz == null) {
		// 	return null;
		//   }
		//return AVLNode(raiz).elemento;
		return findMin(raiz).elemento;
	}

	/**
	 * Obtiene al nodo con la menor clave implementado de forma iterativa
	 * @param actual el nodo actual
	 * @return el nodo con clave la clave k de menor valor.
	 */
	private AVLNode findMin(AVLNode actual){
		if(actual == null)
			return null;
		AVLNode iterador = actual;

		while(iterador.izquierdo != null){
			iterador =iterador.izquierdo;
		}

		return iterador;
		// Mientras sí tenga hijo izquierdo -> Que actual se mueva al izquierdo
		// if (!(actual.izquierdo == null)) {
		// 	//System.out.println("p"+actual.element);
		// 	//System.out.println("p");
		// 	actual = actual.izquierdo;
		// 	//System.out.println(actual.element);
		// 	return findMin(actual);
		//   }
		//   // Ya encontramos al nodo con clave menor, asi que se regresa
		//   return actual;
	}

	/* public T findMinIterativo(){

		if (this.raiz == null) {
			return null;
		  }
		//return AVLNode(raiz).elemento;
		return findMin(raiz).elemento;
	}
	private AVLNode findMinIterativo(AVLNode actual){

	} */
	private void swap(AVLNode v, AVLNode w){
		T value = v.elemento;
		K clave = v.clave;
		v.elemento = w.elemento;
		v.clave = w.clave;
		w.elemento = value;
		w.clave = clave;
	}

	@Override
	public T findMax(){
		return findMax(raiz).elemento;
		//return null;
	}

	private AVLNode findMax(AVLNode actual){
		if(actual == null)
			return null;
		AVLNode iterador = actual;

		while(iterador.derecho != null){
			iterador =iterador.derecho;
		}

		return iterador;
	}


	@Override
	public void preorden(){
		preorden(raiz);
	}

	/**
	 * Metodo auxiliar del metodo preOrden
	 * @param actual el nodo actual
	 */
	private void preorden(AVLNode actual){
		if(actual==null)
			return;

		System.out.print(actual.elemento + " ");
		preorden(actual.izquierdo);
		preorden(actual.derecho);
	}

	@Override
	public void inorden(){
		inorden(raiz);
	}

	/**
	 * Metodo auxiliar del metodo inOrden
	 * @param actual el nodo actual
	 */
	private void inorden(AVLNode actual){
		if(actual==null)
			return;
		
		inorden(actual.izquierdo);
		System.out.print(actual.elemento+ " ");
		inorden(actual.derecho);
	}

	@Override
	public void postorden(){
		postorden(raiz);
	}

	/**
	 * Metodo auxiliar del metodo postOrden
	 * @param actual el nodo actual
	 */
	private void postorden(AVLNode actual){
		if(actual==null)
			return;
		
		postorden(actual.izquierdo);
		postorden(actual.derecho);
		System.out.print(actual.elemento+ " ");
	}

	@Override
	public boolean isEmpty(){
		return raiz==null; // si la raiz es null regresa true, false en otro caso.
	}

	public static void main(String[] args) {
		 // COLORES
		 String green = "\033[32m";
		 String white = "\u001B[0m";
		 String purple = "\033[35m";
		 String azul = "\033[34m";
		 String yellow = "\033[33m";
		 String red = "\u001B[31m";
		AVLTree<Integer, Integer> arbol = new AVLTree<>();
		AVLTree a1 = new AVLTree();
		// arbol.insert(50, 50);
		// //System.out.println(green+"\n");
		// arbol.preorden();
		// arbol.insert(60, 60);
		// //System.out.println(green+"\n");
		// arbol.preorden();
		// arbol.insert(40, 40);
		// //System.out.println(green+"\n");
		// arbol.preorden();
		// arbol.insert(45, 45);
		// //System.out.println(green+"\n");
		// arbol.preorden();
		// //System.out.println(green+"\n");
        // arbol.insert(35, 35);
		// //System.out.println(green+"\n");
		// arbol.preorden();
		// arbol.insert(30, 30);
		// arbol.preorden();
		// //arbol.insert(15, 15);
		// arbol.preorden();
		// System.out.println(arbol.raiz.elemento);
		// System.out.println("holis");
		// arbol.insert(42, 42);
		
		// arbol.preorden();
		// arbol.insert(47, 47);
		// arbol.preorden();
		// System.out.println("\n");
		// //arbol.printTree();

	//	arbol.insert(3, 3);
		//System.out.println(green+"\n");
		//arbol.preorden();
	//	arbol.insert(2, 2);
		//System.out.println(green+"\n");
		//arbol.preorden();
	//	arbol.insert(5, 5);
		//System.out.println(green+"\n");
		//arbol.preorden();
		//arbol.insert(1, 1);
		//System.out.println(green+"\n");
		//arbol.preorden();
		//System.out.println(green+"\n");
      //  arbol.insert(4, 4);
		//System.out.println(green+"\n");
		//arbol.preorden();
	//	arbol.insert(6, 6);

		//arbol.preorden();
		//arbol.rotarALaDerecha(arbol.retrieveNodo(3));

	  // arbol.raiz= arbol.rotarALaDerecha(arbol.retrieveNodo(50));

	//	System.out.println(green+"p");
		//arbol.preorden();

		// AVLTree<Integer, Integer> arbol2 = new AVLTree<>();
		// System.out.println(arbol2.insert(50, 50).altura);
		// arbol2.insert(40, 40);
		// arbol2.insert(70, 70);
		// arbol2.insert(60, 60);
        // arbol2.insert(80, 80);
		// arbol2.rotarALaIzquierda(arbol2.retrieveNodo(50));
		// System.out.println("\n");
		//arbol.preorden();

		// arbol.insert(9, 9);
		// arbol.insert(12, 12);
		// arbol.insert(3, 3);
		// arbol.insert(4, 4);
        // arbol.insert(2, 2);
		//System.out.println(arbol.retrieveNodo(12).getAltura());
		//System.out.println(arbol.raiz.padre);

		// arbol.insert(2, 2);
		// arbol.insert(5, 5);
		// //arbol.insert(1, 1);
		// arbol.insert(11, 11);
		// arbol.insert(14, 14);
		// arbol.insert(15, 15);


		//System.out.println(arbol.findMin());

		//System.out.println(arbol.findMax());
		Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
		// INICIO DEL MENU
		System.out.println(yellow + "Bienvenido al Menu ツ\n no esta implementado el balanceo porque por más que intentamos no nos salió por más que intentamos 🥺" + white + "\n");
		int eleccion = 0;
    	int aux = 0;
    	//String aux2 = "";
		int aux2;
		do {
			System.out.println(
			  azul + "Elige algunas de las siguientes opciones:" + white
			);
	  
			System.out.print(
			  green +
			  "[1]" +
			  white +
			  "Método retrieve: Buscar a un elemento a partir de su clave (key) \n" +
			  green +
			  "[2]" +
			  white +
			  "Insertar a un nuevo elemento al árbol\n" +
			  green +
			  "[3]" +
			  white +
			  "Eliminar un elemento del árbol\n" +
			  green +
			  "[4]" +
			  white +
			  "Encuentra el elemento con clave minima\n" +
			  green +
			  "[5]" +
			  white +
			  "Encontrar el elemento con clave máxima\n" +
			  green +
			  "[6]" +
			  white +
			  "Ordenar el árbol con preOrden\n" +
			  green +
			  "[7]" +
			  white +
			  "Ordenar el árbol con inOrden\n" +
			  green +
			  "[8]" +
			  white +
			  "Ordenar el árbol con postOrden\n" +
			  green +
			  "[9]" +
			  white +
			  "Saber si árbol esta vacio\n" +
			  green +
			  "[10]" +
			  white +
			  "Salir del menu\n"
			);
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
			  case 1:
				try {
				  System.out.println("ingresa la clave");
				  aux = sc.nextInt();
				  if(a1.retrieve(aux) == null){
					System.out.println(red +"En el arbol no existe un nodo con tal clave 😩\n" +white);
					break;
				  }
				  System.out.println("El elemento con esa clave es: " + a1.retrieve(aux));
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
				break;
			  case 2:
				try {
				  System.out.println("ingresa la clave");
				  aux = sc.nextInt();
				  sc.nextLine();
				  System.out.println("ingresa el elemento, que sea un int");
				  aux2 = sc.nextInt();
				  a1.insert(aux2, aux);
				} catch (InputMismatchException ime) {
				  System.out.println(red + "\tNo ingresaste un entero" + white);
				  System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
				  sc.nextLine();
				  continue;
				}// } catch (Exception e) {
				//   System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
				//   System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
				//   sc.nextLine();
				//   continue;
				// }
	  
				break;
			  // opcion 3 (salir)
			  case 3:
				try {
				  System.out.println(
					"ingresa la clave del elemento que quieres eliminar 🥺"
				  );
				  aux = sc.nextInt();
				  sc.nextLine();
				  a1.delete(aux);
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
	  
				break;
			  case 4:
				if (a1.findMax() == null) {
				  System.out.println(
					red +
					"Este arbol  esta vacio, por lo que no se puede determinar el elemento con la clave mayor , F\n" +
					white
				  );
				  break;
				}
				System.out.println(
				  "En el arbol el elemento conclave máxima es: \n" +
				  a1.findMax()
				);
				break;
			  case 5:
				if (a1.findMin() == null) {
				  System.out.println(
					red +
					"Este arbol esta vacio, por lo que no se puede determinar cual es el elemento con la clave menor , F\n" +
					white
				  );
				  break;
				}
				System.out.println(
				  "En el arbol el elemento con la clave menor es: \n" +
				  a1.findMin()
				);
				break;
			  case 6:
				if (a1.raiz == null) {
				  System.out.println("Este arbol esta vacio, F loser 🤪\n");
				  break;
				}
				System.out.print("El arbol ordenado en preorden es: \n");
				a1.preorden();
				System.out.println();
				// System.out.println(a1.raiz);
				break;
			  case 7:
				if (a1.raiz == null) {
				  System.out.println("Este arbol esta vacio, F loser 🤪\n");
				  break;
				}
				System.out.print("El arbol ordenado en inOrden es: \n");
				a1.inorden();
				System.out.println();
				//System.out.println(a1.raiz);
				break;
			  case 8:
				if (a1.raiz == null) {
				  System.out.println("Este arbol esta vacio, F loser 🤪\n");
				  break;
				}
				System.out.print("El arbol ordenado en postOrden es: \n");
				a1.postorden();
				System.out.println();
	  
				//System.out.println(a1.raiz);
				break;
			  case 9:
				if (a1.isEmpty() == true) {
				  System.out.println("Este arbol esta vacio, F loser 🤪\n");
				  break;
				} else {
				  System.out.println("Este arbol no esta vacio 🙊");
				}
	  
				//System.out.println(a1.raiz);
				break;
			} // final switch principal
			//  System.out.println();
	  
			// System.out.print(white+"\n 🌈 " + red+" Gracias por usar el programa "+ white+ "🌈\n"+white);
		  } while (eleccion != 10); //final do .. while principal
		  System.out.print(
			white +
			"\n 🌈 " +
			red +
			" Gracias por usar el programa " +
			white +
			"🌈\n" +
			white
		  );
	
		// arbol.delete(9);
		// arbol.delete(12);
		// arbol.delete(5);

		// arbol.preorden();
		
	}
	
    
}
