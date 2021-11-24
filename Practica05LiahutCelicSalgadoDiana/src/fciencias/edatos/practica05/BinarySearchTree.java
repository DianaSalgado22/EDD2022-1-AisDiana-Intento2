package fciencias.edatos.practica05;
/**
 * Clase que implementa las operaciones sobre un arbol
 * binario de busqueda.
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class BinarySearchTree<K extends Comparable<K>, T> implements TDABinarySearchTree<K, T>{
	
	/**
	 * Nodo para un árbol binario de búsqueda.
	 */
	public class BinaryNode{

		/** Clave. */
		public K key;

		/** Elemento. */
		public T element;

		/** Padre del nodo. */
		public BinaryNode parent;

		/** Hijo izquierdo. */
		public BinaryNode left;

		/** Hijo derecho. */
		public BinaryNode rigth;

		/**
		 * Crea un nuevo nodo.
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public BinaryNode(K key, T element, BinaryNode parent){
			this.key = key;
			this.element = element;
			this.parent = parent;
		}

		/** Metodo para intercambiar el elemento de un nodo.
		 *  @param e elemento por el que se cambiara.
		 */
		public void setElement(T e){
			this.element=e;
		}

		/** Metodo que intercambia los elementos de dos nodos
		 *  @param a nodo a intercambiar con this.
		 */
		public void swap(BinaryNode a){
			// Variable auxiliar que guarda al elemento del nodo a.
			T elemA= a.element;
			// Se cambia el elemento del nodo a por el elemento del nodo con el que se llama.
			a.setElement(this.element);
			// Se cambia el elemento del nodo con el que se llama por el elemento del nodo a.
			this.setElement(elemA);
		}
	}

	/** Root */
	private BinaryNode root;

	public T getRootElement(){
		return root.element;
	}

	public BinaryNode getRoot(){
		return root;
	}

	//retrieve es como get
	@Override
	public T retrieve(K k){
		BinaryNode node = retrieve(root, k);
		if(node == null)
			return null;
		return node.element;
	}

    /** Metodo auxiliar del metodo retrieve.
     *  @param actual el nodo donde se empieza a buscar 
     *  (Al usarse como auxiliar representa hasta donde se ha buscado).
     *  @param k la llave del nodo que se busca dentro del arbol.
     */
	private BinaryNode retrieve(BinaryNode actual, K k){
		// No se encuentra el elemento
		if(actual == null)
			return null;

		// Si encontramos el elemento
		if(actual.key.compareTo(k) == 0)
			return actual;

		// Comparamos los elementos
		if(k.compareTo(actual.key) < 0){ // Verificamos en la izquierda
			return retrieve(actual.left, k);
		} else { // Verificar en la derecha
			return retrieve(actual.rigth, k);
		}
	}

	@Override
	public void insert(T e, K k){
		// Si es vacío 
        if(this.isEmpty()){
            // Se crea el nodo binario y se asigna a la raiz del arbol.
            this.root= new BinaryNode(k,e,null); 
            return; // se termina el metodo pues ya se inserto el elemento.
        }
        // Si no es vacio
		// Crear un nodo iterador que comience en la raíz
        BinaryNode iterador= this.root;
		// Invocar el método insert de tres parámetros
        insert(iterador,e,k);
	}
	
    /** Metodo auxiliar del metodo insert.
     *  @param actual el nodo hasta donde se esta buscando la posición en que se insertara el nodo.
     *  @param e el elemento del nodo que se insertara.
     *  @param k la llave del nodo que se insertara.
     */
	private void insert(BinaryNode actual, T e, K k){
		// Comparamos las claves: la clave de actual con k. Con compareTo
        int i = actual.key.compareTo(k);
		// Si actualK >= k compareTo regresa un numero positivo o cero. SI K ES menor O = SE AGREGA A LA IZQ.
        if(i>=0){
            // Verificamos si el hijo izquierdo es null
            if(actual.left==null){
                // Si sí insertamos el nuevo elemento como hijo izquierdo del actual.
                actual.left = new BinaryNode(k,e,actual);
                return; // se termina el metodo pues ya se inserto el elemento.
            }
            // Si no es null continuamos con la recursión sobre el hijo izquierdo
            insert(actual.left,e,k);
        }
		// Si actualK < k compareTo regresa un número negativo. SI K ES MAYOR SE AGREGA A LA DERECHA
        if(i<0){
            // Verificamos si el hijo derecho es null
            if(actual.rigth==null){
                // Si sí insertamos el nuevo elemento como hijo derecho del actual.
                actual.rigth = new BinaryNode(k,e,actual);
                return; // se termina el metodo pues ya se inserto el elemento.
            }
            // Si no es null continuamos con la recursión sobre el hijo derecho
            insert(actual.rigth,e,k);
        }	
	}

	//@Override
	// public T delete(K k){
	// 	// Se busca al nodo en el arbol con el metodo retireve.
	// 	BinaryNode nodoPorBorrar=retrieve(root,k); // regresa el nodo con la clave k o null.
	// 	if(nodoPorBorrar==null){
	// 		/* Si el resultado de retrieve es null el elemento que 
	// 		 * se quiere robar no se encuentrar en el arbol asi que 
	// 		 * se regresa null. */
	// 		return null;
	// 	}
	// 	// Variable que almacena al elemento con la clave k
	// 	T elemento= nodoPorBorrar.element;
		
	// 	// Casos que puede tener el nodo por borrar:
		
	// 	//Cuando tiene dos hijos (Ninguno de sus hijos es null).
	// 	if(nodoPorBorrar.left!=null && nodoPorBorrar.rigth!=null){
	// 		// Buscamos al maximo de los mínimos
	// 		BinaryNode maxDmin= findMax(nodoPorBorrar.left);
	// 		// To me: recuerda que finMin regresa T, se necesita adaptar para que regrese un node
	// 		// hacemos un swap actual con el maximo de los mínimos
	// 		nodoPorBorrar.swap(maxDmin);
	// 		// eliminar el nodo con el que se hizo swap
	// 		remove(maxDmin); // TO ME: esto no me convence al 100%
	// 	}

	// 	// Cuando no tiene hijos (Ambos hijos son null).
	// 	if(nodoPorBorrar.left==null && nodoPorBorrar.rigth==null){
	// 		// Verificar si es hijo izquierdo o es hijo derecho
	// 		BinaryNode padre=nodoPorBorrar.parent; // Primero obtenemos al padre
	// 		/* Si el nodo que se quiere borrar 
	// 		 * es el unico nodo en el arbol,
	// 		 * entonces al borrarlo quedara un arbol vacio.
	// 		 */
	// 		if(padre==null){
	// 			this.root=null; // En este caso root==nodoPorBorrar.S
	// 		}
	// 		// Si es hijo izquierdo:
	// 		if(padre.left==nodoPorBorrar)
	// 			padre.left=null; // hacer null el izquierdo del padre
	// 		// Si es hijo derecho
	// 		if(padre.rigth==nodoPorBorrar)
	// 			padre.rigth=null;// hacer null el derecho del padre
	// 	}
		
	// 	// Cuando solo tiene un hijo (Si uno de los dos no es null)
	// 	if(nodoPorBorrar.left!=null || nodoPorBorrar.rigth!=null){
	// 		// Checamos con el operador ternario si tiene hijo izq o derecho:
	// 		// Si el hijo izquierdo es null entonces tiene hijo derecho y se hace swap con él
	// 		// Si el hijo izquierdo no es null entonces tiene hijo izq y se hace swap con él
	// 		nodoPorBorrar.left=null ? nodoPorBorrar.swap(nodoPorBorrar.rigth) : nodoPorBorrar.swap(nodoPorBorrar.left);
	// 		// Borramos al hijo con el que se hizo swap. Podemos hacer null a ambos hijos
	// 		nodoPorBorrar.left=null;
	// 		nodoPorBorrar.rigth=null;
	// 	}
	// 	return elemento;
	// }

	@Override
	public T findMin(){

		BinaryNode actual = root;
		//System.out.println("p"+actual.element);
		// Verificar que no sea vacío -> return null
		if(this.root == null){
			return null;
		}
		return findMinAux(actual);
		//return actual;
	
	

		
	}

	public T findMinAux(BinaryNode actual){
		
		// if(actual.left == null){
		// 	return actual.element;
		// }
		// Mientras sí tenga hijo izquierdo -> Que actual se mueva al izquierdo
		if(!(actual.left == null)){
			//System.out.println("p"+actual.element);
			//System.out.println("p");
			actual = actual.left;
			//System.out.println(actual.element);
			findMinAux(actual);
		}
			// Ya encontramos al nodo con clave menor
			return actual.element;
		

	}

	@Override
	public T findMax(){
		BinaryNode actual = root;
		
		// Verificar que no sea vacío -> return null
		if(this.root == null){
			return null;
		}
		return findMaxAux(actual);
		
	}

	public T findMaxAux(BinaryNode actual){
		
		// if(actual.left == null){
		// 	return actual.element;
		// }
		// Mientras sí tenga hijo derecho -> Que actual se mueva al derechoo
		if(!(actual.rigth == null)){
			//System.out.println("p"+actual.element);
			//System.out.println("p");
			actual = actual.rigth;
			//System.out.println(actual.element);
			findMaxAux(actual);
		}
			// Ya encontramos al nodo con clave menor
			return actual.element;
		

	}

	@Override
	public void preorden(){
		// Primero verifica la raiz
		// Aplica preorden al izquierdo
		// Aplica preorden al derecho
	}

	@Override
	public void inorden(){}

	@Override
	public void postorden(){}

	@Override 
    public boolean isEmpty(){
        return this.root==null;
		// si root es igual a null esto es true y es true que es vacio.
    }

	public static void main(String[] args) {
		// Creamos un BST
		BinarySearchTree p1= new BinarySearchTree();
		p1.insert("X",22);
		p1.insert("A",90);
		p1.insert("D",10);
		p1.insert("Z",6);
		p1.insert("T",15);
		p1.insert("c",2);
		p1.insert("R",65);
		p1.insert("B",100);
	System.out.println("La raiz tiene la clave: "+ p1.root.key);
	System.out.println("La clave del hijo izq de la raiz : "+ p1.root.left.key);
	System.out.println("La clave del hijo derecho de la raiz : "+ p1.root.rigth.key);

	System.out.println("\n La clave del hijo izq de 10 : "+ p1.root.left.left.key);
	System.out.println("La clave del hijo derecho de de 10 : "+ p1.root.left.rigth.key);
	
	System.out.println("\n La clave del hijo izq de 90 : "+ p1.root.rigth.left.key);
	System.out.println("La clave del hijo derecho de de 90 : "+ p1.root.rigth.rigth.key);

	System.out.println("\n La clave del hijo izq de 6 : "+ p1.root.left.left.left.key);
	System.out.println("La clave del hijo derecho de de 6 : "+ p1.root.left.left.left.rigth);
	}
}